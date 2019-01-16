package PizhAir;

import PizhAir.model.Registration;
import PizhAir.model.UserData;
import PizhAir.pages.BaseFunk;
import PizhAir.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReservationticketStepDefs {

    private String surname = "Goldman";
    private String fullResponse;
    private Integer priceFromResponse;
    private String departure;
    private String destination;
    private UserData userData = new UserData();
    private int seatNumber;
    private By seatNumberPath;
    private BaseFunk baseFunk = new BaseFunk();
    private String HOME_PAGE = "http://qaguru.lv:8090/tickets/";
    private HomePage homePage;
    private final By DEPARTURE_LOCATOR = By.id("afrom");
    private final By DESTINATION_LOCATOR = By.id("bfrom");
    private final By DIRECT_TO_PAGE = By.xpath(".//span[@class='gogogo']");
    private final By REGISTRATION_FORM = By.id("fullForm");
    private final By REG_NAME = By.id("name");
    private final By REG_SURNAME = By.id("surname");
    private final By REG_DISCOUNT = By.id("discount");
    private final By REG_TREVELER = By.id("adults");
    private final By REG_CHILDREN = By.id("children");
    private final By REG_LUGGAGE = By.id("bugs");
    private final By REG_FLIGHT = By.id("flight");
    private final By GET_PRICE_BUTTON = By.xpath(".//span[@onclick='setLang();']");
    private final By PRICE_RESPONSE = By.xpath(".//div[@id='response']");
    private final By BOOK_BUTTON_2 = By.id("book2");
    private final By BOOK_BUTTON_3 = By.id("book3");
    private final By SEATS = By.id("seats");
    private final String SEAT_CHOOSE = ".//div[@onclick='seat(%s)']";
    private final By FINAL_TEXT = By.xpath(".//div[@class='finalTxt']");
    private final String finalText = "Thank You for flying with us!";
    private ReservationRequester regRequester = new ReservationRequester();
    private Registration[] responseArray;


    @Given("departure airport (.*)")
    public void set_departure_airport(String departure) {
        this.departure = departure;
    }

    @Given("destination airport (.*)")
    public void set_destination_airport(String destination) {
        this.destination = destination;
    }

    @Given("user data is:")
    public void set_user_data(Map<String, String> params) {
        userData.setName(params.get("name"));
        userData.setSurname(params.get("surname"));
        userData.setDiscountCode(params.get("discountCode"));
        userData.setTravelerCount(Integer.valueOf(params.get("travelerCount")));
        userData.setChildren(Integer.valueOf(params.get("children")));
        userData.setLuggage(Integer.valueOf(params.get("luggage")));
        userData.setNextFlight(params.get("nextFlight"));
    }

    @Given("seat number is (.*)")
    public void set_seat_number(int seatNumber) {
        this.seatNumber = seatNumber;
        this.seatNumberPath = By.xpath(String.format(SEAT_CHOOSE, seatNumber));
    }

    @Given("we are on home page")
    public void get_home_page() {
        baseFunk.goToURL(HOME_PAGE);
        homePage = new HomePage(baseFunk);
    }

    @When("we are selecting airports")
    public void selecting_airports() {
        homePage.setAirport(DEPARTURE_LOCATOR, departure);
        homePage.setAirport(DESTINATION_LOCATOR, destination);    }

    @When("we are pressing Go Go Go button")
    public void pressing_button() {
        homePage.goToRegistrationPage(DIRECT_TO_PAGE);
    }

    @Then("registration page appears")
    public void check_registration_page() {
        Assertions.assertTrue(baseFunk.getElement(REGISTRATION_FORM).isDisplayed());
    }

    @When("we are filling registration form")
    public void filling_registration_form() {
        baseFunk.getElement(REG_NAME).sendKeys(userData.getName());
        baseFunk.getElement(REG_SURNAME).sendKeys(userData.getSurname());
        baseFunk.getElement(REG_DISCOUNT).sendKeys(userData.getDiscountCode());
        baseFunk.getElement(REG_TREVELER).sendKeys(userData.getTravelerCount().toString());
        baseFunk.getElement(REG_CHILDREN).sendKeys(userData.getChildren().toString());
        baseFunk.getElement(REG_LUGGAGE).sendKeys(userData.getLuggage().toString());
        baseFunk.getElement(REG_FLIGHT).sendKeys(userData.getNextFlight());

    }

    @When("we are pressing Get Price button")
    public void pressing_getPrice_button() {
        baseFunk.getElement(GET_PRICE_BUTTON).click();

    }

    @Then("our price will be (.*) euro")
    public void price_check(Integer price) {
        fullResponse = baseFunk.getElement(PRICE_RESPONSE).getText();
        priceFromResponse = Integer.valueOf(fullResponse.substring(fullResponse.indexOf("for") + 4, fullResponse.length() - 40));
        Assertions.assertEquals(price, priceFromResponse);
    }

    @When("we are pressing Book button")
    public void pressing_book_button() {
        baseFunk.getElement(BOOK_BUTTON_2).click();
    }

    @Then("we are on page seat selecting")
    public void check_seats_page() {
        Assertions.assertTrue(baseFunk.getElement(SEATS).isDisplayed());
    }

    @When("we are selecting our seat number")
    public void selecting_seat_number() {
        baseFunk.getElement(seatNumberPath).click();
    }

    @When("we are clicking Book button")
    public void clicking_book_button() {
        baseFunk.getElement(BOOK_BUTTON_3).click();
    }

    @Then("successful registration page appears")
    public void check_registration_success_page() {
        Assertions.assertEquals(finalText, baseFunk.getElement(FINAL_TEXT).getText(), "DIFFERENT TEXT ERROR !");
    }

    @When("we are requesting registration list")
    public void requesting_reg_list() throws IOException {
        responseArray = regRequester.getRegistration();
        Assertions.assertNotNull(responseArray, "Array is null");
    }

    @Then("we can see our reservation in the list")
    public List<String> check_reservation_list() {
        List<String> idsToRemove = new ArrayList<>();

        for (int i = 0; i < responseArray.length; i++) {
            Registration registration = responseArray[i];
            if (registration.getSurname().equals(surname)) {
                idsToRemove.add(registration.getId());
            }
        }
        return idsToRemove;
    }

    @When("we are deleting our reservation ticket")
    public void deleting_reservation_ticket() {
        DeleteRequester deleteRequester = new DeleteRequester();
        deleteRequester.deleteRequest(check_reservation_list());

    }


    @When("we are requesting registration list again")
    public void requesting_registration_list_again() throws IOException {
        responseArray = regRequester.getRegistration();
        Assertions.assertNotNull(responseArray, "Array is null");
    }

    @Then("we can see our reservation is not in the list")
    public void check_reservation_is_removed() {

        List<String> IdNotInaList = new ArrayList<>();

        for (int i = 0; i < responseArray.length; i++) {
            Registration registration = responseArray[i];
            if (registration.getSurname().equals(surname)) {
                IdNotInaList.add(registration.getId());
            }
        }
        Assertions.assertTrue(IdNotInaList.isEmpty());
    }
}



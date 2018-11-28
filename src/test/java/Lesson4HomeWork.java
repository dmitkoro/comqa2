import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class Lesson4HomeWork {

    private final By CATEGORIES = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a");
    private final By DRESSES = By.xpath("//div[@id='subcategories']//a[@title='Dresses']");
    private final By COLOR_ORANGE = By.id("layered_id_attribute_group_13");
    private final String HOME_PAGE_DESKTOP = "http://automationpractice.com";
    private WebDriver driver;
    private final int CATEGORIES_COUNTER = 3;
    private final By FIRST_DRESS_COLOURS = By.xpath (".//li[contains(@class,'first-item-of-mobile-line')]//a[@class='color_pick']");
    private final By SECOND_DRESS_COLOURS = By.xpath (".//li[contains(@class,'last-line last-item-of-tablet-line')]//a[@class='color_pick']");
    private final By FILTERED_DRESSES = By.xpath (".//li[contains(@class,'ajax_block_product')]");




    @Test

    public void WomanDresses() {


        System.setProperty("webdriver.gecko.driver", "/home/dmitkoro/Documents/geckodriver");
        driver = new FirefoxDriver();
        driver.get(HOME_PAGE_DESKTOP);
        driver.manage().window().maximize();


        List<WebElement> siteCategories = driver.findElements(CATEGORIES);

        Assertions.assertFalse(siteCategories.isEmpty(), "siteCategories elements were not found !");


        for (int i = 0; i < CATEGORIES_COUNTER; i++) {

            if (siteCategories.get(i).getText().equalsIgnoreCase("WOMEN")) {

                siteCategories.get(i).click();
                break;

            }

        }

        WebElement siteDresses = driver.findElement(DRESSES);
        siteDresses.click();

        WebElement orangeColor = driver.findElement(COLOR_ORANGE);
        orangeColor.click();
        List<WebElement> filteredDresses = driver.findElements (FILTERED_DRESSES);

        List<String> listFilteredDresses = new ArrayList<String>();

        for (int i = 0; i < filteredDresses.size(); i++) {

            listFilteredDresses.add(filteredDresses.get(i).getText());

            System.out.println(" = " + filteredDresses.size());
            //newListDelfi.add(delfiArticles.get(i).getText());
        }

       //String firstDressColour = driver.findElement(FIRST_DRESS_COLOURS).getAttribute("style");

       // System.out.println("firstDressColour = " + firstDressColour);










//            Assertions.assertEquals(webArticles.get(i).getText(), myArticles.get(i), "Articles is not equals");

    }

//    @AfterEach
//    private void CloseBrowser() {
//        driver.close();
//
//    }

}


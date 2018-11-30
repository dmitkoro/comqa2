package PageObjectTest.pages;

import org.openqa.selenium.By;

public class HomePageDesktop extends HomePage {

    private final By CATEGORIES = By.xpath(".//a[@class='nav-link text-pale-sky p-2']");
    private final By COOKIES = By.xpath(".//div[@class='notification-widget cookie']");
    private final By ACCEPT_COOKIES = By.xpath(".//a[@class='close cookie']");

    public HomePageDesktop(BaseFunc baseFunc) {
        super(baseFunc);
    }


    public void acceptCookies() {
        if (baseFunc.getElement(COOKIES).isDisplayed()) {
            baseFunc.getElement(ACCEPT_COOKIES).click();
        }
    }

    public void clickCategoryByName(String categoryName) {
        super.clickCategoryByName(categoryName, CATEGORIES);
    }


}

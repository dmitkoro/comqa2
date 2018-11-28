package PageObjectTest.pages;

import org.openqa.selenium.By;

public class HomePageDesktop extends HomePage{
    private final By ARTICLE = By.xpath(".//a[@class=\'text-mine-shaft\']");
    private final By CATEGORIES = By.xpath(".//a[@class='nav-link text-pale-sky p-2']");
    private final By COOKIES = By.xpath(".//div[@class='notification-widget cookie']");
    private final By ACCEPT_COOKIES = By.xpath(".//a[@class='close cookie']");

    public HomePageDesktop(BaseFunc baseFunc) {
        super(baseFunc);
    }

//    public WebElement getArticleById (int id) {
//        return baseFunc.getElements(ARTICLE).get(id);
//    }

    public void acceptCookies() {
        if (baseFunc.getElement(COOKIES).isDisplayed()){
            baseFunc.getElement(ACCEPT_COOKIES).click();
        }


    }

    public void clickCategoryByName(String categoryName) {
        super.clickCategoryByName(categoryName, CATEGORIES);
    }

    //    public void getDesktopCategoryByName (String categoryName) {
//
//        List<WebElement> siteCategories = baseFunc.getElements(CATEGORIES);
//
//        for (int i = 0; i < baseFunc.getElements(CATEGORIES).size(); i++) {
//
//            if (siteCategories.get(i).getText().equalsIgnoreCase(categoryName)) {
//
//                siteCategories.get(i).click();
//                break;
//
//            }
//
//        }
//    }



}

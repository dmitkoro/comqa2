package PageObjectTest.pages;

import org.openqa.selenium.By;

public class HomePageMobile extends HomePage{



    private final By CATEGORIES = By.xpath(".//a[@class='link']");
    private final By MENU_BAR = By.xpath(".//a[@class='menu-open']");


    public HomePageMobile(BaseFunc baseFunc) {
        super(baseFunc);
    }

    public void clickCategoryByName(String categoryName) {
        baseFunc.getElement(MENU_BAR).click();
        super.clickCategoryByName(categoryName, CATEGORIES);
    }



    //    public void getMobileCategoryByName (String categoryName) {
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

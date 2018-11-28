package PageObjectTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public WebElement getArticleById (int id, By locator) {
        return baseFunc.getElements(locator).get(id);
    }


    public void clickCategoryByName(String categoryName, By locator) {

        List<WebElement> siteCategories = baseFunc.getElements(locator);

        for (int i = 0; i < baseFunc.getElements(locator).size(); i++) {

            if (siteCategories.get(i).getText().equalsIgnoreCase(categoryName)) {

                siteCategories.get(i).click();
                break;

            }

        }
    }
}

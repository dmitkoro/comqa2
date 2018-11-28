package PageObjectTest.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CategoryMobilePages {

    BaseFunc baseFunc;

    public Integer UNIT_COUNT;

    public CategoryMobilePages (BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        UNIT_COUNT = 3;
    }


    public List<String> mobileArticleNames(By locator) {

        List<WebElement> mobileArticles = baseFunc.getElements(locator);
        List<String> articles = new ArrayList<String>();

        Assertions.assertFalse(mobileArticles.isEmpty(), "Wrong article title");
        for (int i = 0; i < UNIT_COUNT; i++) {
            articles.add(mobileArticles.get(i).getText());
        }

        return articles;
    }

    public List<String> mobileCommentsCount (By locator) {

        List<WebElement> mobileComments = baseFunc.getElements(locator);
        List<String> comments = new ArrayList<String>();

        Assertions.assertFalse(mobileComments.isEmpty(), "Wrong locator for comments");
        for (int i = 0; i < UNIT_COUNT; i++) {
            comments.add(mobileComments.get(i).getText());
        }

        return comments;
    }
}

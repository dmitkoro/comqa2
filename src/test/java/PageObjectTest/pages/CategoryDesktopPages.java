package PageObjectTest.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CategoryDesktopPages {

    BaseFunc baseFunc;


    public Integer UNIT_COUNT;

    public CategoryDesktopPages(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        UNIT_COUNT = 3;
    }


    public List<String> desktopArticleNames(By locator) {

        List<WebElement> desktopArticles = baseFunc.getElements(locator);
        List<String> articles = new ArrayList<String>();

        Assertions.assertFalse(desktopArticles.isEmpty(), "Wrong article title");
        for (int i = 0; i < UNIT_COUNT; i++) {
            articles.add(desktopArticles.get(i).getText());
        }

        return articles;
    }


    //REPLACED with common method "articlesWithComments" in BaseFunc!!!

//    public List<Integer> desktopCommentsCount (By locator) {
//
//        List<WebElement> desktopComments = baseFunc.getElements(locator);
//        List<Integer> commentListInt = new ArrayList<Integer>();
//
//        Assertions.assertFalse(desktopComments.isEmpty(), "Wrong locator for comments");
//        for (int i = 0; i < UNIT_COUNT; i++) {
//           String commentString = (desktopComments.get(i).getText());
//            commentListInt.add(baseFunc.getCommentInt(commentString));
//        }
//
//        return commentListInt;
//    }


}

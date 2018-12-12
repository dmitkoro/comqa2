package PageObjectTest.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CategoryMobilePages {

    BaseFunc baseFunc;

    private final By ARTICLES_FULL_MOBILE = By.xpath(".//div[@class='md-mosaic-title']");
    private final By COMMENTS_MOBILE = By.xpath(".//a[@class='commentCount']");
    private final By ARTICLES_MOBILE = By.xpath(".//a[@class='md-scrollpos']");

    public Integer UNIT_COUNT;

    public CategoryMobilePages(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        UNIT_COUNT = 3;
    }


    public List<String> mobileArticleNames() {

        List<WebElement> mobileArticles = baseFunc.getElements(ARTICLES_MOBILE);
        List<String> articles = new ArrayList<String>();

        Assertions.assertFalse(mobileArticles.isEmpty(), "Wrong article title");
        for (int i = 0; i < UNIT_COUNT; i++) {
            articles.add(mobileArticles.get(i).getText());
        }

        return articles;
    }

    public List<Integer> mobileCommentsCount (){
        List<Integer> mobileCommentsCount = baseFunc.articlesWithComments(ARTICLES_FULL_MOBILE, COMMENTS_MOBILE);
        return mobileCommentsCount;
    }

}

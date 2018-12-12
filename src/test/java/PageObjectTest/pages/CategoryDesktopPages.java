package PageObjectTest.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CategoryDesktopPages {

    BaseFunc baseFunc;

    private final By ARTICLES_DESKTOP = By.xpath(".//a[@class='text-mine-shaft']");
    private final By ARTICLES_FULL_DESKTOP = By.xpath(".//article[contains(@class,'col-')]");
    private final By COMMENTS_DESKTOP = By.xpath(".//a[@class='comment-count text-red-ribbon']");

    public Integer UNIT_COUNT;

    public CategoryDesktopPages(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        UNIT_COUNT = 3;
    }

    public List<String> desktopArticleNames() {

        List<WebElement> desktopArticles = baseFunc.getElements(ARTICLES_DESKTOP);
        List<String> articles = new ArrayList<String>();

        Assertions.assertFalse(desktopArticles.isEmpty(), "Wrong article title");
        for (int i = 0; i < UNIT_COUNT; i++) {
            articles.add(desktopArticles.get(i).getText());
        }

        return articles;
    }

    public List<Integer> desktopCommentsCount() {
        List<Integer> desktopCommentsCount = baseFunc.articlesWithComments(ARTICLES_FULL_DESKTOP, COMMENTS_DESKTOP);
        return desktopCommentsCount;
    }

}

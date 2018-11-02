import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Lesson5HomeWork {

    private WebDriver driver;
    private final By ARTICLE = By.xpath(".//h3[@class = 'top2012-title']");
    private final By ARTICLE_TITLE = By.xpath(".//a[@class = 'top2012-title']");
    private final By COMMENT_COUNT = By.xpath(".//a[@class = 'comment-count']");
    private final By ARTICLE_PAGE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENT_PAGE = By.xpath(".//a[@class = 'comment-main-title-link']");
    private final By REG_COMMENTS = By.xpath(".//a[contains(@class,'comment-thread-switcher-list-a-reg')]/span");
    private final By ANON_COMMENTS = By.xpath(".//a[contains(@class,'comment-thread-switcher-list-a-anon')]/span");
    private final String HOME_PAGE_DESKTOP = "http://rus.delfi.lv";


    @Test
    public void delfiPractice() {

        System.setProperty("webdriver.gecko.driver", "/home/dmitkoro/Documents/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_DESKTOP);
        List<WebElement> articles = driver.findElements(ARTICLE);

        WebElement article = articles.get(1);
        String articleTitle = article.findElement(ARTICLE_TITLE).getText();
        String commentString = article.findElement(COMMENT_COUNT).getText();
        commentString = getSubString(commentString);
        Integer commentCount = Integer.valueOf(commentString);
        article.click();
        String articlePageTitle = driver.findElement(ARTICLE_PAGE).getText();
        Assertions.assertEquals(articleTitle, articlePageTitle, "Articles not equal");
        String articlePageComment = driver.findElement(COMMENT_COUNT).getText();
        if (!isNullOrEmpty(articlePageComment)) {
            articlePageComment = getSubString(articlePageComment);
        }

        Integer articlePageCommentCount = Integer.valueOf(articlePageComment);
        Assertions.assertEquals(commentCount, articlePageCommentCount, "Comments in article page not Equal");
        driver.findElement(COMMENT_COUNT).click();
        String commentPageTitle = driver.findElement(COMMENT_PAGE).getText();
        Assertions.assertTrue(commentPageTitle.contains(articleTitle));
        String regComment = driver.findElement(REG_COMMENTS).getText();
        if (!isNullOrEmpty(regComment)) {
            regComment = getSubString(regComment);
        }

        Integer regCommentCount = Integer.valueOf(regComment);

        String anonComment = driver.findElement(ANON_COMMENTS).getText();
        if (!isNullOrEmpty(anonComment)) {
            anonComment = getSubString(anonComment);
        }

        Integer anonCommentCount = Integer.valueOf(anonComment);
        Integer sum = regCommentCount + anonCommentCount;
        Assertions.assertEquals(commentCount, sum, "Comments not equal");

    }

    public String getSubString(String input) {
        return input.substring(1, input.length() - 1);
    }

    @AfterEach
    private void closeBrowser() {
        driver.close();
    }
}
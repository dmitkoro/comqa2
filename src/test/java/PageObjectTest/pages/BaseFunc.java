package PageObjectTest.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunc {
    WebDriver browser;

    public BaseFunc() {
        System.setProperty("webdriver.gecko.driver", "/home/dmitkoro/Documents/geckodriver");
        browser = new FirefoxDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void goToURL(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        browser.get(url);
    }

    public List<WebElement> getElements(By locator) {
        return browser.findElements(locator);
    }

    public Integer getCommentInt(String comment) {
        if (comment == null) return 0;
        comment = comment.substring(1, comment.length() - 1);
        return Integer.valueOf(comment);
    }

    public WebElement getElement(By locator) {
        Assertions.assertFalse(getElements(locator).isEmpty(), "There is no elements!");
        return browser.findElement(locator);
    }

    public void browserClose() {
        browser.close();
    }

    public List<Integer> articlesWithComments(By articlesFullList, By commentsToFind) {

        List<WebElement> fullArticles = new ArrayList<WebElement>();
        for (int i = 0; i < 3; i++) {

            fullArticles.add(getElements(articlesFullList).get(i));
        }

        List<Integer> commentsInt = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++)

            if (!fullArticles.get(i).findElements(commentsToFind).isEmpty()) {
                commentsInt.add(getCommentInt(fullArticles.get(i).findElement(commentsToFind).getText()));
            } else {
                commentsInt.add(0);
            }

        return commentsInt;
    }
}

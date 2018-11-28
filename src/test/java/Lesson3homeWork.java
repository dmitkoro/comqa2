import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lesson3homeWork {

    private static final Logger LOGGER = LogManager.getLogger(Lesson3homeWork.class);
    private final By ARTICLE_TITLE_DESKTOP = By.xpath(".//a[@class='text-mine-shaft']");
    private final By ARTICLE_TITLE_MOBILE = By.xpath(".//a[@class='md-scrollpos']");
    private final String HOME_PAGE_DESKTOP = "http://rus.delfi.lv";
    private final String HOME_PAGE_MOBILE = "http://m.rus.delfi.lv";
    private int articlesCount = 5;
    private WebDriver driver;

    @Test

    public void delfiTitlesTest() {

        System.setProperty("webdriver.gecko.driver", "/home/dmitkoro/Documents/geckodriver");
        driver = new FirefoxDriver();
        driver.get(HOME_PAGE_DESKTOP);
        LOGGER.info ("Starting browser");
        driver.manage().window().maximize();

        List<WebElement> delfiArticles = driver.findElements((ARTICLE_TITLE_DESKTOP));

        LOGGER.info ("Starting  delfiArticles" +  delfiArticles);

        List<String> newListDelfi = new ArrayList<String>();
        for (int i = 0; i < articlesCount; i++) {

            newListDelfi.add(delfiArticles.get(i).getText());
        }

        driver.get(HOME_PAGE_MOBILE);
        driver.manage().window().maximize();
        List<WebElement> mDelfiArticles = driver.findElements((ARTICLE_TITLE_MOBILE));

        List<String> newListmDelfi = new ArrayList<String>();
        for (int i = 0; i < articlesCount; i++) {
            newListmDelfi.add(mDelfiArticles.get(i).getText());
        }


        assertEquals(newListmDelfi, newListDelfi, "Articles are different ! ");
    }

    @AfterEach
    private void closeBrowser() {
        driver.close();
    }

}

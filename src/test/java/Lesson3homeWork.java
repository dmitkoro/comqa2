import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;


public class Lesson3homeWork {

    private final By ARTICLE_TITLE = By.xpath(".//a[@class='top2012-title']");
    private final By ARTICLE_TITLE2 = By.xpath(".//a[@class='md-scrollpos']");
    private final String HOME_PAGE = "http://delfi.lv";
    private final String HOME_PAGE2 = "http://m.delfi.lv";
    private final int articlesCount = 5;


    @Test

    public void delfiTitlesTest() {

        System.setProperty("webdriver.gecko.driver", "/home/dmitkoro/Documents/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(HOME_PAGE);
        driver.manage().window().maximize();


        List<WebElement> delfiList = driver.findElements((ARTICLE_TITLE));


        List<String> newListDelfi = new ArrayList<String>();
        for (int i = 0; i < articlesCount; i++) {

            newListDelfi.add(delfiList.get(i).getText());


        }


        driver.get(HOME_PAGE2);
        driver.manage().window().maximize();
        List<WebElement> mdelfiList = driver.findElements((ARTICLE_TITLE2));


        List<String> newListmDelfi = new ArrayList<String>();
        for (int i = 0; i < articlesCount; i++) {

            newListmDelfi.add(mdelfiList.get(i).getText());


        }

        System.out.println("newListmDelfi = " + newListmDelfi);

        Assertions.assertEquals(newListmDelfi, newListDelfi, "Articles are different ! ");

        driver.close();

        System.out.println("===============================Articles are match , test SUCCESSFULLY COMPLETED=======================================");

    }


}

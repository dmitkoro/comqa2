import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Lesson3homeWork {

    private final By ARTICLE_TITLE_DESKTOP = By.xpath(".//a[@class='top2012-title']");
    private final By ARTICLE_TITLE_MOBILE = By.xpath(".//a[@class='md-scrollpos']");
    private final String HOME_PAGE_DESKTOP = "http://delfi.lv";
    private final String HOME_PAGE_MOBILE = "http://m.delfi.lv";
    private int articlesCount = 5;


    @Test

    public void delfiTitlesTest() {

        System.setProperty("webdriver.gecko.driver", "/home/dmitkoro/Documents/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(HOME_PAGE_DESKTOP);
        driver.manage().window().maximize();


        List<WebElement> delfiList = driver.findElements((ARTICLE_TITLE_DESKTOP));


        List<String> newListDelfi = new ArrayList<String>();
        for (int i = 0; i < articlesCount; i++) {

            newListDelfi.add(delfiList.get(i).getText());


        }


        driver.get(HOME_PAGE_MOBILE);
        driver.manage().window().maximize();
        List<WebElement> mdelfiList = driver.findElements((ARTICLE_TITLE_MOBILE));


        List<String> newListmDelfi = new ArrayList<String>();
        for (int i = 0; i < articlesCount; i++) {

            newListmDelfi.add(mdelfiList.get(i).getText());


        }

        System.out.println("newListmDelfi = " + newListmDelfi);

        assertEquals(newListmDelfi, newListDelfi, "Articles are different ! ");

        driver.close();

        System.out.println("===============================Articles are match , test SUCCESSFULLY COMPLETED=======================================");

    }


}

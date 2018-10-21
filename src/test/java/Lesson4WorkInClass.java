import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lesson4WorkInClass {

    private final By ARTICLE_TITLE_DESKTOP = By.xpath(".//h3[@class='top2012-title']/a[1]");

    private final String HOME_PAGE_DESKTOP = "http://rus.delfi.lv";

    private int articlesCount = 5;


    @Test

    public void articlesVerifying() {

        System.setProperty("webdriver.gecko.driver", "/home/dmitkoro/Documents/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(HOME_PAGE_DESKTOP);
        driver.manage().window().maximize();


        List<WebElement> delfiList = driver.findElements((ARTICLE_TITLE_DESKTOP));
        List<String> newListDelfi = new ArrayList<String>();
        for (int i = 0; i < articlesCount; i++) {

            newListDelfi.add(delfiList.get(i).getText());


        }

        System.out.println(newListDelfi);

        List<String> customArticles = new ArrayList<String>();

        customArticles.add("Из первых уст: 8 наблюдений о разнице жизни в Риге и Санкт-Петербурге");
        customArticles.add("Троицкий: Латвия и Эстония ошиблись, обращаясь с русскоязычными жителями высокомерно");
        customArticles.add("В Даугавпилсской думе фактически развалилась коалиция; \"Согласие\" возвращает влияние");
        customArticles.add("В Латвии возникла нехватка вакцин для взрослых против дифтерии");
        customArticles.add("Трамп заявил о выходе из договора с Россией о ракетах средней и малой дальности");

        assertEquals(newListDelfi, customArticles, "Articles is not match !!!");


        driver.close();

    }

}








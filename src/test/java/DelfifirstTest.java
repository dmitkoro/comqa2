import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DelfifirstTest {
    private final By ARTICLE_TITLE = By.xpath(".//a[@class='top2012-title']");
    private final String HOME_PAGE = "http://rus.delfi.lv";
    private String articleNameToCheck = "Воскресенье стало самым теплым 14 октября в истории метеонаблюдений";



    /*
     * How to find elements :
     *
     * (//*[@class='.....']
     * ()
     */


    @Test

    public void delfiFirstTitleTest(){

        // Specify article name

        // Create Webdriver
        System.setProperty("webdriver.gecko.driver","/home/dmitkoro/Documents/geckodriver");
        WebDriver driver = new FirefoxDriver();
        // Open browser
        driver.get(HOME_PAGE);
        // Change window size
        driver.manage().window().maximize();
        WebElement article = driver.findElement(ARTICLE_TITLE);
        System.out.println(article);

        Assertions.assertEquals(articleNameToCheck,article.getText(),"This in not true Article! ");

        driver.close();
        // Go to delfi.lv
        // Find Webelement of the first article
        // Check if this is correct article






    }

}

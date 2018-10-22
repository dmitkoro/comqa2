import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lesson4HomeWork {

    private final By ARTICLE_TITLE_DESKTOP = By.xpath(".//h3[@class='top2012-title']/a[1]");
    private final By ARTICLE_TITLE_MOBILE = By.xpath(".//a[@class='md-scrollpos']");
    private final String HOME_PAGE_DESKTOP = "http://automationpractice.com";


    @Test

    public void WomanDresses() {


        System.setProperty("webdriver.gecko.driver", "/home/dmitkoro/Documents/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(HOME_PAGE_DESKTOP);
        driver.manage().window().maximize();

        driver.close();
    }

}


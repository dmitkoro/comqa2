package PageObjectTest;
import PageObjectTest.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.util.List;

public class DelfiDesktopAndMobileTest {

    BaseFunc baseFunc = new BaseFunc();

    private final By ARTICLES_DESKTOP = By.xpath(".//a[@class='text-mine-shaft']");
    private final By ARTICLES_MOBILE = By.xpath(".//a[@class='md-scrollpos']");
    private final By ARTICLES_FULL_DESKTOP = By.xpath(".//article[contains(@class,'col-')]");
    private final By COMMENTS_DESKTOP = By.xpath(".//a[@class='comment-count text-red-ribbon']");
    private final By ARTICLES_FULL_MOBILE = By.xpath(".//div[@class='md-mosaic-title']");
    private final By COMMENTS_MOBILE = By.xpath(".//a[@class='commentCount']");
    private static final Logger LOGGER = LogManager.getLogger(DelfiDesktopAndMobileTest.class);

    private final String HOME_PAGE_DESKTOP = "rus.delfi.lv";
    private final String HOME_PAGE_MOBILE = "m.rus.delfi.lv";
    private final String BUSINESS = "Бизнес";
    private final String REPORTER_DESKTOP = "Репортер";
    private final String REPORTER_MOBILE = "Pепортер";
    private final String SHOWTIME_DESKTOP = "ShowTime";
    private final String SHOWTIME_MOBILE = "Showtime!";

    @Test
    public void commentAndArticlesCheck() {
        baseFunc.goToURL(HOME_PAGE_DESKTOP);

        HomePageDesktop homePageDesktop = new HomePageDesktop(baseFunc);
        homePageDesktop.acceptCookies();
        homePageDesktop.clickCategoryByName(BUSINESS);

        CategoryDesktopPages categoryDesktopPages = new CategoryDesktopPages(baseFunc);
        List<String> desktopBusinessArticles = categoryDesktopPages.desktopArticleNames(ARTICLES_DESKTOP);
        List<Integer> desktopBusinessComments = baseFunc.articlesWithComments(ARTICLES_FULL_DESKTOP, COMMENTS_DESKTOP);
        LOGGER.info("DESKTOP BUSINESS articles" + desktopBusinessArticles);
        LOGGER.info("DESKTOP BUSINESS comments" + desktopBusinessComments);

        homePageDesktop.acceptCookies();
        homePageDesktop.clickCategoryByName(REPORTER_DESKTOP);
        List<String> desktopReporterArticles = categoryDesktopPages.desktopArticleNames(ARTICLES_DESKTOP);
        List<Integer> desktopReporterComments = baseFunc.articlesWithComments(ARTICLES_FULL_DESKTOP, COMMENTS_DESKTOP);
        LOGGER.info("DESKTOP Reporter articles" + desktopReporterArticles);
        LOGGER.info("DESKTOP Reporter comments" + desktopReporterComments);

        homePageDesktop.clickCategoryByName(SHOWTIME_DESKTOP);
        List<String> desktopShowTimeArticles = categoryDesktopPages.desktopArticleNames(ARTICLES_DESKTOP);
        List<Integer> desktopShowTimeComments = baseFunc.articlesWithComments(ARTICLES_FULL_DESKTOP, COMMENTS_DESKTOP);
        LOGGER.info("DESKTOP SHOWTIME articles" + desktopShowTimeArticles);
        LOGGER.info("DESKTOP SHOWTIME comments" + desktopShowTimeComments);

        baseFunc.goToURL(HOME_PAGE_MOBILE);
        HomePageMobile homePageMobile = new HomePageMobile(baseFunc);
        homePageMobile.clickCategoryByName(BUSINESS);

        CategoryMobilePages categoryMobilePages = new CategoryMobilePages(baseFunc);
        List<String> mobileBusinessArticles = categoryMobilePages.mobileArticleNames(ARTICLES_MOBILE);
        List<Integer> mobileBusinessComments = baseFunc.articlesWithComments(ARTICLES_FULL_MOBILE, COMMENTS_MOBILE);
        LOGGER.info("MOBILE BUSINESS articles" + mobileBusinessArticles);
        LOGGER.info("MOBILE BUSINESS comments" + mobileBusinessComments);

        homePageMobile.clickCategoryByName(REPORTER_MOBILE);
        List<String> mobileReporterArticles = categoryMobilePages.mobileArticleNames(ARTICLES_MOBILE);
        List<Integer> mobileReporterComments = baseFunc.articlesWithComments(ARTICLES_FULL_MOBILE, COMMENTS_MOBILE);
        LOGGER.info("MOBILE Reporter articles" + mobileReporterArticles);
        LOGGER.info("MOBILE Reporter comments" + mobileReporterComments);

        homePageMobile.clickCategoryByName(SHOWTIME_MOBILE);
        List<String> mobileShowTimeArticles = categoryMobilePages.mobileArticleNames(ARTICLES_MOBILE);
        List<Integer> mobileShowTimeComments = baseFunc.articlesWithComments(ARTICLES_FULL_MOBILE, COMMENTS_MOBILE);
        LOGGER.info("MOBILE SHOWTIME articles" + mobileShowTimeArticles);
        LOGGER.info("MOBILE SHOWTIME comments" + mobileShowTimeComments);

        Assertions.assertEquals(desktopBusinessArticles, mobileBusinessArticles, "Articles are different");
        Assertions.assertEquals(desktopBusinessComments, mobileBusinessComments, "Comment count is different");

        Assertions.assertEquals(desktopReporterArticles, mobileReporterArticles, "Articles are different");
        Assertions.assertEquals(desktopReporterComments, mobileReporterComments, "Comment count is different");

        Assertions.assertEquals(desktopShowTimeArticles, mobileShowTimeArticles, "Articles are different");
        Assertions.assertEquals(desktopShowTimeComments, mobileShowTimeComments, "Comment count is different");
    }

    @AfterEach
    private void closeBrowser() {
        baseFunc.browserClose();
    }
}
package PageObjectTest;

import PageObjectTest.pages.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.List;


public class DelfiDesktopAndMobileTest {

    BaseFunc baseFunc = new BaseFunc();

    private final By COMMENT_COUNT_BUSINESS_DESKTOP = By.xpath(".//a[@class='comment-count text-red-ribbon']");
    private final By ARTICLES_BUSINESS_DESKTOP = By.xpath(".//a[@class='text-mine-shaft']");
    private final By COMMENT_COUNT_BUSINESS_MOBILE = By.xpath(".//a[@class = 'commentCount']");
    private final By ARTICLES_BUSINESS_MOBILE = By.xpath(".//a[@class='md-scrollpos']");
    private final String HOME_PAGE_DESKTOP = "rus.delfi.lv";
    private final String HOME_PAGE_MOBILE= "m.rus.delfi.lv";
    private final String BUSINESS ="Бизнес";
    private final String REPORTER ="Pепортер";
    private final String Woman ="Woman";


    @Test
    public void commentCheck() {
        baseFunc.goToURL(HOME_PAGE_DESKTOP);

        HomePageDesktop homePageDesktop = new HomePageDesktop(baseFunc);
        homePageDesktop.acceptCookies();
        homePageDesktop.clickCategoryByName(BUSINESS);

        CategoryDesktopPages categoryDesktopPages = new CategoryDesktopPages(baseFunc);
        List<String> desktopBusinessArticles = categoryDesktopPages.desktopArticleNames(ARTICLES_BUSINESS_DESKTOP);
        System.out.println("desktop comments : " + categoryDesktopPages.desktopCommentsCount(COMMENT_COUNT_BUSINESS_DESKTOP));



        baseFunc.goToURL(HOME_PAGE_MOBILE);
        HomePageMobile homePageMobile = new HomePageMobile(baseFunc);
        homePageMobile.clickCategoryByName(BUSINESS);


        CategoryMobilePages categoryMobilePages = new CategoryMobilePages(baseFunc);
        List<String> mobileBusinessArticles = categoryMobilePages.mobileArticleNames(ARTICLES_BUSINESS_MOBILE);
        System.out.println("mobile comments " + categoryMobilePages.mobileCommentsCount(COMMENT_COUNT_BUSINESS_MOBILE));




        Assertions.assertEquals(desktopBusinessArticles,mobileBusinessArticles,"Articles are different");


}
    }
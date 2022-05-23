package site.stellarburgers.nomoreparties;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.BeforeClass;


abstract public class BaseTest {

    public static void setUp(){

//        WebDriverManager.firefoxdriver().setup();
//        Configuration.browser = "firefox";

        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
                        .includeSelenideSteps(true));
    }

    @BeforeClass
    public static void init(){
        setUp();
    }
}
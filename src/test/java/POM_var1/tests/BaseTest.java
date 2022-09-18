package POM_var1.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.BeforeAll;


abstract public class BaseTest {

    public static void setUp(){

        // чтоб запустить в файрфоксе уберите комент со строк ниже


//        WebDriverManager.safaridriver().setup();
//        Configuration.browser = "safari";

//        WebDriverManager.firefoxdriver().setup();
//        Configuration.browser = "firefox";

        Configuration.browserSize = "1920x1080";

        // запускать ли браузер, чтоб что-то бегало на экране?
        // если тру - то не запустит
        Configuration.headless = true;

        // штука для аллюра, показывает все шаги, советую запустить
        // аллюр и поглядеть как там все круто выглядит
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        // не тестил, но вроде при падении в отчете будет скриншот
                        .screenshots(true)
                        .savePageSource(true)
                        .includeSelenideSteps(true));
    }

    @BeforeAll
    public static void init(){
        setUp();
    }
}
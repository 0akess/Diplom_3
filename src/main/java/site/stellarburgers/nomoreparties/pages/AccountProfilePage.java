package site.stellarburgers.nomoreparties.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static site.stellarburgers.nomoreparties.resources.BaseURL.*;

public class AccountProfilePage extends BaseMethodPage<AccountProfilePage> implements Personal {

    @FindBy(how = How.XPATH, using = "//*[text()='Выход']")
    private SelenideElement buttonLogOut;

    @Step("нажатие на кнопку Выйти")
    public AuthorizationPage clickLogOut(){
        buttonLogOut.click();
        return page(AuthorizationPage.class);
    }

    // Вариант проверки по урлу
    @Step("проверка успешного перехода в Личный кабинет")
    public AccountProfilePage checkItIsPersonalAccountPage(){

        for (int i = 0; i < 10; i++){
            Selenide.sleep(100);
            String actualUrl = WebDriverRunner.url();

            if(!actualUrl.equals("")){
                break;
            }
            if(i == 9){
                throw new NullPointerException("Вы не перешли на страницу личного кабинета");
            }
        }
        return this;
    }
}
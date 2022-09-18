package POM_var2.stellarburgersnomoreparties.web_elements.pages;

import POM_var2.stellarburgersnomoreparties.web_elements.BaseMethodPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountProfilePage extends BaseMethodPage<AccountProfilePage> {

    @FindBy(how = How.XPATH, using = "//*[text()='Выход']")
    private SelenideElement buttonLogOut;

    @Step("нажатие на кнопку Выйти")
    public AuthorizationPage clickLogOut(){
        buttonLogOut.click();
        return Selenide.page(AuthorizationPage.class);
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
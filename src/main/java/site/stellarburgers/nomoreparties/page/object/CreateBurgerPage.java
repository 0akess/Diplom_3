package site.stellarburgers.nomoreparties.page.object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateBurgerPage {

    @FindBy(how = How.XPATH, using = "//*[text()='Булки']")
    private SelenideElement buttonBun;

    @FindBy(how = How.XPATH, using = "//*[text()='Соусы']")
    private SelenideElement buttonSauce;

    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private SelenideElement buttonFilling;

    @FindBy(how = How.XPATH, using = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/child::*[text()='Булки']")
    private SelenideElement isSelectButtonBun;

    @FindBy(how = How.XPATH, using = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/child::*[text()='Соусы']")
    private SelenideElement isSelectButtonSauce;

    @FindBy(how = How.XPATH, using = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/child::*[text()='Начинки']")
    private SelenideElement isSelectButtonFilling;


    @Step("переход по ссылке")
    public CreateBurgerPage openPage(String url){
        Selenide.open(url);
        return this;
    }

    @Step("нажатие на кнопку Булки")
    public CreateBurgerPage clickBun(){
        Selenide.sleep(500);
        buttonBun.click();
        return this;
    }

    @Step("нажатие на кнопку Соусы")
    public CreateBurgerPage clickSauce(){
        Selenide.sleep(500);
        buttonSauce.click();
        return this;
    }

    @Step("нажатие на кнопку Начинки")
    public CreateBurgerPage clickFilling(){
        Selenide.sleep(500);
        buttonFilling.click();
        return this;
    }

    @Step("проверка перехода к разделу Булки")
    public CreateBurgerPage isBunSelected(){
        isSelectButtonBun.shouldBe(Condition.visible);
        return this;
    }

    @Step("проверка перехода к разделу Соусы")
    public CreateBurgerPage isSauceSelected(){
        isSelectButtonSauce.shouldBe(Condition.visible);
        return this;
    }

    @Step("проверка перехода к разделу Начинки")
    public CreateBurgerPage isFillingSelected(){
        isSelectButtonFilling.shouldBe(Condition.visible);
        return this;
    }
}

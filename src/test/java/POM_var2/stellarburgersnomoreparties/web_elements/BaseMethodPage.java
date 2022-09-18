package POM_var2.stellarburgersnomoreparties.web_elements;

import POM_var2.stellarburgersnomoreparties.resources.BaseURL;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BaseMethodPage<T> {

    public T open(BaseURL url) {
        Selenide.open(url.getUrl());
        return (T) this;
    }
}

package POM_var1.site.stellarburgersnomoreparties.data.tests;

import org.apache.commons.lang3.RandomStringUtils;

public class GetUserData {

    public String getNameUser(){
        return RandomStringUtils.randomAlphabetic(10);
    }

    public String getPasswordUser(Integer sizePassword){
        return RandomStringUtils.randomAlphabetic(sizePassword);
    }

    public String getEmailUser(){
        return RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    }
}
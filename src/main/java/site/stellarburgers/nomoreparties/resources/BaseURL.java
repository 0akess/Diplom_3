package site.stellarburgers.nomoreparties.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BaseURL {
    MAIN_URL ("https://stellarburgers.nomoreparties.site/"),
    ORDER_FEED_URL ("https://stellarburgers.nomoreparties.site/feed"),
    ACCOUNT_PROFILE_URL ("https://stellarburgers.nomoreparties.site/account/profile"),
    ACCOUNT_ORDER_HISTORY_URL ("https://stellarburgers.nomoreparties.site/account/order-history"),
    LOGIN_URL ("https://stellarburgers.nomoreparties.site/login"),
    REGISTRATION_URl ("https://stellarburgers.nomoreparties.site/register"),
    FORGOT_PASSWORD_URL ("https://stellarburgers.nomoreparties.site/forgot-password");

    private String url;
}
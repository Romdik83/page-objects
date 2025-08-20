package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginFiled = $("[data-test-id=login] input");
    private final SelenideElement passwordFiled = $("[data-test-id=password] input");
    private final SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(String login, String password) {
        loginFiled.setValue(login);
        passwordFiled.setValue(password);
        loginButton.click();
        return new VerificationPage();
    }
}

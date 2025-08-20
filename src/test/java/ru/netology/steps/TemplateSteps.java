package ru.netology.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.bg.И;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

public class TemplateSteps {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private VerificationPage verificationPage;

    @И("открыта страница с формой авторизации {}")
    public void openAuthPage(String url) {
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @И("пользователь пытается авторизоваться с именем {string} и паролем {string}")
    public void loginWithNameAndPassword(String login, String password) {
        verificationPage = loginPage.validLogin(login, password);
    }

    @И("пользователь вводит проверочный код 'из смс' {int}")
    public void setValidCode(int verificationCode) {
        dashboardPage = verificationPage.validVerify(String.valueOf(verificationCode));
    }

    @И("происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'")
    public void verifyDashboardPage() {
        dashboardPage.verifyIsDashboardPage();
    }

    @И("появляется ошибка о неверном коде проверки")
    public void verifyCodeIsInvalid() {
        verificationPage.verifyCodeIsInvalid();
    }


}

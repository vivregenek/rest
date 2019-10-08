package ui.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPopUpPage {
    public SelenideElement loginTitle() {
        return $("#Login");
    }

    public SelenideElement userNameField() {
        return $(By.id("username-modal"));
    }

    public SelenideElement userPasswordField() {
        return $(By.id("password-modal"));
    }

    public SelenideElement loginButton() {
        return $(".modal-body button");
    }

    public SelenideElement errorMessage() {
        return $("#login-message > div");
    }
}

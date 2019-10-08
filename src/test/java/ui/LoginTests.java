package ui;

import com.codeborne.selenide.Condition;
import core.ui.BaseUiTestClass;
import core.ui.PropertyReader;
import org.junit.jupiter.api.Test;
import ui.pageObjects.HomePage;
import ui.pageObjects.LoginPopUpPage;

public class LoginTests extends BaseUiTestClass {
    private HomePage homePage = new HomePage();
    private LoginPopUpPage loginPopUpPage = new LoginPopUpPage();

    @Test
    void loginWithExistingUser() {
        open(PropertyReader.getGlobalProperty("host"));
        homePage.loginButton().click();
        loginPopUpPage.loginTitle().shouldHave(Condition.text("Customer login"));
        loginPopUpPage.userNameField().val(PropertyReader.getGlobalProperty("portal_user_name"));
        loginPopUpPage.userPasswordField().val(PropertyReader.getGlobalProperty("portal_user_password"));
        loginPopUpPage.loginButton().click();
        homePage.logoutButton().shouldBe(Condition.text("Logout"));
    }

    @Test
    void loginWithIncorrectPassword() {
        open(PropertyReader.getGlobalProperty("host"));
        homePage.loginButton().click();
        loginPopUpPage.loginTitle().shouldHave(Condition.text("Customer login"));
        loginPopUpPage.userNameField().val(PropertyReader.getGlobalProperty("portal_user_name"));
        loginPopUpPage.userPasswordField().val("IncorrectPortalUserPassword");
        loginPopUpPage.loginButton().click();
        loginPopUpPage.errorMessage().shouldBe(Condition.text("Invalid login credentials."));
    }
}

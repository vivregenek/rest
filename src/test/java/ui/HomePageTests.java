package ui;

import com.codeborne.selenide.Condition;
import core.annotation.smoke;
import core.ui.BaseUiTestClass;
import core.ui.PropertyReader;
import org.junit.jupiter.api.Test;
import ui.pageObjects.HomePage;

public class HomePageTests extends BaseUiTestClass {
    private HomePage homePage = new HomePage();

    @smoke
    @Test
    void portalHomePageTabsCheck() {
        open(PropertyReader.getGlobalProperty("host"));
        homePage.homeTab().shouldHave(Condition.text("Home"));
        homePage.catalogueTab().shouldHave(Condition.text("Catalogue"));
    }

    @smoke
    @Test
    void portalHomePageButtonsCheck() {
        open(PropertyReader.getGlobalProperty("host"));
        homePage.basketButton().shouldHave(Condition.text("0 items in cart"));
        homePage.loginButton().shouldHave(Condition.text("Login"));
        homePage.registerButton().shouldHave(Condition.text("Register"));
    }
}

package ui.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public SelenideElement homeTab() {
        return $("#tabIndex > a");
    }

    public SelenideElement catalogueTab() {
        return $("#tabCatalogue > a");
    }

    public SelenideElement basketButton() {
        return $("a > #numItemsInCart");
    }

    public SelenideElement loginButton() {
        return $("#login > a");
    }

    public SelenideElement registerButton() {
        return $("#register > a");
    }

    public SelenideElement logoutButton() {
        return $("#logout a");
    }
}

package ui;

import com.codeborne.selenide.Condition;
import core.ui.BaseUiTestClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginTests extends BaseUiTestClass {
    @Test
    void loginWithExistingUser() {
        open("http://ec2-54-91-163-195.compute-1.amazonaws.com/index.html");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        $(By.id("login")).click();
        $(By.id("Login")).shouldHave(Condition.text("Customer login"));
        $(By.id("username-modal")).val("user");
        $(By.id("password-modal")).val("password");
        $(".modal-body button").click();
        System.out.println("The test is almost finished");
        $("#logout a").shouldBe(Condition.text("Logout"));
    }
}

package core;

import io.qameta.allure.Allure;

public class AllureAttachmentHelper {
    public static void logRestCall(String url, String method, String body, String response){
        Allure.addAttachment("url", url);
        Allure.addAttachment("method", method);
        Allure.addAttachment("request body", body);
        Allure.addAttachment("response body", response);
    }

    public static void logRestCall(String url, String method, String response){
        Allure.addAttachment("url", url);
        Allure.addAttachment("method", method);
        Allure.addAttachment("response body", response);
    }
}

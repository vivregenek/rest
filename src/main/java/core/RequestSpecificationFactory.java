package core;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationFactory {

    public static RequestSpecification getJsonRequestSpecification(String basePath) {
        return new RequestSpecBuilder()
                .setBaseUri(System.getProperty("host"))
                .setBasePath(basePath)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification getXmlRequestSpecification(String basePath) {
        return new RequestSpecBuilder()
                .setBaseUri(System.getProperty("hostUrl"))
                .setBasePath(basePath)
                .setAccept(ContentType.XML)
                .setContentType(ContentType.XML)
                .build();
    }
}

package core.rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationFactory {

    public static RequestSpecification getJsonRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(System.getProperty("host"))
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification getXmlRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(System.getProperty("hostUrl"))
                .setAccept(ContentType.XML)
                .setContentType(ContentType.XML)
                .build();
    }
}

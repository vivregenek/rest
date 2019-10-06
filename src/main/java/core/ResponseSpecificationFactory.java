package core;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationFactory {

    public static ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
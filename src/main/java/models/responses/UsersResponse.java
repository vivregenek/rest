package models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class UsersResponse {
    @JsonProperty()
    int id;
    @JsonProperty()
    String name;
    @JsonProperty()
    String userName;
    @JsonProperty()
    String email;
    @JsonProperty()
    Address address;
    @JsonProperty()
    String phone;
    @JsonProperty()
    String website;
    @JsonProperty()
    Company company;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Address {
        @JsonProperty()
        String street;
        @JsonProperty()
        String suite;
        @JsonProperty()
        String city;
        @JsonProperty()
        String zipcode;
        @JsonProperty()
        String geo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Company {
        @JsonProperty()
        String name;
        @JsonProperty()
        String catchPhrase;
        @JsonProperty()
        String bs;
    }
}



package api.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class GetCustomerResponse {
    @JsonProperty()
    int firstName;
    @JsonProperty()
    String username;
    @JsonProperty()
    Self self;
    @JsonProperty()
    Links _links;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Links {
        Self self;
        Customer customer;
        Addresses addresses;
        Cards cards;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Self {
        @JsonProperty()
        String href;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Customer {
        @JsonProperty()
        String href;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Addresses {
        @JsonProperty()
        String href;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Cards {
        @JsonProperty()
        String href;
    }


}



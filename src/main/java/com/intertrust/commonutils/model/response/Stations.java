package com.intertrust.commonutils.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Stations{
    @JsonProperty("AV350")
    public AV350 aV350;
    @JsonProperty("VIDP")
    public VIDP vIDP;
    @JsonProperty("AV559")
    public AV559 aV559;
}

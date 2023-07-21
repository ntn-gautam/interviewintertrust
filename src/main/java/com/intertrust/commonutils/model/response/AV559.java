package com.intertrust.commonutils.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AV559{
    public double distance;
    public double latitude;
    public double longitude;
    public int useCount;
    public String id;
    public String name;
    public int quality;
    public double contribution;
}

package com.intertrust.commonutils.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisualCrossingWebServices {
    public int queryCost;
    public double latitude;
    public double longitude;
    public String resolvedAddress;
    public String address;
    public String timezone;
    public double tzoffset;
    public String description;
    public ArrayList<Day> days;
    public ArrayList<Object> alerts;
    public Stations stations;
    public CurrentConditions currentConditions;
}

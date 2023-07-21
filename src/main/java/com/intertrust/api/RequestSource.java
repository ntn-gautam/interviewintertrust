package com.intertrust.api;

import com.intertrust.commonutils.applicationutils.constants.URIConstants;
import com.intertrust.commonutils.model.response.VisualCrossingWebServices;
import com.intertrust.commonutils.restutils.RestCommonUtils;

import java.util.HashMap;
import java.util.Map;

public class RequestSource extends RestCommonUtils {

    protected static final Map<String, Object> queryParam = new HashMap<>();

    public VisualCrossingWebServices getCrossingWebServices(String cityName, int statusCode) {
        queryParam.put("unitGroup", "metric");
        queryParam.put("key", "DYYLFRCKBURL4XUHJEYS544CJ");
        queryParam.put("contentType", "json");
        commonGetMethodWithQueryParam(URIConstants.VISUAL_CROSSING_TIMELINE + cityName, queryParam, baseAPIUrl, statusCode);
        return response.as(VisualCrossingWebServices.class);
    }
}

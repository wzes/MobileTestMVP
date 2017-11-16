package com.wzes.vmovie.bean;

import java.util.HashMap;

/**
 * Created by xuantang on 11/16/17.
 */

public class SearchResults {

    public HashMap<String, String> relevantHeaders;
    public String jsonResponse;
    public SearchResults(HashMap<String, String> headers, String json) {
        relevantHeaders = headers;
        jsonResponse = json;
    }
}

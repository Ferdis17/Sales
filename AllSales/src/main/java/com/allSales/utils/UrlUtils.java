package com.allSales.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Bi on 11/20/17.
 */
public class UrlUtils {
    public static String getFullURL(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append('?').append(queryString).toString();
        }
    }
}

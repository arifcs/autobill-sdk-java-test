package com.autobill.sdk.test

import com.autobill.connect.APIConfig
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.Unirest

class ApiCaller {
    public static String getAccessToken(APIConfig apiConfig, String code){
        try {
            HttpResponse<String> response = Unirest.post("${apiConfig.getAppUrl()}/api/v1/oauth2/token")
                    .header("content-type", "application/json")
                    .header("cache-control", "no-cache")
                    .body("{  \"grant_type\": \"authorization_code\", " +
                            " \"code\": \"${code}\", " +
                            " \"client_id\": \"${apiConfig.getClientId()}\", " +
                            " \"client_secret\": \"${apiConfig.getClientSecret()}\", " +
                            " \"redirect_uri\": \"${apiConfig.getRedirectUrl()}\"}")
                    .asString();
            return response.body
        } catch (Exception e) {
            e.printStackTrace()
        }
        return null
    }
}

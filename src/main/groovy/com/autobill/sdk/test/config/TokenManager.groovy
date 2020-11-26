package com.autobill.sdk.test.config

import com.autobill.connect.APICaller
import com.autobill.connect.APIConfig
import groovy.json.JsonSlurper

class TokenManager {
    public static boolean renewToken(){
        try {
            APIConfig apiConfig = ConfigManager.getConfig()
            String response = APICaller.renewToken(apiConfig)
            if(response == null){
                return false
            }
            def json = new JsonSlurper().parseText(response)
            apiConfig.setAccessToken(json.access_token)
            apiConfig.setRefreshToken(json.refresh_token)
            ConfigManager.saveConfig(apiConfig)
        } catch (Exception e) {
            return false
        }
        return true
    }
}

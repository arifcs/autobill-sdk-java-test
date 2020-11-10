package com.autobill.sdk.test.config

import com.autobill.connect.APIConfig
import grails.converters.JSON
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class ConfigManager {
    private final static String fileName  = "apiConfig.json"
    private final static Map initialConfig = [
        "apiUrl" : "https://dev-api.autobill.com",
        "appUrl" : "https://dev-app.autobill.com",
        "clientId" : "",
        "clientSecret" : "",
        "accessToken" : "",
        "refreshToken" : "",
        "redirectUrl" : ""
    ]

    public static File getFile(){
        File file = new File(new File(System.getProperty("user.dir")), fileName)
        if(!file.exists()){
            file.createNewFile()
            file.write( JsonOutput.toJson(initialConfig))
        }
        return file
    }

    public static APIConfig getConfig(){
        def jsonObject = new JsonSlurper().parseText(getFile().text)
        APIConfig apiConfig = new APIConfig()
        ["apiUrl","appUrl","clientId","clientSecret","accessToken","refreshToken","redirectUrl"].each{
            apiConfig[it] = jsonObject[it]
        }
        return apiConfig
    }

    public static void saveConfig(APIConfig config){
        def map = [:]
        ["apiUrl","appUrl","clientId","clientSecret","accessToken","refreshToken","redirectUrl"].each{
            map[it] = config[it]
        }
        getFile().write( JsonOutput.toJson(map))
    }
}

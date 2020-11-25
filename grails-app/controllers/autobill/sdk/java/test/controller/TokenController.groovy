package autobill.sdk.java.test.controller

import com.autobill.connect.APIConfig
import com.autobill.connect.ApiCaller
import com.autobill.sdk.test.config.ConfigManager
import groovy.json.JsonSlurper

class TokenController {

    def index() { }

    def invalidate(){
        APIConfig apiConfig = ConfigManager.getConfig()
        apiConfig.setAccessToken("")
        ConfigManager.saveConfig(apiConfig)
        flash.message = "Token invalidated"
        redirect(controller:"home", action:"index")
    }

    def renew(){
        APIConfig apiConfig = ConfigManager.getConfig()
        String response = ApiCaller.renewToken(apiConfig)

        if(response == null){
            flash.message = "Could not connect"
            redirect(action: "index", controller :"home")
            return
        }

        def json = new JsonSlurper().parseText(response)
        apiConfig.setAccessToken(json.access_token)
        apiConfig.setRefreshToken(json.refresh_token)
        ConfigManager.saveConfig(apiConfig)
        flash.message = "Token renewed"
        redirect(controller:"home", action:"index")
    }
}

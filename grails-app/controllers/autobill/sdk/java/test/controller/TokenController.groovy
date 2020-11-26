package autobill.sdk.java.test.controller

import com.autobill.connect.APICaller
import com.autobill.connect.APIConfig
import com.autobill.sdk.test.config.ConfigManager
import com.autobill.sdk.test.config.TokenManager
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
        boolean result = TokenManager.renewToken()
        if(!result){
            flash.message = "Could not connect"
            redirect(action: "index", controller :"home")
            return
        }
        flash.message = "Token renewed"
        redirect(controller:"home", action:"index")
    }
}

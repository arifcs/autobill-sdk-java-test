package autobill.sdk.java.test.controller

import com.autobill.connect.APICaller
import com.autobill.connect.APIConfig
import com.autobill.sdk.test.config.ConfigManager

import groovy.json.JsonSlurper

class CallBackController {

    def index() {
        String code = params.code
        if(params.code == null){
            flash.message = "Invalid parameter"
            redirect(action: "index", controller :"home")
            return
        }
        String response = APICaller.getAccessToken(ConfigManager.getConfig(), code)
        if(response == null){
            flash.message = "Could not connect"
            redirect(action: "index", controller :"home")
            return
        }

        def json = new JsonSlurper().parseText(response)

        APIConfig apiConfig = ConfigManager.getConfig()
        apiConfig.setAccessToken(json.access_token)
        apiConfig.setRefreshToken(json.refresh_token)
        ConfigManager.saveConfig(apiConfig)
        flash.message = "Connected successfully"
        redirect(action: "index", controller :"home")
    }
}

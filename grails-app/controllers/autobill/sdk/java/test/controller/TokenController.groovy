package autobill.sdk.java.test.controller

import com.autobill.connect.APIConfig
import com.autobill.sdk.test.config.ConfigManager

class TokenController {

    def index() { }

    def invalidate(){
        APIConfig apiConfig = ConfigManager.getConfig()
        apiConfig.setAccessToken("")
        ConfigManager.saveConfig(apiConfig)
        flash.message = "Token invalidated"
        redirect(controller:"home", action:"index")
    }
}

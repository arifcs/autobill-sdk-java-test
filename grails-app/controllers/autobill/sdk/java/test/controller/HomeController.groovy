package autobill.sdk.java.test.controller

import com.autobill.connect.APIConfig
import com.autobill.sdk.test.config.ConfigManager

class HomeController {

    def index() {
        APIConfig apiConfig = ConfigManager.getConfig()
        if(apiConfig.getRedirectUrl().trim().length() == 0){
            apiConfig.redirectUrl = createLink([controller: "callBack", action: "index", absolute: true])
        }
        [apiConfig : apiConfig]
    }

    def save(){
        APIConfig apiConfig = ConfigManager.getConfig()
        ["apiUrl","appUrl","clientId","clientSecret","accessToken","refreshToken","redirectUrl"].each{
            apiConfig[it] = params[it]
        }
        ConfigManager.saveConfig(apiConfig)
        redirect(action: "index")
    }

}

package autobill.sdk.java.test.controller

import com.autobill.api.client.connect.APIConfig
import com.autobill.api.client.connect.ApiConnectorProvider

class HomeController {

    def index() {
        APIConfig apiConfig = ApiConnectorProvider.getApiConnector().getAPIConfig()
        if(apiConfig.getRedirectUrl().trim().length() == 0){
            apiConfig.redirectUrl = createLink([controller: "callBack", action: "index", absolute: true])
        }
        [apiConfig : apiConfig]
    }

    def save(){
        APIConfig apiConfig = ApiConnectorProvider.getApiConnector().getAPIConfig()
        ["apiUrl","appUrl","clientId","clientSecret","accessToken","refreshToken","redirectUrl"].each{
            apiConfig[it] = params[it]
        }
        ApiConnectorProvider.getApiConnector().saveAPIConfig(apiConfig)
        flash.message = "Saved"
        redirect(action: "index")
    }

}

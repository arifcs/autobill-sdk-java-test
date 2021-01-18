package autobill.sdk.java.test.controller

import com.autobill.api.client.connect.APICaller
import com.autobill.api.client.connect.APIConfig
import com.autobill.api.client.connect.ApiConnectorProvider
import groovy.json.JsonSlurper

class CallBackController {

    def index() {
        String code = params.code
        if(params.code == null){
            flash.message = "Invalid parameter"
            redirect(action: "index", controller :"home")
            return
        }
        String response = APICaller.getAccessToken(ApiConnectorProvider.getApiConnector(), code)
        if(response == null){
            flash.message = "Could not connect"
            redirect(action: "index", controller :"home")
            return
        }

        def json = new JsonSlurper().parseText(response)

        APIConfig apiConfig = ApiConnectorProvider.getApiConnector().getAPIConfig()
        apiConfig.setAccessToken(json.access_token)
        apiConfig.setRefreshToken(json.refresh_token)
        ApiConnectorProvider.getApiConnector().saveAPIConfig(apiConfig)
        flash.message = "Connected successfully"
        redirect(action: "index", controller :"home")
    }
}

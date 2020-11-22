package autobill.sdk.java.test.controller

import com.autobill.connect.APIConfig
import com.autobill.sdk.test.config.ConfigManager
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.Unirest

class TestApiController {

    def index() { }

    def getAccount(){
        String responseString = ""
        try {
            APIConfig apiConfig = ConfigManager.getConfig()
            HttpResponse<String> response = Unirest.get("${apiConfig.getApiUrl()}/api/v1/accounts")
                    .header("authorization", "Bearer ${apiConfig.getAccessToken()}")
                    .header("cache-control", "no-cache")
                    .asString();
            responseString = response.body
        } catch (Exception e) {
            e.printStackTrace()
            responseString = e.getMessage()
        }
        [responseString: responseString]
    }
}

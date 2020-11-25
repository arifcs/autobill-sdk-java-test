package autobill.sdk.java.test.controller

import com.autobill.connect.APIConfig
import com.autobill.dao.AccountDao
import com.autobill.model.AccountList
import com.autobill.sdk.test.config.ConfigManager
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.Unirest

class AccountController {

    def index() { }

    def list(){
        AccountList accountList = null
        try {
            APIConfig apiConfig = ConfigManager.getConfig()
            accountList = AccountDao.readAll(apiConfig)
        } catch (Exception e) {
            e.printStackTrace()
        }
        [accountList : accountList]
    }
}

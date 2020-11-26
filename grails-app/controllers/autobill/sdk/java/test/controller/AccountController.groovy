package autobill.sdk.java.test.controller

import com.autobill.connect.APIConfig
import com.autobill.dao.AccountDao
import com.autobill.model.Account
import com.autobill.sdk.test.config.ConfigManager

class AccountController {

    def index() { }

    def list(){
        List<Account> accountList = null
        try {
            APIConfig apiConfig = ConfigManager.getConfig()
            accountList = AccountDao.readAll(apiConfig)
        } catch (Exception e) {
            e.printStackTrace()
        }
        [accountList : accountList]
    }

    def create(){
        String unique = new Date().getTime()+""
        String name = "Name-"+unique
        String email = "email"+unique+"@gmail.com"
        Account account = new Account()
        account.name = name
        account.email_address = email
        try {
            APIConfig apiConfig = ConfigManager.getConfig()
            AccountDao.create(apiConfig, account)
        } catch (Exception e) {
            e.printStackTrace()
        }
        flash.message = "Account created"
        redirect(action:"list")
    }

    def view(){
        Account account = null
        try {
            APIConfig apiConfig = ConfigManager.getConfig()
            account = AccountDao.read(apiConfig, params.id)
        } catch (Exception e) {
            e.printStackTrace()
        }
        [account : account]
    }
}

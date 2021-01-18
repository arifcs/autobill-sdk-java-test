package autobill.sdk.java.test.controller

import com.autobill.api.client.connect.ApiConnectorProvider
import com.autobill.api.client.dao.AccountDao
import com.autobill.api.client.model.Account

class AccountController {

    def index() { }

    def list(){
        try {
            List<Account> accountList = new AccountDao(ApiConnectorProvider.getApiConnector()).readAll()
            if(accountList == null){
                return null;
            }
            return accountList.accounts
        }catch (Exception e) {
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
            new AccountDao(ApiConnectorProvider.getApiConnector()).create(account)
        }catch (Exception e) {
            e.printStackTrace()
        }
        flash.message = "Account created"
        redirect(action:"list")
    }

    def view(){
        Account account = null
        try {
            account = new AccountDao(ApiConnectorProvider.getApiConnector()).read(params.id)
        } catch (Exception e) {
            e.printStackTrace()
        }
        [account : account]
    }

    def edit(){
        String newName = "UpdatedName-"+new Date().getTime()
        Account account = null
        try {
            Map<String, String> map = new HashMap<String, String>()
            map.put("name",newName)
            map.put("description","Updated with API at "+new Date().toString())
            account = new AccountDao(ApiConnectorProvider.getApiConnector()).update(params.id, map)
        } catch (Exception e) {
            e.printStackTrace()
        }
        flash.message = "Name updated to "+ account.name
        redirect(action:"list")
    }

    def delete(){
        try {
            new AccountDao(ApiConnectorProvider.getApiConnector()).delete(params.id)
        } catch (Exception e) {
            e.printStackTrace()
        }
        flash.message = "Deleted "+params.id
        redirect(action:"list")
    }
}

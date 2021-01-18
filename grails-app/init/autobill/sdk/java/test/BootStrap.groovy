package autobill.sdk.java.test

import com.autobill.api.client.connect.ApiConnector
import com.autobill.api.client.connect.ApiConnectorProvider
import com.autobill.api.client.connect.handler.InMemoryConfigHandler

class BootStrap {

    def init = { servletContext ->
        ApiConnectorProvider.setApiConnector(new ApiConnector(new InMemoryConfigHandler()))
    }
    def destroy = {
    }
}

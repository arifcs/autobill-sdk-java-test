package com.autobill.sdk.test.config

import com.autobill.connect.APIConfig

class ConfigManagerTest extends GroovyTestCase {
    void testGetConfig() {
        APIConfig apiConfig = ConfigManager.getConfig()
        println apiConfig
        apiConfig.redirectUrl = "http://yahoo.com"
        ConfigManager.saveConfig(apiConfig)
        assert ConfigManager.getConfig().getRedirectUrl().equals("http://yahoo.com")
        println apiConfig
    }
}

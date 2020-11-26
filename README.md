# AutoBill JAVA SDK Tester

**Project Setup**
1. Clone the project https://github.com/arifcs/autobill-sdk-java-test.git
2. Under autobill-sdk-java-test directory, clone https://github.com/arifcs/autobill-sdk-java.git
3. Build and run the project autobill-sdk-java-test.git in IDE 

**Assumption**
This project is running at http://localhost:8080

TODO absdk clone

**Please notice**
1. apiConfig.json is writable
2. For internal development, in the instruction below, use https://dev-app.autobill.com in place of https://app.autobill.com, and https://dev-api.autobill.com in place of https://api.autobill.com. 

## Step-1: Create Application

1. Login https://app.autobill.com
2. Create an application
3. Enter http://localhost:8080/callBack/index as callback url
4. View the Application and note __Client ID__ and __Client Secret__
5. Assign it all permissions to Account by going to Scope option in the application

## Step-2: Edit API Configuration in the client

Update the following values by editing apiConfig.json or submitting the form in http://localhost:8080
1. apiUrl: https://api.autobill.com
2. appUrl: https://app.autobill.com
3. clientId: Get from Step-1 
4. clientSecret: Get from Step-1
5. redirectUrl: Same as you entered in Step-1

## Step-3: Connect

1. Go to http://localhost:8080
2. Click __Connect AutoBill__
3. Click Allow

## Step-4: Test Simple Endpoint - List Account

1. Click __Account__ in the top menu. If you can see account list without any error, connection is successful.

## Step-5: Test Renewing Access Token

1. Go to http://localhost:8080
2. Click __Invalidate token__
3. Click __Account__ in the top menu and confirm it is __not__ fetching account list
4. Go back to home page, and click __Renew token__
5. Click __Account__ in the top menu and confirm it is fetching account list



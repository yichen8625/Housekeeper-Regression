import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.testobject.UrlEncodedBodyParameter
import com.kms.katalon.core.testobject.FormDataBodyParameter
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import java.util.Random
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonOutput

'導航至管理版首頁'
WebUI.navigateToUrl('https://test.kingnetsmart.com.tw/community/main.aspx')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

'郵務管理-領取'
WebUI.click(findTestObject('Object Repository/register the package/btn_management'))

WebUI.click(findTestObject('Object Repository/receive the package/btn_receive'))


'領取方式-手機條碼'

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('receive the package/btn_camera_confirm'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/receive the package/type_barcode'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/receive the package/input_token'), code)

WebUI.sendKeys(findTestObject('Object Repository/receive the package/input_token'), Keys.chord(Keys.ENTER))


'信件包裹領取'
WebUI.scrollToElement(findTestObject('Object Repository/receive the package/title_list'), 3)

WebUI.click(findTestObject('Object Repository/receive the package/checkbox_all'))

WebUI.click(findTestObject('Object Repository/receive the package/checkbox_first'))

WebUI.scrollToElement(findTestObject('Object Repository/receive the package/btn_end'), 3)

WebUI.click(findTestObject('Object Repository/receive the package/btn_end'))

WebUI.delay(3)
//截圖路徑
WebUI.takeFullPageScreenshot('C:\\Users\\noahc\\Katalon Studio\\Sprint3-housekeeper (Noah) 2.0\\ScreenShoot\\手機條碼領取包裹.png')

WebUI.closeBrowser()

/* 
'取得管理版 user token'
def response = WS.sendRequest(findTestObject('Object Repository/receive the package/Postman/1. Get Token'));
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent());


'管理版 user token 存入全域變數'
U_Token = jsonResponse.Data.Token
GlobalVariable.G_H_TOKEN = U_Token
println("G_H_TOKEN: " + GlobalVariable.G_H_TOKEN)


'取得 CommunityLogin token'
def CommunityLogin = new RestRequestObjectBuilder()
def requestObject_c_login = CommunityLogin
    .withRestRequestMethod("POST")
    .withRestUrl("https://test.kingnetsmart.com.tw/mvc/api/Login/CommunityLogin")
    .withHttpHeaders([
        new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")
    ])
    .withTextBodyContent('{"Token":"'+GlobalVariable.G_H_TOKEN+'","ComId":"'+17041002+'"}')
    .build()
	
// request to /api/Login/CommunityLogin
def c_response = WS.sendRequest(requestObject_c_login)
println(c_response.statusCode);
println(c_response.responseBodyContent);
assert c_response.getStatusCode() == 200

def cookies = c_response.getHeaderFields().get('Set-Cookie')
if (cookies != null && cookies.size() > 0) {
    // 取第一段 cookie
    def cookie = cookies[0].split(';')[0] // 只取cookie名&值
    GlobalVariable.G_C_COOKIE = cookie
    KeywordUtil.logInfo("G_C_COOKIE: " + GlobalVariable.G_C_COOKIE)
} else {
    KeywordUtil.logInfo("No cookies found in the response.")
};


'checkUserCode'
def checkUserCode = new RestRequestObjectBuilder()
def requestObject_cc = checkUserCode
	.withRestRequestMethod("POST")
	.withRestUrl("https://test.kingnetsmart.com.tw/ajax/ajax.asmx/checkUserCode")
	.withHttpHeaders([
		new TestObjectProperty("Cookie", ConditionType.EQUALS,"${GlobalVariable.G_C_COOKIE}"),
		new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/x-www-form-urlencoded")
])
	.withTextBodyContent('code=583RHBP23D145014')
		.build()

def UserCode = WS.sendRequest(requestObject_cc)
println(UserCode.statusCode);
println(UserCode.responseBodyContent);
assert UserCode.getStatusCode() == 200;


'getPostalList'
def getPostalList = new RestRequestObjectBuilder()
def PostalList = getPostalList
	.withRestRequestMethod("POST")
	.withRestUrl("https://test.kingnetsmart.com.tw/ajax/ajax.asmx/getPostalList")
	.withHttpHeaders([
		new TestObjectProperty("Cookie", ConditionType.EQUALS,"${GlobalVariable.G_C_COOKIE}"),
		new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/x-www-form-urlencoded")
])
	.withTextBodyContent("jsonStr=[{\"condition\":\"[{\\\"name\\\":\\\"a\\\",\\\"val\\\":\\\"2\\\"},{\\\"name\\\":\\\"b\\\",\\\"val\\\":\\\"1704100010\\\"}]\"}]")

	//.withTextBodyContent('{"Token":"'+GlobalVariable.G_H_TOKEN+'","ComId":"'+17041002+'"}')	
	.build()

def List = WS.sendRequest(PostalList)
println(List.statusCode);
println(List.responseBodyContent);
assert List.getStatusCode() == 200;

def tt = JsonOutput.toJson(List)
return tt

WebUI.delay(10)
*/



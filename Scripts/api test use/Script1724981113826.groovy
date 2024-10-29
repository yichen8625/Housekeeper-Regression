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
import internal.GlobalVariable as GlobalVariable
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

WebUI.openBrowser('')

WebUI.deleteAllCookies()

WebUI.navigateToUrl(GlobalVariable.G_URL)

'取得管理版 user token'
def response = WS.sendRequest(findTestObject('Object Repository/table/package/receive packages/Postman/1. Get Token'));
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
    GlobalVariable.G_community = cookie
    KeywordUtil.logInfo("G_C_COOKIE: " + GlobalVariable.G_community)
} else {
    KeywordUtil.logInfo("No cookies found in the response.")
};


'checkUserCode'
def checkUserCode = new RestRequestObjectBuilder()
def requestObject_cc = checkUserCode
	.withRestRequestMethod("POST")
	.withRestUrl("https://test.kingnetsmart.com.tw/ajax/ajax.asmx/checkUserCode")
	.withHttpHeaders([
		new TestObjectProperty("Cookie", ConditionType.EQUALS,"${GlobalVariable.G_community}"),
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
		new TestObjectProperty("Cookie", ConditionType.EQUALS,"${GlobalVariable.G_community}"),
		new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/x-www-form-urlencoded")
])
	.withTextBodyContent("jsonStr=[{\"condition\":\"[{\\\"name\\\":\\\"a\\\",\\\"val\\\":\\\"2\\\"},{\\\"name\\\":\\\"b\\\",\\\"val\\\":\\\"1704100010\\\"}]\"}]")

	//.withTextBodyContent('{"Token":"'+GlobalVariable.G_H_TOKEN+'","ComId":"'+17041002+'"}')	
	.build()

def List = WS.sendRequest(PostalList)
println(List.statusCode);
println(List.responseBodyContent);
assert List.getStatusCode() == 200;

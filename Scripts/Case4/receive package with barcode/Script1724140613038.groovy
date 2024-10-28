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
<<<<<<< HEAD
import internal.GlobalVariable as GlobalVariable
=======
>>>>>>> feature/noah-plus
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
<<<<<<< HEAD

'導航至管理版首頁'
WebUI.navigateToUrl('https://test.kingnetsmart.com.tw/community/main.aspx')
=======
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonOutput

'導航至管理版首頁'
WebUI.navigateToUrl(GlobalVariable.G_community)

WebUI.maximizeWindow()
>>>>>>> feature/noah-plus

WebUI.waitForPageLoad(2)

'郵務管理-領取'
WebUI.click(findTestObject('Object Repository/register the package/btn_management'))

WebUI.click(findTestObject('Object Repository/receive the package/btn_receive'))

<<<<<<< HEAD

=======
>>>>>>> feature/noah-plus
'領取方式-手機條碼'

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('receive the package/btn_camera_confirm'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/receive the package/type_barcode'), FailureHandling.CONTINUE_ON_FAILURE)

<<<<<<< HEAD
=======
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
WebUI.takeFullPageScreenshot('C:\\Users\\noahc\\Katalon Studio\\housekeeper regression\\ScreenShoot\\手機條碼領取包裹.png')

WebUI.closeBrowser()

/* 
>>>>>>> feature/noah-plus
'取得管理版 user token'
def response = WS.sendRequest(findTestObject('Object Repository/receive the package/Postman/1. Get Token'));
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent());

<<<<<<< HEAD
=======

>>>>>>> feature/noah-plus
'管理版 user token 存入全域變數'
U_Token = jsonResponse.Data.Token
GlobalVariable.G_H_TOKEN = U_Token
println("G_H_TOKEN: " + GlobalVariable.G_H_TOKEN)

<<<<<<< HEAD
=======

>>>>>>> feature/noah-plus
'取得 CommunityLogin token'
def CommunityLogin = new RestRequestObjectBuilder()
def requestObject_c_login = CommunityLogin
    .withRestRequestMethod("POST")
    .withRestUrl("https://test.kingnetsmart.com.tw/mvc/api/Login/CommunityLogin")
    .withHttpHeaders([
        new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")
    ])
<<<<<<< HEAD
    .withTextBodyContent('''
    {
        "Token": "${GlobalVariable.G_H_TOKEN}",
        "ComId": "17041002"
    }
    ''')
=======
    .withTextBodyContent('{"Token":"'+GlobalVariable.G_H_TOKEN+'","ComId":"'+17041002+'"}')
>>>>>>> feature/noah-plus
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
<<<<<<< HEAD
    GlobalVariable.G_C_COOKIE = cookie
    KeywordUtil.logInfo("G_C_COOKIE: " + GlobalVariable.G_C_COOKIE)
=======
    GlobalVariable.G_community = cookie
    KeywordUtil.logInfo("G_C_COOKIE: " + GlobalVariable.G_community)
>>>>>>> feature/noah-plus
} else {
    KeywordUtil.logInfo("No cookies found in the response.")
};


'checkUserCode'
def checkUserCode = new RestRequestObjectBuilder()
def requestObject_cc = checkUserCode
	.withRestRequestMethod("POST")
	.withRestUrl("https://test.kingnetsmart.com.tw/ajax/ajax.asmx/checkUserCode")
	.withHttpHeaders([
<<<<<<< HEAD
		new TestObjectProperty("Cookie", ConditionType.EQUALS,"${GlobalVariable.G_C_COOKIE}"),
=======
		new TestObjectProperty("Cookie", ConditionType.EQUALS,"${GlobalVariable.G_community}"),
>>>>>>> feature/noah-plus
		new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/x-www-form-urlencoded")
])
	.withTextBodyContent('code=583RHBP23D145014')
		.build()

def UserCode = WS.sendRequest(requestObject_cc)
println(UserCode.statusCode);
println(UserCode.responseBodyContent);
assert UserCode.getStatusCode() == 200;

<<<<<<< HEAD
/* 使用變數
final ResponseObject response = WS.sendRequest(yourRequestTestObject);
final String yourValue = new JsonSlurper()
	.parseText(response.getResponseBodyContent())
	.yourKey // replace with the key of the response data you're trying to get
*/

/*
'POST checkUserCode'
def checkUserCode = new RestRequestObjectBuilder()
def param = new FormDataBodyParameter("code", "583RHBP23D145014", "text" ,"multipart/form-data")
def paramList  = new ArrayList<FormDataBodyParameter>();
paramList.add(param)
def requestObject = checkUserCode
	.withRestRequestMethod("POST")
	.withRestUrl("https://local.kingnetsmart.com.tw/ajax/ajax.asmx/checkUserCode")
	.withHttpHeaders([
	    new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/x-www-form-urlencoded"),
		new TestObjectProperty("Cookie", ConditionType.EQUALS, "ASP.NET_SessionId=fxwuxcaphrgoph045jpfyqt1; _gid=GA1.3.285785722.1724219235; comLoginToken=token=x4/h3t9g+2cGflxQRaGaIJ2eWB9vGsh8WKMNvz3VX7PCq94eKM/edRvVXA40yv8FHZZ1A2FYyxPp5cq9DLHMVb5qvN8wFBKlhl3Wmtmr4x2HDRJyF9TDMG40JTHHhql7avJJyXNv8v2uhGsgbi7oAcX7qakQ44SLFI1DAjnR9QRC8JOY/OcYRsEmwylNYjyIfX2e4Y6fr1C4smNuj5WkMN/sSB//eeiJ0B/p7acf/xQdr4e02Sfasxh9xABkWFx+TVznv5Onj6dlJM0XAHCkho9d/YQZYEwYOqylmvjWakMqfqPXbHr0dB6gInjH029qpQrwXS8HNsv/fsj9PmevrG/Bm8blnHWdaMTINVdh7Rm4+pJeMB9MLjtLF9/JQAUq/qGayhoF6g70vgXVUrs1eWNQOVrNJrh+hDISx7PmBFcaEsUHKENHrAq0FuYbkx1e7Nvzrf3D34wpXoqy+PZlmhBNUdmjPrrqv/A1DHP5Hu5h75aMvbLWIP3MKw32noXQmIyFlasEe9OHTHalrX6QmV81Br2sx9B/P/Tqbob+DptDTCkiW3GtaOeaerzUDA0mpqomK8mxjqBU64mPF/dCK55D+ZMPqDtQG/my9o5n2pXNdRwtZ5f0+NdL6Ow9YEZMdx++9CvkpEy7ap5cFAr2PQ==; _gat=1; _ga=GA1.1.1006705594.1724219235; _ga_LZ1SBTJ3KH=GS1.3.1724292794.3.1.1724292822.32.0.0; _ga_ZB76RKYHFN=GS1.1.1724292147.3.1.1724292831.19.0.0")
	])
  //.withRestParameters([new TestObjectProperty("code", ConditionType.EQUALS, "583RHBP23D145014")])
	.withMultipartFormDataBodyContent([
		//paramList.toList()
		new FormDataBodyParameter("code", "583RHBP23D145014", "PARAM_TYPE_TEXT", "multipart/form-data")
    ])
	.build()

//println("1111111111111111111111111111111" + requestObject.bodyContent.contentLength)


//println("Request Body Length: " + requestObject.getBodyContent().getContentLength())
def response = WS.sendRequest(requestObject)
println(response.statusCode);
println(response.responseBodyContent);
assert response.getStatusCode() == 200
*/
=======

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

def tt = JsonOutput.toJson(List)
return tt

WebUI.delay(10)
*/


>>>>>>> feature/noah-plus

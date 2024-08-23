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

'導航至管理版首頁'
WebUI.navigateToUrl('https://test.kingnetsmart.com.tw/community/main.aspx')

WebUI.waitForPageLoad(2)

'郵務管理-領取'
WebUI.click(findTestObject('Object Repository/register the package/btn_management'))

WebUI.click(findTestObject('Object Repository/receive the package/btn_receive'))


'領取方式-手機條碼'

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('receive the package/btn_camera_confirm'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/receive the package/type_barcode'), FailureHandling.CONTINUE_ON_FAILURE)

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
    .withTextBodyContent('''
    {
        "Token": "${GlobalVariable.G_H_TOKEN}",
        "ComId": "17041002"
    }
    ''')
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

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

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

'編輯公告'
WebUI.click(findTestObject('Object Repository/announcement/btn_announcement'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/announcement/btn_edit'))

'快速領取'
WebUI.click(findTestObject('Object Repository/announcement/btn_quick_receive'))

'領取方式-手機條碼'
WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Object Repository/announcement/type_barcode'), FailureHandling.CONTINUE_ON_FAILURE)

'取得管理版 user token'
def response = WS.sendRequest(findTestObject('Object Repository/receive the package/Postman/1. Get Token'));
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent());

'管理版 user token 存入全域變數'
U_Token = jsonResponse.Data.Token
def G_H_TOKEN = U_Token
println("G_H_TOKEN: " + G_H_TOKEN)


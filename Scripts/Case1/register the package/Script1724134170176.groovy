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

'導航至管理版首頁'
WebUI.navigateToUrl("https://test.kingnetsmart.com.tw/community/main.aspx")

WebUI.waitForPageLoad(2)

'郵務管理-登記'
WebUI.click(findTestObject("Object Repository/register the package/btn_management"))

WebUI.click(findTestObject('Object Repository/register the package/btn_register'))

'信件包裹類型'
WebUI.click(findTestObject("Object Repository/register the package/checkbox_type"))

'選擇B2F3住戶資訊'
WebUI.click(findTestObject("Object Repository/register the package/checkbox_tablet"))

WebUI.click(findTestObject("Object Repository/register the package/checkbox_building (A)"))

WebUI.click(findTestObject("Object Repository/register the package/checkbox_floor (2F)"))

WebUI.click(findTestObject("Object Repository/register the package/checkbox_A1F2"))

WebUI.click(findTestObject("Object Repository/register the package/checkbox_address (Nc AutoTest)"), FailureHandling.CONTINUE_ON_FAILURE)

'收件人'
WebUI.setText(findTestObject("Object Repository/register the package/input_addressee"), addressee)

'通知住戶'
WebUI.click(findTestObject("Object Repository/register the package/btn_notify"))
/*
'確認完成'
WebUI.click(findTestObject("Object Repository/register the package/btn_confirm"))
*/
'登記成功截圖'
WebUI.delay(3)
WebUI.takeFullPageScreenshot('C:\\Users\\noahc\\Katalon Studio\\Sprint3-housekeeper (Noah) 2.0\\ScreenShoot\\register.png')

'包裹登記結果'
WebUI.click(findTestObject("Object Repository/register the package/btn_result"))

WebUI.closeBrowser()
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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

'導航至管理版首頁'
WebUI.navigateToUrl('https://test.kingnetsmart.com.tw/community/main.aspx')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

'領取物品'
WebUI.click(findTestObject("Object Repository/register things/btn_registerThings"))

WebUI.waitForPageLoad(3)

WebUI.click(findTestObject('receive the package/btn_camera_confirm'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject("Object Repository/receive things/btn_receive"))

'寄放領取'
//Step2. 選擇戶別
WebUI.click(findTestObject("Object Repository/receive things/type_barcode"))

WebUI.setText(findTestObject('Object Repository/receive things/input_token'), code)

WebUI.sendKeys(findTestObject('Object Repository/receive things/input_token'), Keys.chord(Keys.ENTER))

'選取包裹'
//Step3. 確認細項
WebUI.scrollToElement(findTestObject('Object Repository/receive things/title_list'), 3)

WebUI.click(findTestObject("Object Repository/receive things/checkbox_first"))

WebUI.delay(3)

// WebUI.click(findTestObject("null"))

WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/receive things/btn_send'),30) 

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

WebUI.delay(3)
//截圖路徑
WebUI.takeFullPageScreenshot('C:\\Users\\noahc\\Katalon Studio\\Sprint3-housekeeper (Noah) 2.0\\ScreenShoot\\手機條碼領取寄物.png')

WebUI.closeBrowser()


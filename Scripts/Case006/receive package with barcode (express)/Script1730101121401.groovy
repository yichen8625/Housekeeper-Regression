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
<<<<<<< HEAD
WebUI.navigateToUrl('https://test.kingnetsmart.com.tw/community/main.aspx')
=======
WebUI.navigateToUrl(GlobalVariable.G_community)
>>>>>>> feature/noah-plus

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

'編輯公告'
WebUI.click(findTestObject('Object Repository/table/wrap_announcement'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/table/announcement/btn_edit'))

<<<<<<< HEAD
'快速領取'
=======
'快速領取btn'
<<<<<<< HEAD:Scripts/Case6/receive package with barcode (express)/Script1724638049870.groovy
>>>>>>> feature/noah-plus
WebUI.click(findTestObject('Object Repository/announcement/btn_quick_receive'))
=======
WebUI.click(findTestObject('Object Repository/table/btn_quick_receive'))
>>>>>>> main:Scripts/Case006/receive package with barcode (express)/Script1730101121401.groovy

'領取方式-手機條碼'
WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Object Repository/quick receive/wrap_barcode'), FailureHandling.CONTINUE_ON_FAILURE)

<<<<<<< HEAD:Scripts/Case6/receive package with barcode (express)/Script1724638049870.groovy
<<<<<<< HEAD
'取得管理版 user token'
def response = WS.sendRequest(findTestObject('Object Repository/receive the package/Postman/1. Get Token'));
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent());


=======
WebUI.setText(findTestObject('Object Repository/receive the package/input_quick_token'), code)
=======
WebUI.setText(findTestObject('Object Repository/quick receive/input_token'), code)
>>>>>>> main:Scripts/Case006/receive package with barcode (express)/Script1730101121401.groovy

WebUI.sendKeys(findTestObject('Object Repository/quick receive/input_token'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/quick receive/receive-package/btn_quick_confirm'))

'快速領取'

WebUI.click(findTestObject('Object Repository/quick receive/receive-package/checkbox_all'))

WebUI.click(findTestObject('Object Repository/quick receive/receive-package/checkbox_first'))

WebUI.click(findTestObject('Object Repository/quick receive/receive-package/btn_receive'))

WebUI.delay(3)
//截圖路徑
WebUI.takeFullPageScreenshot('C:\\AutoTest-MGMT (Screenshoot)\\Case06 用智生活手機條碼快速領取包裹\\(快速領取)手機條碼領取包裹.png')

WebUI.closeBrowser()
>>>>>>> feature/noah-plus

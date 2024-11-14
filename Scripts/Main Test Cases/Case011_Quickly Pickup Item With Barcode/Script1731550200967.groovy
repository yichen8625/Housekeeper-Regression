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
WebUI.navigateToUrl(GlobalVariable.G_community)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

'編輯公告'
WebUI.click(findTestObject('Object Repository/Table Page/div_Announcement'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Announcement/a_EditButton'))

'快速領取btn'
WebUI.click(findTestObject('Object Repository/Table Page/label_QuickReceive Button'))

'領取方式-手機條碼'
WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Object Repository/QuickReceive Page/div_Barcode'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/QuickReceive Page/input_token'), code)

WebUI.sendKeys(findTestObject('Object Repository/QuickReceive Page/input_token'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/QuickReceive Page/Pickup Package Page/btn_quick_confirm'))

'寄放tab'
WebUI.click(findTestObject('Object Repository/QuickReceive Page/Pickup Item Page/tab_item'))

WebUI.delay(3)

'選取寄放物品'
//Step3. 確認細項
WebUI.click(findTestObject("Object Repository/QuickReceive Page/Pickup Item Page/checkbox_list"))

WebUI.click(findTestObject('Object Repository/QuickReceive Page/Pickup Package Page/btn_ConfirmReceive'))

WebUI.delay(3)
//截圖路徑
WebUI.takeFullPageScreenshot('C:\\AutoTest-MGMT (Screenshoot)\\Case11 用掃描手機條碼快速領取寄放物品\\手機條碼領取寄物.png')

WebUI.closeBrowser()


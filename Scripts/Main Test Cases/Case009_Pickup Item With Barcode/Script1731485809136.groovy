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

'領取物品'
WebUI.click(findTestObject("Object Repository/Table Page/div_Item"))

WebUI.delay(3)

WebUI.click(findTestObject('Page_Package/Pickup Packages Page/btn_CameraConfirm'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject("Object Repository/Page_Item/div_Pickup"))

'寄放領取'
//Step2. 選擇戶別
WebUI.click(findTestObject("Object Repository/Page_Item/Pick Items Page/Step2 - Tablet Choose/div_Barcode"))

WebUI.setText(findTestObject('Object Repository/Page_Item/Pick Items Page/Step2 - Tablet Choose/input_BarcodeToken'), code)

WebUI.sendKeys(findTestObject('Object Repository/Page_Item/Pick Items Page/Step2 - Tablet Choose/input_BarcodeToken'), Keys.chord(Keys.ENTER))

'選取包裹'
//Step3. 確認細項
WebUI.scrollToElement(findTestObject('Object Repository/Page_Item/Pick Items Page/Step3 - Detail Check/div_TitleNote'), 3)

WebUI.click(findTestObject("Object Repository/Page_Item/Pick Items Page/Step3 - Detail Check/label_SelectFirst"))

WebUI.delay(3)

// WebUI.click(findTestObject("null"))

WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_Item/Pick Items Page/Step3 - Detail Check/input_ConfirmSend'),30) 

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

WebUI.delay(3)
//截圖路徑
WebUI.takeFullPageScreenshot('C:\\AutoTest-MGMT (Screenshoot)\\Case09 用智生活手機條碼領取寄放物品\\手機條碼領取寄物.png')

WebUI.closeBrowser()


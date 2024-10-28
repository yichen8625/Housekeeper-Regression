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
WebUI.navigateToUrl(GlobalVariable.G_community)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

'寄放物品'
WebUI.click(findTestObject("Object Repository/register things/btn_registerThings"))

WebUI.waitForPageLoad(3)

WebUI.click(findTestObject('receive the package/btn_camera_confirm'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/register things/btn_register'))

'寄放領取'
//Step2. 選擇戶別
WebUI.click(findTestObject("Object Repository/register things/btn_else"))

WebUI.setText(findTestObject('Object Repository/register things/input_name'), name)

WebUI.click(findTestObject("Object Repository/register things/btn_tablet"))

WebUI.click(findTestObject("Object Repository/register the package/checkbox_building (太陽)"))

WebUI.click(findTestObject("Object Repository/register the package/checkbox_floor (1樓)"))

WebUI.click(findTestObject("Object Repository/register the package/checkbox_太陽1樓-1"))

WebUI.click(findTestObject("Object Repository/register things/checkbox_selecter"))

WebUI.click(findTestObject("Object Repository/register things/btn_nextstep"))

//Step3. 確認細項
WebUI.click(findTestObject("Object Repository/register things/checkbox_type"))

WebUI.click(findTestObject("Object Repository/register things/checkbox_content"))

WebUI.click(findTestObject("Object Repository/register things/btn_send"))

'登記成功截圖'
WebUI.delay(3)
//截圖路徑
WebUI.takeFullPageScreenshot('C:\\Users\\noahc\\Katalon Studio\\housekeeper regression\\ScreenShoot\\寄放物品登記.png')

WebUI.closeBrowser()



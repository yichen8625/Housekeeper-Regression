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
WebUI.click(findTestObject("Object Repository/table/wrap_item"))

WebUI.delay(3)

WebUI.click(findTestObject('table/package/receive packages/btn_camera_confirm'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/table/item/register items/btn_register'))

'寄放領取'
//Step2. 選擇戶別
WebUI.click(findTestObject("Object Repository/table/item/register items/Step2 - tablet choose/btn_else"))

WebUI.setText(findTestObject('Object Repository/table/item/register items/Step2 - tablet choose/input_name'), name)

WebUI.click(findTestObject("Object Repository/table/item/register items/Step2 - tablet choose/btn_tablet"))

WebUI.click(findTestObject("Object Repository/table/package/register packages/register/tablet/checkbox_building (太陽)"))

WebUI.click(findTestObject("Object Repository/table/package/register packages/register/tablet/checkbox_floor (1樓)"))

WebUI.click(findTestObject("Object Repository/table/package/register packages/register/tablet/checkbox_太陽1樓-1"))

WebUI.click(findTestObject("Object Repository/table/item/register items/Step2 - tablet choose/checkbox_selecter"))

WebUI.click(findTestObject("Object Repository/table/item/register items/Step2 - tablet choose/btn_nextstep"))

//Step3. 確認細項
WebUI.click(findTestObject("Object Repository/table/item/register items/Step3 - detail check/checkbox_type"))

WebUI.click(findTestObject("Object Repository/table/item/register items/Step3 - detail check/checkbox_content"))

WebUI.click(findTestObject("Object Repository/table/item/register items/Step3 - detail check/btn_send"))

'登記成功截圖'
WebUI.delay(3)
//截圖路徑
WebUI.takeFullPageScreenshot('C:\\AutoTest-MGMT (Screenshoot)\\Case08 管理員完成寄放物品登記\\寄放物品登記.png')

WebUI.closeBrowser()



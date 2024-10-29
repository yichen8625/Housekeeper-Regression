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

'社區公告登記'
WebUI.click(findTestObject('Object Repository/announcement/btn_announcement'))

WebUI.delay(2)

'新增公告'
WebUI.click(findTestObject('Object Repository/announcement/btn_add'))

'展開列表'
WebUI.click(findTestObject("Object Repository/housekeeper logout/btn_logininfo_announcement"))

WebUI.delay(3)

WebUI.takeFullPageScreenshot('C:\\AutoTest-MGMT (Screenshoot)\\Case14 能從公告列表頁完成登出\\登出前.png')

WebUI.click(findTestObject("Object Repository/housekeeper logout/btn_logout_announcement"))

'登出後截圖'
WebUI.delay(3)

WebUI.takeFullPageScreenshot('C:\\AutoTest-MGMT (Screenshoot)\\Case14 能從公告列表頁完成登出\\登出後.png')
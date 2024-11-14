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

'close toast'
WebUI.click(findTestObject('Object Repository/Table Page/i_ToastClose'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject("Object Repository/Table Page/div_Tablet"))

'快速開通服務'
WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/Tablet Info Popup/option_Building (太陽)"))

WebUI.click(findTestObject('Object Repository/Page_Tablet/option_Floor (1樓)'))

WebUI.click(findTestObject('Object Repository/Page_Tablet/option_Tablet (太陽1樓-1)'))

'選擇開通方式'
WebUI.click(findTestObject("Object Repository/Page_Tablet/Activate Pages/div_Barcode"))

WebUI.takeFullPageScreenshot('C:\\AutoTest-MGMT (Screenshoot)\\Case15 能用智生活App手機條碼完成裝置開通戶別\\手機條碼掃描.png')

WebUI.setText(findTestObject('Object Repository/Page_Tablet/Activate Pages/input_BarcodeToken'), code)

WebUI.sendKeys(findTestObject('Object Repository/Page_Tablet/Activate Pages/input_BarcodeToken'), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.takeFullPageScreenshot('C:\\AutoTest-MGMT (Screenshoot)\\Case15 能用智生活App手機條碼完成裝置開通戶別\\手機條碼開通戶別.png')
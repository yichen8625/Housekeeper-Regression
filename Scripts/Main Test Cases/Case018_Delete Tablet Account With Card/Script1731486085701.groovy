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

'住戶開通進階功能'
WebUI.click(findTestObject('Object Repository/Page_Tablet/span_AdvanceFunction'))

WebUI.waitForPageLoad(3)

'住戶裝置資訊'
WebUI.click(findTestObject('Object Repository/Page_Tablet/Tablet Devices Info Page/btn_search'))

WebUI.click(findTestObject('Object Repository/Page_Tablet/Tablet Devices Info Page/a_CardTab'))

WebUI.takeScreenshot('C:\\AutoTest-MGMT (Screenshoot)\\Case18 能用管理版Web完成門禁卡解除戶別\\After解除戶別.png')

WebUI.click(findTestObject('Object Repository/Page_Tablet/Tablet Devices Info Page/btn_QuicklyTermination Card'))

'快速解除載具'
WebUI.setText(findTestObject('Object Repository/Page_Tablet/Tablet Devices Info Page/input_CardToken'), code)

WebUI.sendKeys(findTestObject('Object Repository/Page_Tablet/Tablet Devices Info Page/input_CardToken'), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.takeScreenshot('C:\\AutoTest-MGMT (Screenshoot)\\Case18 能用管理版Web完成門禁卡解除戶別\\BeforeAfter解除戶別.png')
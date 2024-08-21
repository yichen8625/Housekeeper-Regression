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
WebUI.navigateToUrl('https://test.kingnetsmart.com.tw/community/main.aspx')

WebUI.waitForPageLoad(2)

'郵務管理-領取'
WebUI.click(findTestObject('Object Repository/register the package/btn_management'))

WebUI.click(findTestObject('Object Repository/receive the package/btn_receive'))

WebUI.waitForPageLoad(2)

'領取方式-手機條碼'
WebUI.click(findTestObject('Object Repository/receive the package/type_barcode'))

WebUI.waitForPageLoad(10)

WebUI.doubleClick(findTestObject('receive the package/btn_camera_confirm'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/receive the package/type_barcode'), FailureHandling.CONTINUE_ON_FAILURE)



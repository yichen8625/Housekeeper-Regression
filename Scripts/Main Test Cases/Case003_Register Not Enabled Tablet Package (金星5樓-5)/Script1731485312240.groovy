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

import java.awt.Color
import java.awt.Font
import java.awt.FontMetrics
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import javax.imageio.ImageIO
import com.kms.katalon.core.configuration.RunConfiguration

'導航至管理版首頁'
WebUI.navigateToUrl(GlobalVariable.G_community)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

'郵務管理-登記'
WebUI.click(findTestObject("Object Repository/Table Page/div_Package"))

WebUI.click(findTestObject('Object Repository/Page_Package/div_Register'))

'信件包裹類型'
WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/i_TruckIcon"))

WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/Package Info Popup/option_Package"))

WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/Package Info Popup/option_Tcat"))

WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/Package Info Popup/btn_NextStep"))

'選擇金星5樓-5住戶資訊'
WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/Tablet Info Popup/option_Building (金星)"))

WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/Tablet Info Popup/option_Floor (5樓)"))

WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/register/Tablet Info Popup/Option_金星5樓-5"))

'收件人'
//WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/option_RegisterName"))

'通知住戶'
WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/btn_NotifyAddressee"))

'確認完成'
WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/btn_ConfirmComplete"))

/*
'確認完成'
WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/btn_ConfirmComplete"))
*/
'登記成功截圖'
WebUI.delay(3)

//截圖路徑
WebUI.takeFullPageScreenshot('C:\\AutoTest-MGMT (Screenshoot)\\Case03 完成掛牌包裹登記\\(金星5樓-5)包裹登記.png')

'包裹登記結果'
WebUI.click(findTestObject("Object Repository/Page_Package/Register Packages Page/btn_ConfirmLeave"))

WebUI.closeBrowser()
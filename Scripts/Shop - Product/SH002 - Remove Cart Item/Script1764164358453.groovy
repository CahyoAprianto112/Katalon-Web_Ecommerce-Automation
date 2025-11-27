import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import keywords.product.ProductActions

// login
WebUI.callTestCase(findTestCase('Login/LG_001'), [:], FailureHandling.STOP_ON_FAILURE)

// buat instance reusable keyword
ProductActions product = new ProductActions()

// step: buka detail → add → buka cart
product.openProductDetail()
product.addProduct()
product.openCart()

// pastikan tombol remove ada
if (WebUI.verifyElementPresent(findTestObject('Shop - Product/SH002 - Remove Product/Page_Swag Labs/button_29.99_remove-sauce-labs-backpack'), 3, FailureHandling.OPTIONAL)) {
	product.removeProduct()
	WebUI.comment("✔ Remove berhasil")
} else {
	WebUI.comment("❌ Remove gagal karena tombol tidak ditemukan")
}

WebUI.closeBrowser()


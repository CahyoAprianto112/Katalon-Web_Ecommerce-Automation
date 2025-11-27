import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import keywords.product.ProductActions as ProductActions
import keywords.product.CheckoutActions as CheckoutActions

// login
WebUI.callTestCase(findTestCase('Login/LG_001'), [:], FailureHandling.STOP_ON_FAILURE)

// buat instance reusable keyword
ProductActions product = new ProductActions()

CheckoutActions checkout = new CheckoutActions()

// step: buka detail → add → buka cart → checkout
product.openProductDetail()

product.addProduct()

product.openCart()

// field kosong
checkout.fillEmptyCheckoutForm()

WebUI.closeBrowser()


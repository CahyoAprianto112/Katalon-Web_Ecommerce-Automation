package keywords.product

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class CheckoutActions {
	@Keyword
	def fillCheckoutForm(String firstName, String lastName, String postalcode) {
		WebUI.click(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/button_Continue Shopping_checkout'))
		WebUI.setText(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/input_Checkout Your Information_first-name'),
				firstName)

		WebUI.setText(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/input_Checkout Your Information_last-name'),
				lastName)

		WebUI.setText(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/input_Checkout Your Information_postal-code'),
				postalcode)

		WebUI.click(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/input_Cancel_continue'))
	}
	
	@Keyword
	def fillEmptyCheckoutForm() {
		WebUI.click(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/button_Continue Shopping_checkout'))
		WebUI.setText(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/input_Checkout Your Information_first-name'), '')
		WebUI.setText(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/input_Checkout Your Information_last-name'), '')
		WebUI.setText(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/input_Checkout Your Information_postal-code'), '')
		// Trigger error message
		WebUI.click(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/input_Cancel_continue'))
	
		// Verify error
		WebUI.verifyElementText(
			findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/div_Checkout Your Information_error-message-container error'),
			'Error: First Name is required'
		)
	}

	@Keyword
	def finishOrder() {
		WebUI.verifyElementPresent(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/span_Swag Labs_title'), 0)
		WebUI.click(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/button_Cancel_finish'))
		WebUI.click(findTestObject('Shop - Product/SH003 - Checkout/Page_Swag Labs/button_Your order has been dispatched, and _4011f3'))
	}
}

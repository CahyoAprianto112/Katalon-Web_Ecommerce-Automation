package keywords.product

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class ProductActions {

	@Keyword
	def openProductDetail() {
		WebUI.click(findTestObject('Shop - Product/SH001 - Add to Cart/Page_Swag Labs/div_Name (A to Z)_inventory_item_name'))
	}

	@Keyword
	def addProduct() {
		WebUI.click(findTestObject('Shop - Product/SH001 - Add to Cart/Page_Swag Labs/button_29.99_add-to-cart'))
	}

	@Keyword
	def openCart() {
		WebUI.click(findTestObject('Shop - Product/SH001 - Add to Cart/Page_Swag Labs/a_Swag Labs_shopping_cart_link'))
	}

	@Keyword
	def removeProduct() {
		WebUI.click(findTestObject('Shop - Product/SH002 - Remove Product/Page_Swag Labs/button_29.99_remove-sauce-labs-backpack'))
	}
}

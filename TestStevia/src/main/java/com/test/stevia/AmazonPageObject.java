package com.test.stevia;

import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.persado.oss.quality.stevia.selenium.core.WebComponent;

public class AmazonPageObject extends WebComponent{
	
	
	public enum AmazonPageLocators {
		AMAZON_LINK_NEWS("css=a[href*='nav_upnav_LargeImage_C_Gateway']"),
		AMAZON_LINK_INTERSTING("xpath=//*[@id=\"nav-upnav\"]/a"),
		AMAZON_UL("xpath=//*[@id=\"airstream-results\"]"),
		AMAZON_LI("xpath=//*[@id=\\\"airstream-results\\\"]/li"),
		AMAZON_THIRD("//*[@id=\"airstream-results\"]/li[3]"),
		AMAZON_SELECT_THIRD("xpath=//*[@id=\"a-popover-content-3\"]/span"),
		AMAZON_PRICE_ELEMENT("//*[@id=\"priceblock_ourprice\"]"),
		AMAZON_ADD_TO_CART("add-to-cart-button"),
		AMAZON_SELECTED_ELEMENT("//*[@id=\"huc-v2-order-row-container\"]/div"),
		AMAZON_PRICE_CHOSEN("x-path=//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]"),
		AMAZON_GET_CART_PRICE("x-path=//*[@id=\"activeCartViewForm\"]/div[2]/div/div[4]/div/div[2]/p/span"),
		AMAZON_CART("nav-cart-count");
		

		AmazonPageLocators(String locator) {
			myLocator = locator;
		}

		private String myLocator;

		public String get() {
			return myLocator;
		}

		public String getWithParams(Object... params) {
			return MessageFormat.format(myLocator, params);
		}
	}
	
	public void findInterests() {
		//controller().click(AmazonPageLocators.AMAZON_LINK_NEWS.get());
		controller().click(AmazonPageLocators.AMAZON_LINK_INTERSTING.get());		
	}
	
    
	public void  getThridElement() {
		List<WebElement> allLis = controller().findElements(AmazonPageLocators.AMAZON_UL.get());
			
		int s=allLis.size();
		
		for(int i=0; i<s; i++) {
			allLis = controller().findElements(AmazonPageLocators.AMAZON_THIRD.get());
			controller().click(AmazonPageLocators.AMAZON_THIRD.get());
		}	
		
	}
	
	public void select3rdElement() {
		controller().waitForElementPresence(AmazonPageLocators.AMAZON_SELECT_THIRD.get());
		controller().click(AmazonPageLocators.AMAZON_SELECT_THIRD.get());
	} 
	
	
	public int getPriceElement() {
		controller().waitForElementPresence(AmazonPageLocators.AMAZON_PRICE_ELEMENT.get());
		return controller().getNumberOfElementsMatchLocator(AmazonPageLocators.AMAZON_PRICE_ELEMENT.get());
	}
	
	
	public void addToCart() {
		controller().press(AmazonPageLocators.AMAZON_ADD_TO_CART.get());
	}
	
	public int hereIsThePrice() {
		controller().waitForElementPresence(AmazonPageLocators.AMAZON_SELECTED_ELEMENT.get());
		return controller().getNumberOfElementsMatchLocator(AmazonPageLocators.AMAZON_PRICE_CHOSEN.get());
		
	}
	
	public void goToCart() {
		controller().press(AmazonPageLocators.AMAZON_CART.get());
	}
	
	
	public int getPriceFromCart() {
		return controller().getNumberOfElementsMatchLocator(AmazonPageLocators.AMAZON_GET_CART_PRICE.get());
	}
}



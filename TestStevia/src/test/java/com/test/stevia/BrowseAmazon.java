package com.test.stevia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.persado.oss.quality.stevia.spring.SteviaTestBase;

public class BrowseAmazon extends SteviaTestBase{
	
	//private static final Logger LOG = LoggerFactory.getLogger(BrowseAmazon.class);
	private static final Logger LOG = LoggerFactory.getLogger("VerifyLog");

	
	@Autowired
	private AmazonPageObject amazonPage;
	
	@Test
	public void enterNewInteresting(){

		int price=0,cartPrice=0,priceChosen=0;
		
		amazonPage.findInterests();
		amazonPage.getThridElement();
		amazonPage.select3rdElement();
	    //price = amazonPage.getPriceElement();
	   // System.out.print(price);
		amazonPage.addToCart();
		priceChosen = amazonPage.hereIsThePrice();
		amazonPage.goToCart();
		cartPrice = amazonPage.getPriceFromCart();
		//System.out.print(cartPrice);
		
		if(priceChosen==cartPrice) {
			LOG.info("Prices Equal");
		}
		
		else {
			LOG.error("Prices Not Equal");
		}
	}
	
	
}

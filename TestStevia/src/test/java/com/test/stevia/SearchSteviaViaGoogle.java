package com.test.stevia;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;
import com.persado.oss.quality.stevia.spring.SteviaTestBase;


@Component
public class SearchSteviaViaGoogle extends SteviaTestBase {
	
	
	@Autowired
	private GooglePageObject googlePage;
	
	
	@Test
	public void searchPersadoInGoogle(){
		googlePage.inputSearchTest("stevia git");
		googlePage.pressGoogleSearchButton();
		
	}
	
	
}

	
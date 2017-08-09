package com.test.stevia;

import java.text.MessageFormat;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;


public class GooglePageObject extends WebComponent {

	public enum GoogleHomePageLocators {
		INPUT_GOOGLE_SEARCH("lst-ib"), BTN_GOOGLE_SEARCH("name=btnK");

		GoogleHomePageLocators(String locator) {
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

	public void inputSearchTest(String desiredText) {
		controller().input(GoogleHomePageLocators.INPUT_GOOGLE_SEARCH.get(), desiredText);
	}

	public void pressGoogleSearchButton() {
		controller().click(GoogleHomePageLocators.BTN_GOOGLE_SEARCH.get());

	}

	

}

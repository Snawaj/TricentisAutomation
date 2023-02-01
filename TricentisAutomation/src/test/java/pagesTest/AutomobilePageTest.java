package pagesTest;

import org.testng.annotations.Test;

import base.BaseTest;

public class AutomobilePageTest extends BaseTest {

	@Test
  public void validateAutomobilePage() {
	  
	 automobilePage.verifyTitle();
	 	 
  }
	@Test
	public void firstScenario () {
		
		automobilePage.completeFormWithValidData();
	}
}

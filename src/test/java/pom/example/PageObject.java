package pom.example;

/*
 * Documentation for the PageFactory can be found here: 
 * 		
 * 		https://github.com/SeleniumHQ/selenium/wiki/PageFactory
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	protected WebDriver driver;
	
	public PageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

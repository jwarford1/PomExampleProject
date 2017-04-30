package pom.example;

/*
 *  Documentation for this tutorial can be found at: 
 *  
 *  	
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpFormTest extends WebDriverManager{
	
	static Properties prop = new Properties();
	static InputStream input = null;
	
	@Before
	public void setUpData(){
	
		try
		{

			input = new FileInputStream("src/test/resources/config.properties");

		    // load a properties file
		    prop.load(input);
	      
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		} 
		finally 
		{
			if (input != null) {
				try 
				{
					input.close();
		        } 
				catch (IOException e) 
				{
					e.printStackTrace();
		        }
		    }
		}
	}
	

	@Test
	public void signUp(){
	   
		//driver.get("http://www.kimschiller.com/page-object-pattern-tutorial/index.html");
		driver.get(prop.getProperty("url"));
		
		SignUpPage signUpPage = new SignUpPage(driver);
		assertTrue(signUpPage.isInitialized());
	
		signUpPage.enterName("First", "Last");
		signUpPage.enterAddress("123 Street", "12345");
	
		ReceiptPage receiptPage = signUpPage.submit();
		assertTrue(receiptPage.isInitialized());
	
		assertEquals("Thank you!", receiptPage.confirmationHeader());
	}
}

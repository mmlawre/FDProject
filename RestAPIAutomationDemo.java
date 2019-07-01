package Maventest;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

//import org.testng.annotations.Test;


public class RestAPIAutomationDemo {
	
	WebDriver driver;
	
	String api=" https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22 ";
	
	@Test
	public void RequestStatus(){
		
		System.out.println();
		int code = get(api).getStatusCode();
		System.out.println("API Request: "+api);
		System.out.println();
		System.out.println("Request Status Code: "+code);
		Assert.assertEquals(code, 200);
		
	}
	
	@Test
	public void Requesttime(){
		
		long time = get(api).getTime();
		System.out.println();
		System.out.println();
		System.out.println("Request Response Time: "+time+" ms");
		
	}
	
	@Test
	public void RequestResponseData(){
		
		String ResponseData = get(api).asString();
		System.out.println();
		System.out.println();
		System.out.println("Response Data: "+ResponseData);
				
	}

	
}

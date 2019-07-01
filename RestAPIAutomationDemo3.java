package Maventest;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;



public class RestAPIAutomationDemo3 {
	
	public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

	@Test(priority = 0)
	public void ResponseDataCount(){
		
		  Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");

	        List<String> jsonResponse = response.jsonPath().getList("$");

	        System.out.println("Rest API Request URL: https://jsonplaceholder.typicode.com/users");
	        System.out.println();
	        
	        System.out.println("Response Data Count: "+jsonResponse.size());
	        System.out.println();
	}
	
	
	
	@Test(priority = 1)
	public void GetEmpoyeeArray(){
		
		   Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");
 		   System.out.println("Get the Employee Name Array: ");
	        String usernames = response.jsonPath().getString("username");
	        System.out.println(usernames);
	        System.out.println();
	}
	
	@Test(priority = 2)
	public void GetEmployeeNames(){
		Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");
		String usernames1 = response.jsonPath().getString("username[4]");
        System.out.println("Display 5th Employee Name: "+ usernames1);
        
        String usernames2 = response.jsonPath().getString("username[9]");
        System.out.println("Display 10th Employee Name: "+ usernames2);
        
	}
	
	@Test(priority = 3)
	public void GetEmployeeCompany(){
		Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");
		System.out.println("Get the Employee company Array: ");
        String companyMap = response.jsonPath().getString("company");
        System.out.println(companyMap);
        System.out.println();
	}
	
	@Test(priority = 4)
	public void Get5thEmployeeCompanyName(){
		 System.out.println("Get the 5th Employee company Array: ");
		 Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");
	     String companyMap1 = response.jsonPath().getString("company[4]");
	     System.out.println(companyMap1);
	     System.out.println();

	        
	     String companyMap2 = response.jsonPath().getString("company[4].name");
	     System.out.println("Get the Fifth Employee Company Name: " + companyMap2);
	}
}

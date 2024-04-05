package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ConversionRate {
	public static  Response response;
	

   @Given("set the endpoint")
    public void setEndPoint() {
	RestAssured.baseURI="https://v6.exchangerate-api.com/v6/4ee631bf296375968b750e54/latest/USD";
    }
   
   @Given("get the response")
   public void get_response() {
	   Response response=RestAssured.get();
	   response.prettyPrint();
	   response.then().assertThat().statusCode(200);
	   System.out.println("Status code is success 200");
   }
   
   @When("print the conversion rate")
   public void conversion_rates() {
	   Response response=RestAssured.get();
	   String conv_rates = response.jsonPath().getString("conversion_rates.INR");
	   System.out.println(conv_rates);
   }
   
   
   @When("verify the status code as 200")
   public void status_code_check() {
	   Response response=RestAssured.get();
	   response.then().assertThat().statusCode(200);
   }
   

}

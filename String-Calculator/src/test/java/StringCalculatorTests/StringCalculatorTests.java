package StringCalculatorTests;

import org.example.StringCalculator;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.*;


public class StringCalculatorTests {

    private StringCalculator sc;

    @Test
    public void emptyString(){
        assertEquals(sc.add(""),0);
    }

    @Test
    public void singleNumber(){
        assertEquals(1, sc.add("1"));
    }

    @Test
    public void twoNumbers(){
        assertEquals(3, sc.add("1,2"));
    }

    @Test
    public void moreThanTwoNumbers(){
       try{
           assertEquals("More than 2 numbers not allowed.", sc.add("1,2,3"));
           Assert.fail("Should have thrown an exception");
       }
       catch (Exception e){
           String expectedMessage = "More than 2 numbers not allowed.";
           assertEquals(expectedMessage, e.getMessage());
       }
    }


    @Test
    @AfterMethod
    public void calculationsCompleted(){
        System.out.println("Calculations Completed.");
    }
}

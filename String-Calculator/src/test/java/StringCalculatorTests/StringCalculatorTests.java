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
       assertEquals(6, sc.add("1,2,3"));
    }

    @Test
    public void handleNewLines(){
        assertEquals(10, sc.add("1\n2\n3,4"));
    }

    @Test
    public void handleNonNumber(){
        try{
            assertEquals("Digit not found.", sc.add("1,X"));
            Assert.fail("Should throw an exception");
        }
        catch (Exception e){
            String expectedMessage = "Digit not found.";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void handleCustomDelimiters(){
        assertEquals(3, sc.add("//;\n1;2"));
    }

    @Test
    public void negativeNumbers(){
        try{
            assertEquals("negatives not allowed: -1,-2", sc.add("-1,-2,3"));
            Assert.fail("Should throw an exception");
        }
        catch (Exception e){
            String expectedMessage = "negatives not allowed: -1,-2";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void ignoreNumbersBiggerThan1000(){
        assertEquals(2,sc.add("1002,2"));
    }


    @Test
    @AfterMethod
    public void calculationsCompleted(){
        System.out.println("Calculations Completed.");
    }
}

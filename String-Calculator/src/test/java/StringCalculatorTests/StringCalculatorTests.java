package StringCalculatorTests;

import org.example.StringCalculator;
import org.junit.After;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;


public class StringCalculatorTests {

    private StringCalculator sc;


    @BeforeMethod
    @Test
    public void setUp(){
        System.out.println("Testing calculations...");
        sc = new StringCalculator();
    }


    //Test Empty String
    @Test
    public void emptyString(){
        assertEquals(sc.add(""),0);
    }

    //Test Single number
    @Test
    public void testOneNumber(){
        assertEquals(1, sc.add("1"));
        assertEquals(10, sc.add("10"));
    }

    //Test Two Numbers
    @Test
    public void testTwoNumbers(){
        assertEquals(3, sc.add("1,2"));
        assertEquals(30, sc.add("10,20"));
    }

    @Test
    @AfterMethod
    public void calculationsCompleted(){
        System.out.println("Calculations Completed.");
    }
}

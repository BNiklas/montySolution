package se.comhem.test.montyhall;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MontyCalculatorTest {

    Request request;
    MontyCalculator tester;

    @Before
    public void init(){
        tester = new MontyCalculator();
    }

    @Test
    public void ifSwapTrueReturnOverSixty() {
        request = new Request(1000,true);
        assertTrue(tester.calc(request) > 600);
    }
    @Test
    public void ifSwapFalseReturnUnderForty(){
        request = new Request(1000,false);
        assertTrue(tester.calc(request) < 400);
    }

}
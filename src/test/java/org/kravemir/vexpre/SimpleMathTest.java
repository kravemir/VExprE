package org.kravemir.vexpre;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by miroslav on 5/1/16.
 */
public class SimpleMathTest extends AbstractParserTest {

    @Test
    public void basicArithmetics() {
        assertEquals(evaluateExprWithoutContext("1.0+1.0"),2.0,0.01);
        assertEquals(evaluateExprWithoutContext("1.0*3.0"),3.0,0.01);
        assertEquals(evaluateExprWithoutContext("1.0+1.0*3.0"),4.0,0.01);
    }
}

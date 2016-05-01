package org.kravemir.vexpre;

import org.junit.Test;

public class BasicTests extends AbstractParserTest {

    @Test
    public void basicArithmetics() {
        checkExpr("1 + 1",2.0);
        checkExpr("1 - 1",0.0);
        checkExpr("1 * 3",3.0);
        checkExpr("1 / 2",0.5);

        checkExpr("2 * 3 * 10",60.0);
    }

    @Test
    public void operatorPrecedence() {
        checkExpr("1 + 1 * 3",4.0);
        checkExpr("(1+1) * 3",6.0);
    }

    @Test
    public void variables() {
        InputContextImpl context = new InputContextImpl();
        context.put("a", 2.0);
        context.put("b", 3.0);

        checkExpr("1 + a",3.0,context);
        checkExpr("a * 3",6.0,context);
        checkExpr("a + b * 3",11.0,context);
        checkExpr("(a+b) * 3",15.0,context);
    }
}

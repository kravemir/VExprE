package org.kravemir.vexpre;

import org.junit.Test;
import org.kravemir.vexpre.api.InputContext;
import org.kravemir.vexpre.values.IntValue;
import org.kravemir.vexpre.values.VectorValue;

import static org.junit.Assert.assertEquals;

public class VectorTests extends AbstractParserTest {

    private InputContext baseInputContext;

    public VectorTests() {
        InputContextImpl inputContext = new InputContextImpl();
        inputContext.put("vec", VectorValue.makeCreateFunc());
        baseInputContext = inputContext;
    }

    @Test
    public void operatorTests() {
        /* TODO
         * operations:
         *  - scalar x vector: *
         *  - vector x scalar: *, /
         *  - vector x vector: +, -
         * checkDimensionMismatch exception / warnings
         */

        assertEquals(evaluateExpr("vec(1,2,3)",baseInputContext), new VectorValue(1.0, 2.0, 3.0));
    }

    @Test
    public void functionTests() {
        /* TODO
         * functions:
         *  length
         *  dot product
         *  ...
         */
        assertEquals(evaluateExpr("vec(1,2,3).dimension",baseInputContext), new IntValue(3));
    }
}

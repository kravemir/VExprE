package org.kravemir.vexpre;

import org.kravemir.vexpre.api.InputContext;
import org.kravemir.vexpre.api.Value;
import org.kravemir.vexpre.parser.ParseException;
import org.kravemir.vexpre.parser.VExprEParser;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public abstract class AbstractParserTest {
    protected Value evaluateExpr(String expr, InputContext context) throws ParseException {
        VExprEParser parser = new VExprEParser(new StringReader(expr));
        parser.setInputContext(context);
        return parser.expression();
    }

    protected void checkExpr(String expr, Double val) throws ParseException {
        checkExpr(expr,val,new InputContextImpl());
    }

    protected void checkExpr(String expr, Double val, InputContext context) throws ParseException {
        assertEquals(val,evaluateExpr(expr,context).asDouble(),0.001);
    }
}

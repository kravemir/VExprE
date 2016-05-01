package org.kravemir.vexpre;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.kravemir.vexpre.api.InputContext;
import org.kravemir.vexpre.parser.VExprELexer;
import org.kravemir.vexpre.parser.VExprEParser;

import static org.junit.Assert.assertEquals;

public abstract class AbstractParserTest {
    protected double evaluateExpr(String expr, InputContext context) {
        VExprELexer lexer = new VExprELexer(new ANTLRInputStream(expr));
        VExprEParser parser = new VExprEParser(new CommonTokenStream(lexer));
        parser.setInputContext(context);
        return parser.expr().value.asDouble();
    }

    protected void checkExpr(String expr, Double val) {
        checkExpr(expr,val,new InputContextImpl());
    }

    protected void checkExpr(String expr, Double val, InputContext context) {
        assertEquals(val,evaluateExpr(expr,context),0.001);
    }
}

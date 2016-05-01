package org.kravemir.vexpre;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.kravemir.vexpre.api.InputContext;
import org.kravemir.vexpre.parser.VExprELexer;
import org.kravemir.vexpre.parser.VExprEParser;

/**
 * Created by miroslav on 5/1/16.
 */
public abstract class AbstractParserTest {
    protected double evaluateExpr(String expr, InputContext context) {
        VExprELexer lexer = new VExprELexer(new ANTLRInputStream(expr));
        VExprEParser parser = new VExprEParser(new CommonTokenStream(lexer));
        parser.setInputContext(context);
        return parser.expr().value.asDouble();
    }

    protected double evaluateExprWithoutContext(String expr) {
        VExprELexer lexer = new VExprELexer(new ANTLRInputStream(expr));
        VExprEParser parser = new VExprEParser(new CommonTokenStream(lexer));
        parser.setInputContext(new InputContextImpl());
        return parser.expr().value.asDouble();
    }
}

grammar VExprE;

@header {
import java.util.Map;
import org.kravemir.vexpre.api.*;
import org.kravemir.vexpre.values.*;
} // @header

@members {
private InputContext inputContext;

public void setInputContext(InputContext inputContext) {
    this.inputContext = inputContext;
}
} // @members

expr returns [Value value]
    :	exp=add {$value = $exp.value;}
    ;

exprList returns [List<Value> values]
    :   exp=expr { $values = new ArrayList(); $values.add($exp.value); }
        ( ',' exp2 = expr { $values.add($exp2.value); } )*
    ;

add returns [Value value]
    :   m1=mult { $value = $m1.value; }
        (   '+' m2=mult { $value = $value.add($m2.value); }
        |   '-' m2=mult { $value = $value.sub($m2.value); }
        )*
    ;

mult returns [Value value]
    :   p1=power { $value = $p1.value; }
        (   '*' p2=power { $value = $value.mul($p2.value); }
        |   '/' p2=power { $value = $value.div($p2.value); }
        )*
    ;

power returns [Value value]
    :   n=atom { $value = $n.value; }
        (   '(' e=exprList ')' { $value = $value.call($e.values.stream().toArray(Value[]::new)); }
        |   '.' i=IDENTIFIER { $value = $value.getChild($i.text); }
        )*
    ;

atom returns [Value value]
    :   n=FNUM { $value = new DoubleValue($n.text); }
    |   i=IDENTIFIER { String name = $i.text; $value = inputContext.getOrThrow(name); }
    |   '(' exp=add ')' { $value = $exp.value; }
    ;


FNUM:       [0-9]+ ('.' [0-9]+)?;
IDENTIFIER: [_a-zA-Z][_a-zA-Z0-9]*;

WS
    :   (' ' | '\t' | '\r'| '\n') -> channel(HIDDEN)
    ;
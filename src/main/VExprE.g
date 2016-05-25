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

add returns [Value value]
    :   m1=mult { $value = $m1.value; }
        (   '+' m2=mult { $value = $value.add($m2.value); }
        |   '-' m2=mult { $value = $value.sub($m2.value); }
        )*
    ;

mult returns [Value value]
    :   a1=atom { $value = $a1.value; }
        (   '*' a2=atom { $value = $value.mul($a2.value); }
        |   '/' a2=atom { $value = $value.div($a2.value); }
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
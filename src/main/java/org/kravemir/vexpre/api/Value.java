package org.kravemir.vexpre.api;

/**
 * Created by miroslav on 5/1/16.
 */
public interface Value {

    Value add(Value right);
    Value sub(Value right);
    Value mul(Value right);
    Value div(Value right);


    Value addAsLeft(Value right);
    Value subAsLeft(Value right);
    Value mulAsLeft(Value right);
    Value divAsLeft(Value right);

    Value addAsRight(Value left);
    Value subAsRight(Value left);
    Value mulAsRight(Value left);
    Value divAsRight(Value left);

    double asDouble();
    String asString();

    Value getChild(String name);
    Value call(Value... args);
}

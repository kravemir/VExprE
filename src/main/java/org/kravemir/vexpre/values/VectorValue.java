package org.kravemir.vexpre.values;


import org.apache.commons.lang3.NotImplementedException;
import org.kravemir.vexpre.AbstractValue;
import org.kravemir.vexpre.api.Value;

import java.util.Arrays;

/**
 * Created by miroslav on 5/1/16.
 */
public class VectorValue extends AbstractValue {
    /* TODO-jaro: implement */

    private final Double[] values;

    public VectorValue(Double... values) {
        this.values = values;
    }

    public VectorValue(Value... values) {
        this.values = Arrays.stream(values).map(value -> value.asDouble()).toArray(Double[]::new);
    }

    @Override
    public Value addAsLeft(Value right) {
        if(right instanceof DoubleValue) {
            double rightVal = right.asDouble();
            return new VectorValue(
                    Arrays.stream(values).map(value -> value * rightVal).toArray(Double[]::new)
            );
        }
        return super.addAsLeft(right);
    }

    @Override
    public Value getChild(String name) {
        switch (name) {
            case "length":
                throw new NotImplementedException("TODO");
            case "dimension":
                return new IntValue(values.length);
            default:
                return super.getChild(name);
        }
    }

    public static AbstractValue makeCreateFunc() {
        return new AbstractValue() {
            @Override
            public Value call(Value... args) {
                return new VectorValue(args);
            }
        };
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof VectorValue))
            return false;
        return Arrays.equals(this.values,((VectorValue) obj).values);
    }

    @Override
    public String toString() {
        return "Vector" + Arrays.toString(values);
    }
}

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

    private final int dimension;
    private final Double[] values;

    public VectorValue(int dimension, Double... values) {
        assert (values.length == dimension);
        this.dimension = dimension;
        this.values = values;
    }

    public VectorValue(int dimension, Value... values) {
        assert (values.length == dimension);
        this.dimension = dimension;
        this.values = Arrays.stream(values).map(value -> value.asDouble()).toArray(Double[]::new);
    }

    @Override
    public Value addAsLeft(Value right) {
        if(right instanceof DoubleValue) {
            double rightVal = right.asDouble();
            return new VectorValue(
                    dimension, Arrays.stream(values).map(value -> value * rightVal).toArray(Double[]::new)
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
                throw new NotImplementedException("TODO");
            default:
                return super.getChild(name);
        }
    }
}

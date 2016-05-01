package org.kravemir.vexpre.values;

import org.kravemir.vexpre.AbstractValue;
import org.kravemir.vexpre.api.Value;

/**
 * Created by miroslav on 5/1/16.
 */
public class DoubleValue extends AbstractValue {

    private final double value;

    public DoubleValue(double value) {
        this.value = value;
    }

    public DoubleValue(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    public Value addAsLeft(Value right) {
        if(right instanceof DoubleValue)
            return new DoubleValue(value + ((DoubleValue)right).value);
        return super.add(right);
    }

    @Override
    public Value subAsLeft(Value right) {
        if(right instanceof DoubleValue)
            return new DoubleValue(value - ((DoubleValue)right).value);
        return super.add(right);
    }

    @Override
    public Value mulAsLeft(Value right) {
        if(right instanceof DoubleValue)
            return new DoubleValue(value * ((DoubleValue)right).value);
        return super.add(right);
    }

    @Override
    public Value divAsLeft(Value right) {
        if(right instanceof DoubleValue)
            return new DoubleValue(value / ((DoubleValue)right).value);
        return super.add(right);
    }

    @Override
    public double asDouble() {
        return value;
    }

    @Override
    public String asString() {
        return String.valueOf(value);
    }
}

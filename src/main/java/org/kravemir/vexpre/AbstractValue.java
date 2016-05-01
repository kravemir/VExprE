package org.kravemir.vexpre;

import org.kravemir.vexpre.api.Value;

/**
 * Created by miroslav on 5/1/16.
 */
public abstract class AbstractValue implements Value {
    @Override
    public Value add(Value right) {
        Value val = addAsLeft(right);
        if (val != null) return val;
        val = (right).addAsRight(this);
        if (val != null) return val;
        throw new UnsupportedOperationException(String.format("Addition of %s with %s isn't supported", this.toString(), right.toString()));
    }

    @Override
    public Value sub(Value right) {
        Value val = subAsLeft(right);
        if (val != null) return val;
        val = (right).subAsRight(this);
        if (val != null) return val;
        throw new UnsupportedOperationException(String.format("Substraction of %s with %s isn't supported", this.toString(), right.toString()));
    }

    @Override
    public Value mul(Value right) {
        Value val = mulAsLeft(right);
        if (val != null) return val;
        val = (right).mulAsRight(this);
        if (val != null) return val;
        throw new UnsupportedOperationException(String.format("Multiplication of %s with %s isn't supported", this.toString(), right.toString()));
    }

    @Override
    public Value div(Value right) {
        Value val = divAsLeft(right);
        if (val != null) return val;
        val = (right).divAsRight(this);
        if (val != null) return val;
        throw new UnsupportedOperationException(String.format("Division of %s with %s isn't supported", this.toString(), right.toString()));
    }

    @Override
    public Value addAsLeft(Value right) { return null; }
    @Override
    public Value subAsLeft(Value right) { return null; }
    @Override
    public Value mulAsLeft(Value right) { return null; }
    @Override
    public Value divAsLeft(Value right) { return null; }

    @Override
    public Value addAsRight(Value left) { return addAsLeft(left); }
    @Override
    public Value subAsRight(Value left) { return subAsLeft(left); }
    @Override
    public Value mulAsRight(Value left) { return mulAsLeft(left); }
    @Override
    public Value divAsRight(Value left) { return divAsLeft(left); }

    @Override
    public double asDouble() {
        throw new UnsupportedOperationException(String.format("Conversion of %s to String isn't supported", this.toString()));
    }

    @Override
    public String asString() {
        throw new UnsupportedOperationException(String.format("Conversion of %s to String isn't supported", this.toString()));
    }

    @Override
    public Value getChild(String name) {
        throw new IllegalArgumentException(String.format("Object %s doesn't contain child %s", this.toString(), name));
    }

    @Override
    public Value call(Value... args) {
        throw new UnsupportedOperationException();
    }
}

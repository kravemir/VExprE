package org.kravemir.vexpre.values;

import org.kravemir.vexpre.AbstractValue;

public class IntValue extends AbstractValue {
    private final int value;

    public IntValue(final int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof AbstractValue))
            return false;
        return ((IntValue)obj).value == this.value;
    }
}

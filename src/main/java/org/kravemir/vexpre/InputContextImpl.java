package org.kravemir.vexpre;

import org.kravemir.vexpre.api.InputContext;
import org.kravemir.vexpre.api.VariableNotFoundException;
import org.kravemir.vexpre.values.DoubleValue;

import java.util.HashMap;

/**
 * Created by miroslav on 5/1/16.
 */
public class InputContextImpl implements InputContext {


    private final HashMap<String, AbstractValue> hashMap = new HashMap<String, AbstractValue>();

    @Override
    public AbstractValue get(String name) {
        return hashMap.get(name);
    }

    @Override
    public AbstractValue getOrDefault(String name, AbstractValue _default) {
        return hashMap.getOrDefault(name,_default);
    }

    @Override
    public AbstractValue getOrThrow(String name) throws VariableNotFoundException {
        if(name != null && !name.equals("")) {
            AbstractValue value = hashMap.getOrDefault(name,null);
            if(value != null)
                return value;
        }
        throw new VariableNotFoundException();
    }

    public void put(String name, AbstractValue value) {
        hashMap.put(name,value);
    }

    public void put(String name, double value) {
        put(name, new DoubleValue(value));
    }


}

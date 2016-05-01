package org.kravemir.vexpre;

import org.kravemir.vexpre.api.InputContext;

import java.util.HashMap;

/**
 * Created by miroslav on 5/1/16.
 */
public class InputContextImpl implements InputContext {


    private final HashMap<String, Double> hashMap = new HashMap<String, Double>();

    @Override
    public Double get(String name) {
        return hashMap.get(name);
    }

    @Override
    public Double getOrDefault(String name, Double _default) {
        return hashMap.getOrDefault(name,_default);
    }

    public void put(String name, Double value) {
        hashMap.put(name,value);
    }
}

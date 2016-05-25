package org.kravemir.vexpre.api;

import org.kravemir.vexpre.AbstractValue;

/**
 * Created by miroslav on 5/1/16.
 */
public interface InputContext {
    AbstractValue get(String name);
    AbstractValue getOrDefault(String name, AbstractValue _default);
    AbstractValue getOrThrow(String name) throws VariableNotFoundException;
}

package org.kravemir.vexpre.api;

import java.util.Map;

/**
 * Created by miroslav on 5/1/16.
 */
public interface InputContext {
    Double get(String name);
    Double getOrDefault(String name, Double _default);
}

package com.jeevic.servlet.demo.engine.support;

/**
 * @className: com.jeevic.servlet.demo.engine.support -> LazyMap
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/25 20:39
 * @version: 1.0
 */


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Lazy proxy which holds a Map.
 */
public class LazyMap<V>  {
    private Map<String, V> map = null;
    private final boolean concurrent;

    public LazyMap(boolean concurrent) {
        this.concurrent = concurrent;
    }

    protected V get(String name) {
        if (this.map == null) {
            return null;
        }
        return this.map.get(name);
    }

    protected Set<String> keySet() {
        if (this.map == null) {
            return Set.of();
        }
        return this.map.keySet();
    }

    protected Enumeration<String> keyEnumeration() {
        if (this.map == null) {
            return Collections.emptyEnumeration();
        }
        return Collections.enumeration(this.map.keySet());
    }

    protected boolean containsKey(String name) {
        if (this.map == null) {
            return false;
        }
        return this.map.containsKey(name);
    }

    protected V put(String name, V value) {
        if (this.map == null) {
            this.map = concurrent ? new ConcurrentHashMap<>() : new HashMap<>();
        }
        return this.map.put(name, value);
    }

    protected V remove(String name) {
        if (this.map != null) {
            return this.map.remove(name);
        }
        return null;
    }

    protected Map<String, V> map() {
        if (this.map == null) {
            return Map.of();
        }
        return Collections.unmodifiableMap(this.map);
    }

}

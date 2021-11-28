package com.resare.nryaml;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * A Map that wraps another Map
 */
class WrappingMap<K, V> implements Map<K, V> {

    private final Map<K, V> inner;

    public WrappingMap(Map<K, V> input) {
        this.inner = input;
    }

    @Override
    public int size() {
        return inner.size();
    }

    @Override
    public boolean isEmpty() {
        return inner.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return inner.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return inner.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return inner.get(key);
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        return inner.keySet();
    }

    @Override
    public Collection<V> values() {
        return inner.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return inner.entrySet();
    }

}
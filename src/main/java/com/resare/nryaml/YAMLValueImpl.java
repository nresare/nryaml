package com.resare.nryaml;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

class YAMLValueImpl implements YAMLValue {
    private record Entry(String key, YAMLValue value) {}
    Object inner;

    public YAMLValueImpl(Object input) {
        if (input instanceof Map<?, ?> m) {
            inner = buildMapping(m);
        } else if (input instanceof List<?> l) {
            inner = new YAMLSequence(l.stream()
                    .map(YAMLValueImpl::new)
                    .collect(toList())
            );
        } else if (input instanceof Integer || input instanceof String || input instanceof Boolean) {
            inner = input;
        } else {
            throw new IllegalArgumentException("Don't know how to handle value of type %s".formatted(input.getClass()));
        }
    }

    private YAMLMapping buildMapping(Map<?, ?> map) {
        return new YAMLMapping(map.keySet().stream()
                .map(key -> {
                    if (key instanceof String s) return s;
                    var m = "Key '%s' was not a String but a %s".formatted(key, key.getClass());
                    throw new IllegalArgumentException(m);
                })
                .sorted()
                .map(key -> new Entry(key, new YAMLValueImpl(map.get(key))))
                .collect(toMap(Entry::key, Entry::value))
        );
    }

    @Override
    public YAMLMapping asMapping() {
        return (YAMLMapping) inner;
    }

    @Override
    public YAMLSequence asSequence() {
        return (YAMLSequence) inner;
    }

    @Override
    public String asString() {
        return (String) inner;
    }

    @Override
    public boolean asBoolean() {
        return (Boolean) inner;
    }

    @Override
    public int asInteger() {
        return (Integer) inner;
    }

    @Override
    public Object toBareObject() {
        if (inner instanceof YAMLMapping mapping) {
            return mapping.toBareObject();
        }
        if (inner instanceof YAMLSequence sequence) {
            return sequence.toBareObject();
        }
        return inner;
    }
}

package com.resare.nryaml;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class YAMLMapping extends WrappingMap<String, YAMLValue> implements YAMLValue {
    public YAMLMapping(Map<String, YAMLValue> input) {
        super(input);
    }

    @Override
    public YAMLMapping asMapping() {
        return this;
    }

    @Override
    public YAMLSequence asSequence() {
        throw new ClassCastException("Refusing to treat YAMLMapping as sequence");
    }

    @Override
    public String asString() {
        throw new ClassCastException("Refusing to treat YAMLMapping as String");
    }

    @Override
    public boolean asBoolean() {
        throw new ClassCastException("Refusing to treat YAMLMapping as boolean");
    }

    @Override
    public int asInteger() {
        throw new ClassCastException("Refusing to treat YAMLMapping as int");
    }

    @Override
    public Object toBareObject() {
        return this.entrySet().stream()
                .collect(toMap(Entry::getKey, entry -> entry.getValue().toBareObject()));
    }
}

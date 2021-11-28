package com.resare.nryaml;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class YAMLSequence extends WrappingList<YAMLValue> implements YAMLValue {
    public YAMLSequence(List<YAMLValue> inner) {
        super(inner);
    }

    @Override
    public YAMLMapping asMapping() {
        throw new ClassCastException("Refusing to treat YAMLSequence as mapping");
    }

    @Override
    public YAMLSequence asSequence() {
        return this;
    }

    @Override
    public String asString() {
        throw new ClassCastException("Refusing to treat YAMLSequence as String");
    }

    @Override
    public boolean asBoolean() {
        throw new ClassCastException("Refusing to treat YAMLSequence as boolean");
    }

    @Override
    public int asInteger() {
        throw new ClassCastException("Refusing to treat YAMLSequence as int");
    }

    @Override
    public Object toBareObject() {
        return this.stream().map(YAMLValue::toBareObject).collect(toList());
    }
}

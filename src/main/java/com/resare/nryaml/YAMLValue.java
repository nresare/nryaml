package com.resare.nryaml;

public interface YAMLValue {
    static YAMLValue fromBare(Object bare) {
        return new YAMLValueImpl(bare);
    }

    YAMLMapping asMapping();

    YAMLSequence asSequence();

    String asString();

    boolean asBoolean();

    int asInteger();

    Object toBareObject();
}

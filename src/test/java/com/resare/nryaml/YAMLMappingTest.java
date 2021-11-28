package com.resare.nryaml;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class YAMLMappingTest {
    @Test
    void testWrongCast() {
        assertThrows(
              ClassCastException.class,
              () -> YAMLValue.fromBare(Map.of()).asMapping().asInteger()
        );
        assertThrows(
                ClassCastException.class,
                () -> YAMLValue.fromBare(Map.of()).asMapping().asString()
        );
        assertThrows(
                ClassCastException.class,
                () -> YAMLValue.fromBare(Map.of()).asMapping().asBoolean()
        );
        assertThrows(
                ClassCastException.class,
                () -> YAMLValue.fromBare(Map.of()).asMapping().asSequence()
        );
    }

    @Test
    void testAsMapping() {
        var mapping = YAMLValue.fromBare(Map.of()).asMapping();
        assertEquals(mapping, mapping.asMapping());
    }

}
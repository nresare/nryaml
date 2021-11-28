package com.resare.nryaml;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YAMLValueTest {
    @Test
    void testSimpleTraversal() {
        var map = Map.of(
                "left", List.of(1, 2, 3),
                "middle", "foobar",
                "right", true
        );
        var value = YAMLValue.fromBare(map);

        var left = value.asMapping().get("left");
        var aNumber = left.asSequence().get(1);
        assertEquals(2, aNumber.asInteger());

        var middle = value.asMapping().get("middle");
        assertEquals("foobar", middle.asString());

        var right = value.asMapping().get("right");
        assertTrue(right.asBoolean());

        assertEquals(map, value.toBareObject());
    }

    @Test
    void testNonStringMapKey() {
        assertThrows(IllegalArgumentException.class, () -> YAMLValue.fromBare(Map.of(true, 42)));
    }

    @Test
    void checkUnhandledClass() {
        assertThrows(IllegalArgumentException.class, () -> YAMLValue.fromBare(String.class));
    }
}

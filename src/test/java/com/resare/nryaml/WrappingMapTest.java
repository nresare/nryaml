package com.resare.nryaml;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WrappingMapTest {
    @Test
    void testSimple() {
        var map = new WrappingMap<>(Map.of("a", "b"));

        assertEquals(1, map.size());
        assertFalse(map.isEmpty());
        assertFalse(map.containsKey("z"));
        assertEquals("b", map.get("a"));
        assertTrue(map.containsValue("b"));
        assertTrue(map.containsKey("a"));
        assertEquals(Set.of("a"), map.keySet());
        var values = map.values();
        assertEquals(1, values.size());
        assertEquals("b", values.iterator().next());
    }

    @Test
    void testUnsupported() {
        var map = new WrappingMap<>(Map.of("a", "b"));
        assertThrows(UnsupportedOperationException.class, () -> map.put("foo", "bar"));
        assertThrows(UnsupportedOperationException.class, () -> map.remove("a"));
        assertThrows(UnsupportedOperationException.class, () -> map.putAll(Map.of("c", "d")));
        assertThrows(UnsupportedOperationException.class, () -> map.clear());
    }
}

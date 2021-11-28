package com.resare.nryaml;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WrappingListTest {
    @Test
    void testSimple() {
        var list = new WrappingList<>(List.of("a", "b", "c"));
        assertEquals("a", list.get(0));
        assertEquals(3, list.size());
        //noinspection ConstantConditions
        assertFalse(list.isEmpty());
        assertTrue(new WrappingList<>(List.of()).isEmpty());
        assertFalse(list.contains("z"));

        var objects = list.toArray();
        assertEquals(3, objects.length);
        assertEquals("a", objects[0]);
    }

    @Test
    void testUnsupported() {
        var map = new WrappingList<>(List.of("a", "b"));
        assertThrows(UnsupportedOperationException.class, () -> map.add("foo"));
    }
}
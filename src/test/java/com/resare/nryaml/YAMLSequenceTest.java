package com.resare.nryaml;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class YAMLSequenceTest {
    @Test
    void testWrongCast() {
        assertThrows(
                ClassCastException.class,
                () -> YAMLValue.fromBare(List.of()).asSequence().asInteger()
        );
        assertThrows(
                ClassCastException.class,
                () -> YAMLValue.fromBare(List.of()).asSequence().asBoolean()
        );
        assertThrows(
                ClassCastException.class,
                () -> YAMLValue.fromBare(List.of()).asSequence().asString()
        );
        assertThrows(
                ClassCastException.class,
                () -> YAMLValue.fromBare(List.of()).asSequence().asMapping()
        );
    }

    @Test
    void testAsSequence() {
        var sequence = YAMLValue.fromBare(List.of()).asSequence();
        assertEquals(sequence, sequence.asSequence());
    }
}
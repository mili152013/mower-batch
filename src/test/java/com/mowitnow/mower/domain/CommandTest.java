package com.mowitnow.mower.domain;

import com.mowitnow.mower.application.domain.model.Command;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class CommandTest {

    @Test
     void testFromChar() {
        assertEquals(Command.LEFT, Command.fromChar('G'));
        assertEquals(Command.RIGHT, Command.fromChar('D'));
        assertEquals(Command.FORWARD, Command.fromChar('A'));
    }

    @Test
     void testInvalidChar() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Command.fromChar('X');
        });
        assertEquals("Invalid command: X", exception.getMessage());
    }
}

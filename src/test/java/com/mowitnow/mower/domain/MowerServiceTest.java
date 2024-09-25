package com.mowitnow.mower.domain;

import com.mowitnow.mower.application.domain.model.Command;
import com.mowitnow.mower.application.domain.model.Mower;
import com.mowitnow.mower.application.domain.model.Orientation;
import com.mowitnow.mower.application.domain.services.MowerService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class MowerServiceTest {

    private final MowerService mowerService = new MowerService();

    @Test
     void testApplySingleCommandForward() {
        Mower mower = new Mower(1, 2, Orientation.N, "A");
        Mower result = mowerService.applyCommand(mower, Command.FORWARD);
        assertEquals(1, result.x());
        assertEquals(3, result.y());
    }

    @Test
     void testApplyMultipleCommands() {
        Mower mower = new Mower(1, 2, Orientation.N, "GAGAGAGAA");
        Mower result = mowerService.applyCommands(mower, "GAGAGAGAA");
        assertEquals(1, result.x());
        assertEquals(3, result.y());
        assertEquals(Orientation.N, result.orientation());
    }
}

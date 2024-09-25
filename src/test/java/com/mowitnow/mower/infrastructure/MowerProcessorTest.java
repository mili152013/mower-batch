package com.mowitnow.mower.infrastructure;

import com.mowitnow.mower.application.domain.model.Mower;
import com.mowitnow.mower.application.domain.model.Orientation;
import com.mowitnow.mower.application.domain.services.MowerService;
import com.mowitnow.mower.application.infrastructure.processor.MowerProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class MowerProcessorTest {

    @Test
     void testProcessCommands() {
        MowerProcessor processor = new MowerProcessor(new MowerService());
        Mower mower = new Mower(1, 2, Orientation.N, "GAGAGAGAA");
        Mower result = processor.process(mower);
        assert result != null;
        assertEquals(1, result.x());
        assertEquals(3, result.y());
        assertEquals(Orientation.N, result.orientation());
    }
}

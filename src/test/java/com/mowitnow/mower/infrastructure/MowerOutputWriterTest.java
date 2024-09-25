package com.mowitnow.mower.infrastructure;

import com.mowitnow.mower.application.domain.model.Mower;
import com.mowitnow.mower.application.domain.model.Orientation;
import com.mowitnow.mower.application.infrastructure.writer.MowerOutputWriter;
import org.junit.jupiter.api.Test;
import org.springframework.batch.item.Chunk;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

 class MowerOutputWriterTest {

    @Test
     void testWriteOutput() throws Exception {
        MowerOutputWriter writer = new MowerOutputWriter();
        Mower mower = new Mower(1, 3, Orientation.N, "");
        Chunk<Mower> chunk = new Chunk<>(List.of(mower));
        writer.write(chunk);
        assertDoesNotThrow(() -> writer.write(chunk));
    }
}

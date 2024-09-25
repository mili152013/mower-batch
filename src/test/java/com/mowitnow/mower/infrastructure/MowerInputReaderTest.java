package com.mowitnow.mower.infrastructure;

import com.mowitnow.mower.application.domain.model.Mower;
import com.mowitnow.mower.application.domain.model.Orientation;
import com.mowitnow.mower.application.infrastructure.reader.MowerInputReader;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MowerInputReaderTest {

  @Autowired
  private ResourceLoader resourceLoader;

  @Test
  void testReadMowerData() {
    String filePath = "input.txt";
    MowerInputReader reader = new MowerInputReader(filePath);

    Mower mower = reader.read();

    assertNotNull(mower);
    assertEquals(1, mower.x());
    assertEquals(2, mower.y());
    assertEquals(Orientation.N, mower.orientation());
  }
}

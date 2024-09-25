package com.mowitnow.mower.domain;

import com.mowitnow.mower.application.domain.model.Orientation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class OrientationTest {

  @Test
   void testTurnLeft() {
    assertEquals(Orientation.W, Orientation.N.turnLeft());
    assertEquals(Orientation.S, Orientation.W.turnLeft());
  }

  @Test
   void testTurnRight() {
    assertEquals(Orientation.E, Orientation.N.turnRight());
    assertEquals(Orientation.S, Orientation.E.turnRight());
  }
}

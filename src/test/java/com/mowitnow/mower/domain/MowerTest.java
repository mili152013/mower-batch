package com.mowitnow.mower.domain;

import com.mowitnow.mower.application.domain.model.Mower;
import com.mowitnow.mower.application.domain.model.Orientation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class MowerTest {

  @Test
   void testMoveForwardNorth() {
    Mower mower = new Mower(1, 2, Orientation.N, "A");
    Mower movedMower = mower.moveForward();
    assertEquals(1, movedMower.x());
    assertEquals(3, movedMower.y());
  }

  @Test
   void testTurnLeft() {
    Mower mower = new Mower(1, 2, Orientation.N, "G");
    Mower turnedMower = mower.turnLeft();
    assertEquals(Orientation.W, turnedMower.orientation());
  }

  @Test
   void testTurnRight() {
    Mower mower = new Mower(1, 2, Orientation.N, "D");
    Mower turnedMower = mower.turnRight();
    assertEquals(Orientation.E, turnedMower.orientation());
  }
}

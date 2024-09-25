package com.mowitnow.mower.application.domain.model;

public record Mower(int x, int y, Orientation orientation, String instructions) {

  public Mower moveForward() {
    return switch (orientation) {
      case N -> new Mower(x, y + 1, orientation, instructions);
      case E -> new Mower(x + 1, y, orientation, instructions);
      case S -> new Mower(x, y - 1, orientation, instructions);
      case W -> new Mower(x - 1, y, orientation, instructions);
    };
  }

  public Mower turnLeft() {
    return new Mower(x, y, orientation.turnLeft(), instructions);
  }

  public Mower turnRight() {
    return new Mower(x, y, orientation.turnRight(), instructions);
  }
}

package com.mowitnow.mower.application.domain.model;

public enum Command {
    LEFT, RIGHT, FORWARD;

    public static Command fromChar(char commandChar) {
        return switch (commandChar) {
            case 'G' -> LEFT;
            case 'D' -> RIGHT;
            case 'A' -> FORWARD;
            default -> throw new IllegalArgumentException("Invalid command: " + commandChar);
        };
    }
}

package com.mowitnow.mower.application.domain.services;

import com.mowitnow.mower.application.domain.model.Command;
import com.mowitnow.mower.application.domain.model.Mower;

public class MowerService {

    public Mower applyCommand(Mower mower, Command command) {
        return switch (command) {
            case LEFT -> mower.turnLeft();
            case RIGHT -> mower.turnRight();
            case FORWARD -> mower.moveForward();
        };
    }

    public Mower applyCommands(Mower mower, String commands) {
        for (char commandChar : commands.toCharArray()) {
            Command command = Command.fromChar(commandChar);
            mower = applyCommand(mower, command);
        }
        return mower;
    }
}

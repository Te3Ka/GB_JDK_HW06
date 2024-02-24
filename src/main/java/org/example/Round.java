package org.example;

import java.util.Random;

public class Round {
    static final boolean MONEY = true;
    static final boolean EMPTY = false;
    private static boolean[] doors = new boolean[3];

    static Random random = new Random();

    public static void newRound() {
        createRound();
        while (!correctRound(doors)) {
            createRound();
        }
    }

    public static void createRound() {
        for (int i = 0; i < doors.length; i++) {
            doors[i] = EMPTY;
        }

        for (int i = 0; i < doors.length; i++) {
            if (random.nextBoolean()) {
                doors[i] = MONEY;
                break;
            }
        }
    }

    public static boolean correctRound(boolean[] round) {
        for (int i = 0; i < round.length; i++) {
            if (round[i] == MONEY) {
                return true;
            }
        }
        return false;
    }

    public static boolean getDoorsI(int i) {
        return doors[i];
    }

    public static int openFalseDoor(int playerChoice) {
        if (playerChoice == 0) {
            if (getDoorsI(1))
                return 2;
            else
                return 1;
        } else if (playerChoice == 1) {
            if (getDoorsI(0))
                return 2;
            else
                return 0;
        } else {
            if (getDoorsI(0))
                return 1;
            else
                return 0;
        }
    }

    public static boolean verificationChoice(int choice) {
        return getDoorsI(choice);
    }

    public static int correctDoor() {
        for (int i = 0; i < 3; i++) {
            if (doors[i])
                return i;
        }
        return -1;
    }
}

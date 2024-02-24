package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;


public class PlayerSwitchChoice {
    private final String NAME_SWITCHER = "Adam Savage";
    static Random random = new Random();
    private int choice;
    private int wins;

    public static int switchChoice(int choice, int openDoor) {
        if (choice == 0) {
            if (openDoor == 1)
                return 2;
            else
                return 1;
        } else if (choice == 1) {
            if (openDoor == 0)
                return 2;
            else
                return 0;
        } else {
            if (openDoor == 0)
                return 1;
            else
                return 0;
        }
    }

    public String getName() {
        return NAME_SWITCHER;
    }

    public void setWins(boolean wins) {
        if (wins) {
            this.wins = getWins() + 1;
        }
        else
            this.wins = getWins();
    }

    public int getChoice() {
        return choice;
    }

    public int getWins() {
        return wins;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
}

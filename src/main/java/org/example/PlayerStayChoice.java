package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;


public class PlayerStayChoice {
    private final String NAME_STAYER = "James Hyneman";
    static Random random = new Random();
    private int choice;
    private int wins;

    public static int stayChoice(int choice) {
        return choice;
    }

    public String getName() {
        return NAME_STAYER;
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

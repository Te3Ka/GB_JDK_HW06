package org.example;

import java.util.Random;

//TIP Парадокс Монти Холла.

/**
 * Необходимо:
 * Создать свой Java Maven или Gradle проект;
 * Подключите зависимость lombok и возможно какую то математическую библиотеку (напр. commons-math3)
 * Самостоятельно реализовать прикладную задачу;
 * Сохранить результат игр в одну из коллекций или в какой то библиотечный класс
 * Вывести на экран статистику по победам и поражениям
 */
public class Main {
    static final int TOTAL_GAMES = 1_000;
    public static Random random = new Random();

    public static void main(String[] args) {
        Round round = new Round();
        int choicePlayers;
        int falseDoor;
        PlayerStayChoice playerStayChoice = new PlayerStayChoice();
        PlayerSwitchChoice playerSwitchChoice = new PlayerSwitchChoice();
        Logger logger = new Logger();

        double statistic = 0.0;

        for (int i = 0; i < TOTAL_GAMES; i++) {
            Round.newRound();
            logger.logFile("\n*** Текущий раунд: " + i + " ***");
            choicePlayers = random.nextInt(3);
            playerStayChoice.setChoice(choicePlayers);
            logger.logFile(playerStayChoice.getName() + " делает выбор: " + choicePlayers);
            playerSwitchChoice.setChoice(choicePlayers);
            logger.logFile(playerSwitchChoice.getName() + " делает выбор: " + choicePlayers);

            falseDoor = round.openFalseDoor(choicePlayers);
            logger.logFile("Ведущий открывает пустую дверь № " + falseDoor);

            playerStayChoice.setChoice(playerStayChoice.stayChoice(choicePlayers));
            logger.logFile(playerStayChoice.getName() + " остаётся при своём выборе: "
                    + playerStayChoice.getChoice());

            playerSwitchChoice.setChoice(playerSwitchChoice.switchChoice(choicePlayers, falseDoor));
            logger.logFile(playerSwitchChoice.getName() + " меняет свой выбор на № "
                    + playerSwitchChoice.getChoice());

            playerStayChoice.setWins(round.verificationChoice(playerStayChoice.getChoice()));
            playerSwitchChoice.setWins(round.verificationChoice(playerSwitchChoice.getChoice()));
            logger.logFile("Выиграшная дверь: " + round.correctDoor());
        }
        logger.logFile("\n*** КОНЕЦ ИГРЫ ***\n");
        statistic = (double) playerStayChoice.getWins() / TOTAL_GAMES;
        System.out.println("Процент побед игрока " + playerStayChoice.getName() + ": " + statistic);
        logger.logFile("Процент побед игрока " + playerStayChoice.getName() + ": " + statistic);
        statistic = (double) playerSwitchChoice.getWins() / TOTAL_GAMES;
        System.out.println("Процент побед игрока " + playerSwitchChoice.getName() + ": " + statistic);
        logger.logFile("Процент побед игрока " + playerSwitchChoice.getName() + ": " + statistic);
    }
}
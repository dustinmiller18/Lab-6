package com.company;

import Interfaces.Player;
import Models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void run() {
        int userChoice = -1;

        do {
            switch (userChoice) {
                case 1:
                    humanVHuman();
                    break;
                case 2:
                    humanVComp();
                    break;
                case 3:
                    compVComp();
                    break;
            }

        } while (userChoice > 0);
    }

    public void humanVHuman() {

    }

    public void humanVComp() {

    }

    public void compVComp() {

    }

    public int mainMenu() {
        String mainMenu = new StringBuilder("Main Menu\n\n").
                append("1) Human vs. Human\n").
                append("2) Human vs. Comp\n").
                append("3) Comp vs. Comp\n").
                append("0) Exit\n\n").append("Enter the number of your selection: ").toString();
        int minOption = 0;
        int maxOption = 3;
        return promptForInt(mainMenu, minOption, maxOption);
    }

    private int promptForInt(String prompt, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("The min cannot be greater than the max. min: " + min + ", max: " + max);
        }

        int userNum = -1;
        String input = null;
        boolean isInvalid = true;

        do {
            System.out.print(prompt);
            try {
                input = bufferedReader.readLine();
                userNum = Integer.parseInt(input);
                isInvalid = userNum < min || userNum > max;
            } catch (IOException ioe) {
                System.out.println("Whoa! Something technical went wrong. Let's try that again.");
            } catch (NumberFormatException nfe) {

            }

            if (isInvalid) {
                System.out.println("You entered an invalid value. Please, try again.");
            }
        } while (isInvalid);

        return userNum;
    }
}

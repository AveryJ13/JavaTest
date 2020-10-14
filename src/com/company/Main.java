package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String yorn = "y";
        do {

            System.out.println("Hello, Welcome to the game!");

            System.out.println("What is the name of the first player?");
            Scanner scanner = new Scanner(System.in);
            String nameOne = scanner.next().toLowerCase();

            System.out.println("What is the name of the second player?");
            String nameTwo = scanner.next().toLowerCase();

            while (nameTwo.equals(nameOne)) {
                System.out.println("Both players cannot have the same name, please choose a different name");
                nameTwo = scanner.next().toLowerCase();

            }

            Integer startingChips = 0;
            System.out.println("How many chips does the initial pile contain?");
            startingChips = scanner.nextInt();

            while (startingChips < 3 || startingChips % 2 == 0) {
                if (startingChips < 3) {
                    System.out.println("You have to start with at least 3 chips. Choose another number: ");
                } else if (startingChips % 2 == 0) {
                    System.out.println("You have to start with an odd number of chips. Choose another number: ");
                }

                startingChips = scanner.nextInt();
            }

            Integer playerOneChips = 0;
            Integer playerTwoChips = 0;
            String currentPlayer = nameOne;
            Integer numberCheck = (startingChips - 1) / 2;
            Integer moveNumber = 0;


            while (startingChips > 0) {
                System.out.println(nameOne + " has " + playerOneChips + ".");
                System.out.println(nameTwo + " has " + playerTwoChips + ".");
                if (currentPlayer == nameOne) {
                    System.out.println("It is your turn, " + nameOne);
                } else if (currentPlayer == nameTwo) {
                    System.out.println("It is your turn, " + nameTwo);
                }
                System.out.println("There are " + startingChips + " chip(s) remaining.");
                System.out.println("You may take any number of chips from 1 to " + numberCheck + ". How many will you take, " + currentPlayer + "?");
                moveNumber = scanner.nextInt();
                while (moveNumber < 1) {
                    System.out.println("Illegal move: you must take at least one chip. ");
                    System.out.println("How many will you take " + currentPlayer + ".");
                    moveNumber = scanner.nextInt();
                }
                while (moveNumber > numberCheck) {
                    System.out.println("Illegal move: you may not take more than " + numberCheck + " chips.");
                    System.out.println("How many will you take, " + currentPlayer + "?");
                    moveNumber = scanner.nextInt();
                }
                if (currentPlayer.equals(nameOne)) {
                    startingChips -= moveNumber;
                    playerOneChips += moveNumber;
                } else if (currentPlayer.equals(nameTwo)) {
                    startingChips -= moveNumber;
                    playerTwoChips += moveNumber;
                }
                numberCheck = (startingChips - 1) / 2;
                if (numberCheck == 0) {
                    numberCheck = 1;
                }
                if (currentPlayer == nameOne) {
                    currentPlayer = nameTwo;
                } else if (currentPlayer == nameTwo) {
                    currentPlayer = nameOne;
                }
            }
            System.out.println(nameOne + " has " + playerOneChips + ".");
            System.out.println(nameTwo + " has " + playerTwoChips + ".");
            if (playerOneChips % 2 == 0) {
                System.out.println(nameOne + " wins!");
            } else {
                System.out.println(nameTwo + " wins!");
            }
            System.out.println("Play another game? (y/n) ");
            yorn = scanner.next();
        }
        while (yorn.equals("y"));
    }
}

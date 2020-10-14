package com.company;
import java.util.Scanner;
import java.util.Random;

public class Numbers {
    public static void main(String[] args){

        System.out.println("Hello welcome to the game!");
        System.out.println("Please guess a number between 1 and 100: ");

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        Integer maxValue = 100;
        Integer answer = rand.nextInt(maxValue);
        Integer guess = 0;
        Integer guessCounter = 0;
        Boolean correct = false;

        while (correct != true){
            guess = scanner.nextInt();
            if(answer - 10 <= guess &&  guess <= answer + 10){
                System.out.println("You got within 10 of the correct number!");
                System.out.println("The correct answer is " + answer + ".");
                correct = true;
            }else{
                guessCounter++;
                if(guessCounter == 5){
                    correct = true;
                }else{
                    System.out.println("Not even close! Try again: ");
                }

            }
        }
        if(guessCounter == 5){
            System.out.println("You ran out of guesses, sorry!");
        }else{
            System.out.println("You win!");
        }

    }

}

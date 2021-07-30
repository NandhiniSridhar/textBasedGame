package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();

        //game setup
        boolean running = true; //is the game running
        System.out.println("Welcome. The world has ended. Don't Panic! :)");
        Player player = new Player();
        Scanner in = new Scanner(System.in);


        //game loop
        GAME: //label
        while(running){
            System.out.println("------------------------------"); //separator

            //create new enemy
            int enemyHealth = rand.nextInt(Enemy.maxHealth);
            int enemyType = rand.nextInt(Enemy.TYPE.values().length);
            Enemy enemy = new Enemy(enemyHealth, enemyType);
            System.out.println("\t*A new + " + enemy.getMyType() + " has appeared!*\n");

            while(enemy.getHealth() > 0){
                System.out.println("\tYour HP: "+ player.getHealth());
                System.out.println("\t"+ enemy.getMyType() + "'s HP: "+ enemy.getHealth() + "\n");
                if(getPlayerAction().compareToIgnoreCase("C") == 0){
                    if(player.confront(enemy) == 0 || player.confront(enemy) == 3){
                        running = false;
                        break;
                    }
                }//confront
                else if(getPlayerAction().compareToIgnoreCase("D") == 0){
                    player.drinkHealthPotion();
                }//drink potion
                else if(getPlayerAction().compareToIgnoreCase("R") == 0){
                    player.run(enemy);
                    break;
                }//run
                getPlayerAction();
            }//inner while - get player action
            if(player.getHealth() <= 0) {
                System.out.println("\tHave fun at the funeral, and please join our intergalactic tour again");
                break;
            }

            System.out.println("------------------------------"); //separator
            System.out.println("\tYou have " + player.getHealth() + " health left.\nYou have " +
                    player.getNumHealthPotions() + " health potions left.");
            System.out.println("------------------------------"); //separator
            //get choice to continue or exit the game
            System.out.println("\tWhat would you like to do now? Continue Exploring [C], Exit [X]");
            String choice = in.nextLine();
            while(choice.compareToIgnoreCase("X") != 0 && choice.compareToIgnoreCase("C") != 0){
                System.out.println("\tInvalid input. Please type X or C");
            }
            if(choice.compareToIgnoreCase("X") == 0){
                running = false;
                break;
            }
            else if(choice.compareToIgnoreCase("C") == 0){
                System.out.println("\tYou continue your space adventure");
            }
        } //while

        System.out.println("\nThanks for playing!\n");

        return;
    }//function main

    public static String getPlayerAction(){
        Scanner in = new Scanner(System.in);
        System.out.println("\tWhat would you like to do?\n\tConfront [C], Drink Health Potion [D], Run [R]");
        String action = in.nextLine();

        if(action.compareToIgnoreCase("C") != 0 && action.compareToIgnoreCase("D") != 0 &&
                action.compareToIgnoreCase("R") != 0){
            System.out.println("\tInvalid input. Please choose again");
            getPlayerAction();
        }//if invalid input
        return action;
    }//figure out result
}//class main

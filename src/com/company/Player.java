package com.company;
import java.util.Scanner;
import java.util.Random;

public class Player {
    private int health = 75;
    private int playerDealtDamage = 25;
    private int numHealthPotions = 3;
    private int healthPotionHealAmount = 30;
    private int healthPotionDropChance = 50; //50% chance that enemy drops a health potion
    String name;

    Player(){
        System.out.print("Give your character a name: ");
        Scanner in = new Scanner(System.in);
        name = in.next();
        System.out.println("Your name is " + name);
        return;
    }

    public int confront(Enemy enemy){
        //returns 0 if you die
        //1 if you kill the enemy
        //2 if both survive
        //3 if both die
        Random rand = new Random();
        int damageDealt = rand.nextInt(playerDealtDamage);
        int damageTaken = rand.nextInt(enemy.getMaxDamageDealt());
        int retval = -1;

        enemy.setHealth(enemy.getHealth() - damageDealt);
        health -= damageTaken;
        System.out.println("\tYou confront the " + enemy.getMyType() +
                " for " + damageDealt + " damage.");
        System.out.println("\tUnfortunately, you also take " + damageTaken + " damage.");

        if(enemy.getHealth() <= 0){
            System.out.println("\tYou defeated the " + enemy.getMyType() +
                    ". I must inform you that murder is looked down upon on most planets");
            boolean potionDrop = rand.nextBoolean();
            if(potionDrop){
                System.out.println("\tThe " + enemy.getMyType() + " dropped a health potion!");
                numHealthPotions += 1;
                System.out.println("\tYou now have " + numHealthPotions + " health potions left.");
            }
            retval = 1; //you kill enemy
        }//kill enemy
        if(health <= 0){
            System.out.println("\tYou have died, in a tiny corner of space where no one knows you." +
                    "Hopefully, any life insurance payouts in your name also include you dying on another planet\n");
            if(retval == 1){
                retval = 3; //both die
            }
            else
                retval = 0; //enemy kills you and survives
        }
        if(retval == -1) {
            retval = 2;
        }
        return retval;
    }//confront

    public void drinkHealthPotion(){
        if(numHealthPotions > 0){
            health += healthPotionHealAmount;
            numHealthPotions -= 1;
            System.out.println("\tYou drink a health potion. Hope you have enough left" +
                    ". Your health is now " + health);
            System.out.println("\tYou now have " + numHealthPotions + " health potions left\n");
        }
        else{
            System.out.println("\tYou have no health potions left. Defeat an enemy to try to get one.\n");
        }
    }//drink potion

    public void run(Enemy enemy){
        System.out.println("\tYou run away from the " + enemy.getMyType() + ". Better go fast!");
        return;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPlayerDealtDamage() {
        return playerDealtDamage;
    }

    public void setPlayerDealtDamage(int playerDealtDamage) {
        this.playerDealtDamage = playerDealtDamage;
    }

    public int getNumHealthPotions() {
        return numHealthPotions;
    }

    public void setNumHealthPotions(int numHealthPotions) {
        this.numHealthPotions = numHealthPotions;
    }

    public int getHealthPotionHealAmount() {
        return healthPotionHealAmount;
    }

    public void setHealthPotionHealAmount(int healthPotionHealAmount) {
        this.healthPotionHealAmount = healthPotionHealAmount;
    }

    public int getHealthPotionDropChance() {
        return healthPotionDropChance;
    }

    public void setHealthPotionDropChance(int healthPotionDropChance) {
        this.healthPotionDropChance = healthPotionDropChance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

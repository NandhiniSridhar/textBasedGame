package com.company;

public class Enemy {
    enum TYPE {VORGON, TAX_COLLECTOR, PLANET_EARTH, MICE, ZAPHOD}
    static int maxHealth = 50;
    private int maxDamageDealt = 15;
    private int health;
    private TYPE myType;
    static double chanceDropPotion = 0.5;

    Enemy(int x){
        health = x;
    }
    Enemy(int h, int t){
      health = h;

      //assign type
      if(t == 0)
        myType = TYPE.VORGON;
      else if(t == 1)
        myType = TYPE.TAX_COLLECTOR;
      else if(t == 2)
          myType = TYPE.PLANET_EARTH;
      else if(t == 3)
          myType = TYPE.MICE;
      else if(t == 4)
          myType = TYPE.ZAPHOD;
    } //constructor

    public void setType(int t){
        if(t == 0)
            myType = TYPE.VORGON;
        else if(t == 1)
            myType = TYPE.TAX_COLLECTOR;
        else if(t == 2)
            myType = TYPE.PLANET_EARTH;
        else if(t == 3)
            myType = TYPE.MICE;
        else if(t == 4)
            myType = TYPE.ZAPHOD;
    } //set type

    public static int getMaxHealth() {
        return maxHealth;
    }

    public static void setMaxHealth(int maxHealth) {
        Enemy.maxHealth = maxHealth;
    }

    public int getMaxDamageDealt() {
        return maxDamageDealt;
    }

    public void setMaxDamageDealt(int maxDamageDealt) {
        this.maxDamageDealt = maxDamageDealt;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public TYPE getMyType() {
        return myType;
    }

    public void setMyType(TYPE myType) {
        this.myType = myType;
    }
}

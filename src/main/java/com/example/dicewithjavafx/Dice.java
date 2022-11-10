package com.example.dicewithjavafx;

import java.util.Random;

public class Dice
{
    private final Random ran = new Random();
    private String diceName;
    private int dice;

    Dice(){}

    Dice(String diceName)
    {
        setDiceName(diceName);
    }

    public void setDiceName(String name)
    {
        this.diceName = name;
    }

    public String getDiceName()
    {
        return this.diceName;
    }

    public int getDice()
    {
        return dice;
    }

    public void rollDice()
    {
        dice = ran.nextInt(6) + 1;
    }

    public String toString()
    {
        return getDiceName() + ": "+ getDice();
    }

    public boolean equals(Object o)
    {
        if(!(o instanceof Dice))
            return false;

        return ((Dice) o).getDice() == this.getDice();
    }

}

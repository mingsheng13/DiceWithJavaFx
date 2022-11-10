package com.example.dicewithjavafx;

import java.util.ArrayList;

public class Game
{
    private int lastWin;
    private boolean won;
    private final ArrayList<Dice> dices;

    Game()
    {
        lastWin = -1;
        won = false;
        dices = new ArrayList<>();
    }

    Game(Dice a, Dice b)
    {
        this();
        addPlayer(a);
        addPlayer(b);
    }
    //roll the every dice in the arraylist
    public void rollAllDices()
    {
        if(won)
            resetLastWin();
        else
            lastWinIncrement();

        for (Dice dice : dices)
        {
            dice.rollDice();
            System.out.print(dice.getDice());
        }
        System.out.println();

        for (Dice dice : dices)
        {
            if (!dices.get(0).equals(dice))
            {
                won = false;
                break;
            }
            else
                won = true;
        }
    }

    //add player to arraylist
    public void addPlayer(Dice d)
    {
        dices.add(d);
    }

    public String getWinStatus()
    {
        return won ? ("Current Status: "+"WIN\t\t") : ("Current Status: "+"LOSE: try again!");
    }

    public int getNoPlayer()
    {
        return dices.size();
    }
    public int getLastWin()
    {
        return lastWin;
    }
    private void lastWinIncrement()
    {
        this.lastWin++;
    }
    private void resetLastWin()
    {
        this.lastWin = 0;
    }

}

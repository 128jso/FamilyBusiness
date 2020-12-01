package com.example.familybusiness;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

// The CharacterCreation class creates a list of players that are denoted to be playing the game.
// Utilizes Spring IOC in order to pull beans from a given XML file.

public class CharacterCreation {

    // Creates and returns a list of players playing the game.
    // @param:  playerAmount         int number of players playing the game
    // return:                       a list of Players
    public static List<Player> newPlayer(int playerAmount) {
        // Spring Way | IOC (Inversion of Control)
        ApplicationContext context = new ClassPathXmlApplicationContext("playerbean.xml");
        List<Player> p = new ArrayList<>();
        for (int i = 0; i < playerAmount; i++) {
            p.add((Player) context.getBean("player" + i));
        }
        return p;
    }

    // Creates and returns a string of players in the given list of players
    // @param:  p                    a list of players
    // return:                       a string of a list of player names
    public static String playerNames(List<Player> p) {
        StringBuilder str = new StringBuilder(("[" + 1 + "]" + p.get(0).name));
        if(p.size() > 1) {
            for(int j = 1; j < p.size(); j++) {
                str.append("[").append(j + 1).append("]").append(p.get(j).name);
            }
        }
        return str.toString();
    }
}

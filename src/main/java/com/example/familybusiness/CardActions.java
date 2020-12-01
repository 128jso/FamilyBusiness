package com.example.familybusiness;

import java.util.Queue;

// The CardActions class denotes the different card actions that are executed when a given card is played.
public class CardActions {

    // Activates the contract skill that places an opponent's mobster on the Hit List, then returns the Hit List
    // @param:  opponent             opposing player a user wants to contract
    //          hitList              a queue of players that denote the Hit List mechanism of the game
    // return:                       a queue of players that denote the Hit List mechanism of the game
    public static Queue<Player> contract(Player opponent, Queue<Player> hitList) {
        hitList.add(opponent);
        opponent.aliveMobMembers -= 1;
        opponent.hitListMobMembers += 1;

        return hitList;
    }

    // Activates the contract skill that rescues a user's mobster on the Hit List, then returns the Hit List
    // @param:  player               user that would like to save their mobster
    //          hitList              a queue of players that denote the Hit List mechanism of the game
    // return:                       a queue of players that denote the Hit List mechanism of the game
    public static Queue<Player> takeItOnTheLam(Player player, Queue<Player> hitList) {
        hitList.remove(player);
        player.aliveMobMembers += 1;
        player.hitListMobMembers -= 1;
        return hitList;
    }
}


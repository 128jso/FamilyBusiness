package com.example.familybusiness;

import java.util.List;
import java.util.Queue;

// The Information class prints different information about the status of the game.
public class Information {

    // Prints the number of Outstanding Mobsters each player has and the status of the Hit List
    // @params: p              a list of players
    //          hitList        a queue of players that mimics the role of the Hit List
    public static void gameInfo(List<Player> p, Queue<Player> hitList) {

        for (Player player : p) {
            System.out.println(player.name + " Outstanding mob members: " + player.aliveMobMembers);
        }
        System.out.print("----- Hit List: ");

        if(hitList.size() != 0) {
            for(Player player : hitList) {
                System.out.print("[" + player.name + "] ");
            }
        } else {
            System.out.print(hitList);
        }
        System.out.println("------");
    }

    // Prints the error message because of an invalid card move
    public static void invalidCardMove() {
        System.out.println("You cannot play that card...");
        System.out.println("Choose a different card!");

    }

    // Prints the error message because of an invalid opponent choice
    public static void invalidOpponent() {
        System.out.println("You cannot choose that opponent...");
        System.out.println("Choose a different opponent!");
    }

    // Prints the winner of the game.
    // @params: winner         the Player who has won the game
    public static void winGame(Player winner) {
        System.out.println(winner.name + " has won the game!");
    }
}

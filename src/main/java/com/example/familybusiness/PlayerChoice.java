package com.example.familybusiness;

import java.util.List;
import java.util.Scanner;

// The Gameplay class runs the main gameplay of the popular card game Family Business.
public class PlayerChoice {

    // Enables a user to choose a card from their hand, and returns the chosen card.
    // @params: sc             scanner that reads user input
    //          player         user
    // @return:                the ActionCard a player chooses to play
    public static ActionCards playerChooseCard(Scanner sc, Player player) {
        System.out.println(player.printPlayerHand());
        System.out.println("Choose a card...");
        int cardNum = sc.nextInt() - 1;
        return player.hand.remove(cardNum);
    }

    // Enables a user to choose an opponent to act against.
    // @params: sc             scanner that reads user input
    //          opponents      a list of opposing players a user can choose from
    //          player         user
    // @return:                the ActionCard a player chooses to play
    public static Player chooseOpponent(Scanner sc, List<Player> opponents, Player player) {
        System.out.println("Choose Player to Contract: " + CharacterCreation.playerNames(opponents));
        int opponentNum = sc.nextInt() - 1;

        // Cannot choose an opponent that is not available.
        while(opponentNum >= opponents.size()) {
            Information.invalidOpponent();
            System.out.println("Choose Player to Contract: " + CharacterCreation.playerNames(opponents));
            opponentNum = sc.nextInt() - 1;
        }

        return opponents.get(opponentNum);
    }

    // Counts the number of opposing players that have no outstanding mobsters
    // @params: p              a list of players
    // @return:                an int amount of opposing players with no outstanding mobsters
    public static int countOpponents(List<Player> opponents) {
        int count = 0;
        for(Player opponent: opponents) {
            if (opponent.aliveMobMembers == 0) {
                count++;
            }
        }
        return count;
    }

}

package com.example.familybusiness;

import java.util.*;


// The Gameplay class runs the main gameplay of the popular card game Family Business.
public class Gameplay {

    // List of ActionCards to mimic a deck
    final static List<ActionCards> deck = new CreateDeck().newDeck(2);
    // List of ActionCards to mimic a discard pile
    final static List<ActionCards> discard = new ArrayList<>();
    // List of players playing in the game
    final static List<Player> p = new CharacterCreation().newPlayer(2);
    // Queue of players lined up for the Hit List
    static Queue<Player> hitList = new LinkedList<>();



     // Executes the command line arguments to enforce the gameplay of Family Business
     // @param: args            A string array containing the command line arguments
    public static void main(String[] args) {
        initializeGame();
        playGame(new Scanner(System.in));
    }

    // Initializes game of Family Business by shuffling deck of cards and dealing out 5 cards per player.
    public static void initializeGame() {
        Collections.shuffle(deck);

        for (Player player : p) {
            drawCards(deck, player, 5);
        }
    }

    // Activates game of Family Business, and plays until only 1 player remains.
    // @param:  sc             scanner that reads user input
    public static void playGame(Scanner sc) {
        int turn = 1;
        int mobWarFlag = 0;

        List<Player> remove = new ArrayList<>(p);
        while(remove.size() != 1){
            System.out.println("---TURN " + turn + "---");
            playerTurns: for(Player player: p) {
                // Player's left standing check
                for(Player checkPlayer: p) {
                    if(checkPlayer.hitListMobMembers + checkPlayer.aliveMobMembers == 0) {
                        remove.remove(checkPlayer);
                        break playerTurns;
                    }
                }
                Information.gameInfo(p, hitList);
                discard.add(checkChosenCard(sc, player));
                mobWarFlag = checkMobWar(mobWarFlag);
                if (deck.size() < 1) {
                    shuffleDiscard();
                }
                drawCards(deck, player, 1);
                System.out.println("--------------------------");
            }
            turn++;
        }
        Information.winGame(remove.get(0));
    }

    // Remove ActionCard from deck and add to player's hand
    // @params: deck           the List of ActionCards to pull ActionCards from
    //          player         the player who receives an ActionCard into their hand
    //          cardsDrawn     the amount of cards that need to be drawn
    public static void drawCards(List<ActionCards> deck, Player player, int cardsDrawn) {
        for(int i = 0; i < cardsDrawn; i++) {
            ActionCards card = deck.remove(0);
            player.hand.add(0,card);
        }
    }

    // Checks to see if any issues would arise with the ActionCard that user chooses then returns the ActionCard
    // @params: sc             scanner that reads user input
    //          player         the user who receives an ActionCard into their hand
    // @return:                the user chosen ActionCard
    public static ActionCards checkChosenCard(Scanner sc, Player player){
        int flag = 0;
        ActionCards chosenCard = PlayerChoice.playerChooseCard(sc, player);
        if(setDiscard(sc) == 1) {
            while(flag == 0) {
                flag = cardActions(sc, player, chosenCard);
            }
        }
        return chosenCard;
    }

    // Activates the actions of the card based on the ActionCards type and returns a flag.
    // @params: sc             scanner that reads user input
    //          player         the user who receives an ActionCard into their hand
    //          chosenCard     the user chosen ActionCard
    // @return:                returns a flag = 0 if errors arise, return 1 otherwise
    public static int cardActions(Scanner sc, Player player, ActionCards chosenCard) {
        // Contract Cards
        if(chosenCard.cardID == 0) {

            // Chooses a valid opponent
            List<Player> opponents = new ArrayList<>(p);
            opponents.remove(player);
            Player opponent = PlayerChoice.chooseOpponent(sc, opponents, player);
            int opponentCount = PlayerChoice.countOpponents(opponents);

            // Cannot choose an opponent that has no mobsters
            if(opponentCount >= (p.size() - 2) && opponent.aliveMobMembers == 0) {
                System.out.println("All opponents have no mobsters to place on the Hit List...");
                return 1;
            } else if (opponent.aliveMobMembers == 0) {
                System.out.println("The opponent has no mobsters to place on the Hit List...");
                Information.invalidCardMove();
                return  0;
            } else {
                CardActions.contract(opponent, hitList);
                System.out.println(player.name + " has played " + chosenCard.getCardName());
                return  1;
            }
        }

        // Rescue Cards
        if(chosenCard.cardID == 1) {
            // Cannot remove from Hit List if there is no mobster on the Hit List
            if(hitList.size() == 0){
                System.out.println("There are no mobsters to save...");
                Information.invalidCardMove();
                return  0;
            } else {
                CardActions.takeItOnTheLam(player, hitList);
                System.out.println(player.name + " has played " + chosenCard.getCardName());
                return  1;
            }
        }
        return 0;
    }

    // Checks if Mob War conditions are met, then activates Mob War accordingly.
    // @params: flag           the flag that represents if there is an ongoing MobWar
    // @return:                returns a flag = 0 no Mob War, return 1 otherwise
    public static int checkMobWar(int flag) {
        if (hitList.size() == 0 ) {
            flag = 0;
        } else if(hitList.size() >= 6 && flag == 1 || p.stream().anyMatch(i->i.aliveMobMembers == 0)) {
                System.out.println("---Mob War is in effect---");
                hitList.remove().hitListMobMembers -= 1;
                flag = 1;
            }
        return flag;
    }

    // Checks if user would like to discard, then returns user response.
    // @params: sc             scanner that reads user input
    // @return:                returns 0 if user would like to discard, return 1 otherwise
    public static int setDiscard(Scanner sc) {
        System.out.println("Would you like to discard? [Y] or [N]");
        if(sc.next().toUpperCase().trim().equals("N")) {
            return 1;
        }
        System.out.println("Card Discarded");
        return 0;
    }

    // Adds all ActionCards from discard into deck; shuffles deck
    public static void shuffleDiscard() {
        deck.addAll(discard);
        discard.clear();
        Collections.shuffle(deck);
    }

}

//package com.example.familybusiness;
//
//import com.example.familybusiness.Models.GameComponents.*;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.*;
//
//public class FamilyBusiness {
//
//    // static variables
//
//
//    // timeStamp-like state
//    private int timeStamp;
//
//    // States ////////////////////////////////////////////////
//    private List<String> turns;
//    private int myTurn;
//    private boolean endGame;
//
//
//    //////////////////////////////////////////////////////////////////////////////////////
//    //			                    Player Actions                                      //
//    //////////////////////////////////////////////////////////////////////////////////////
//
//    // Add a player to the game
//    // A player is added if a name is provided
//    public boolean addPlayer(String name, String color) {
//        if (MAX_PLAYERS == players.size()) {
//            return false;
//        }
//        mutated();
//        players.put(name, new Player(name,color, addCards(new ArrayList<Card>(), 5), addMobsters(new ArrayList<Mobster>(), name, color, MAX_MOBSTERS)));
//        turns.add(name);
//        return true;
//    }
//
//
//    /////////////////////////////////////////////////////////////////////
//    // 	In game action
//    ////////////////////////////////////////////////////////////////////
//
//    // Player chooses to play a card
//    public boolean playCard(String player, Card card) {
//        // If game has ended, should not be able to play a card.
//        if (endGame)
//            return false;
//
//        System.out.println(card.cardName);
//
//        // Resolve card played
//        // cardTypes(card);
//        // Discard used card
//        discardCardsFromHand(player, card);
//        // Draw card from deck
//        addCardsToHand(player);
//
//        updateTurnCounter();
//        return true;
//    }
//
//
//
//
//
//    /////////////////////////////////////////////////////////////////////
//    // 	Card Actions
//    ////////////////////////////////////////////////////////////////////
//
//    private void cardTypes(Card card) {
//        int type = card.id;
//        if (type == 0) {
//            contract();
//        }
//        if (type == 1) {
//            attack();
//        }
//        if (type == 2) {
//            rescue();
//        }
//        if (type == 3) {
//            counter();
//        }
//    }
//
//    public boolean contract() {
//
//        return true;
//
//    }
//
//    public void attack() {
//
//    }
//
//    public boolean rescue() {
//        if (hitList.size() == 0)
//            return false;
//
//        return true;
//    }
//
//    public void counter() {
//
//    }
//
//
//    /////////////////////////////////////////////////////////////////////////////////////
//    //    Private Helper Methods
//    ////////////////////////////////////////////////////////////////////////////////////
//
//    // Add specified amount of cards into hand
//    private List<Card> addCards(List<Card> hand, int cardCount) {
//        for (int i = 0; i < cardCount; i++) {
//            hand.add(deck.remove(0));
//        }
//        return hand;
//    }
//
//    // Add specified amount of cards into hand
//    private void addCardsToHand(String player) {
//        if (deck.size() == 0) {
//            deck.addAll(discard);
//            discard.clear();
//            Collections.shuffle(deck);
//        }
//        players.get(player).hand.add(deck.remove(0));
//    }
//
//
//    public boolean discardCardsFromHand(String player, Card card) {
//        players.get(player).hand.remove(card);
//        discard.add(card);
//        return true;
//    }
//
//    // Add Mobster to Hit List
//    private boolean addMobsterToHitList(Mobster mobMember) {
//        if (endGame)
//            return false;
//        players.get(mobMember.mobBoss).members.remove(mobMember);
//        hitList.add(mobMember);
//        return true;
//    }
//
//    // Remove Mobster from Hit List
//    private boolean removeMobsterFromHitList(Mobster mobMember) {
//        if (endGame)
//            return false;
//        players.get(mobMember.mobBoss).members.add(mobMember);
//        return true;
//    }
//
//    private void updateTurnCounter() {
//        mutated();
//        if (myTurn + 1 == turns.size()) {
//            myTurn = 0;
//        } else {
//            myTurn++;
//        }
//    }
//
//    //////////////////////////////////////////////////////////////////////////
//    // Observers
//    /////////////////////////////////////////////////
//
//    public String getPlayerTurn() {
//        return turns.get(myTurn);
//    }
//
//}
//





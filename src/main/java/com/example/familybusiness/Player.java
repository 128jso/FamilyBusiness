package com.example.familybusiness;


import java.util.ArrayList;
import java.util.List;

// Bean or Model or POJO(Plain Old Java Object)
public class Player {

    // Attributes of Player Class
    int id;
    String name;
    int aliveMobMembers;
    int hitListMobMembers;
    List<ActionCards> hand = new ArrayList<>();

    // Constructors for the Player class
    public Player() {
    }

    public Player(int id, String name, int aliveMobMembers, int hitListMobMembers, List<ActionCards> hand) {
        this.id = id;
        this.name = name;
        this.aliveMobMembers = aliveMobMembers;
        this.hitListMobMembers = hitListMobMembers;
        this.hand = hand;
    }

    // Getters and Setters of the Player Class
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAliveMobMembers() {
        return aliveMobMembers;
    }

    public void setAliveMobMembers(int aliveMobMembers) {
        this.aliveMobMembers = aliveMobMembers;
    }

    public int getHitListMobMembers() {
        return hitListMobMembers;
    }

    public void setHitListMobMembers(int hitListMobMembers) {
        this.hitListMobMembers = hitListMobMembers;
    }

    public List<ActionCards> getHand() {
        return hand;
    }

    public void setHand(List<ActionCards> hand) {
        this.hand = hand;
    }

    public String printPlayerHand() {
        StringBuilder str = new StringBuilder(name + "'s Hand: " + "[" + 1 + "]" + hand.get(0).cardName);
        for(int i = 1; i < hand.size(); i++) {
            str.append(", [").append(i + 1).append("]").append(hand.get(i).cardName);
        }
        return str.toString();
    }

}

package com.example.familybusiness.Models.GameComponents;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public String id;
    public String gangColor;
    public List<Card> hand;
    public List<Mobster> members;

    // New Player Initialization
    public Player(String name, String color) {
        this.name = name;
        this.id = null;
        this.gangColor = color;
        this.hand = new ArrayList<>();
        this.members = new ArrayList<>();

        for(int j = 0; j < 9; j++) {
            members.add(new Mobster(name, color, name + "'s Mobster " + j));
        }
    }

    public Player(String name, String gangColor, List<Card> hand, List<Mobster> members) {
        this.name = name;
        this.id = null;
        this.gangColor = gangColor;
        this.hand = hand;
        this.members = members;
    }

    public Player() {

    }

    public List<Card> getHand() {
        return hand;
    }

    public List<Mobster> getMembers() {
        return members;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package com.example.familybusiness.Models.Messaging;

import com.example.familybusiness.Models.GameComponents.Card;

public class PlayerMoveMessage {

    private String player;
    private Card card;


    // Getters and Setters
    public String getPlayer() {
        return player;
    }

    public Card getCard() {return card;}
}

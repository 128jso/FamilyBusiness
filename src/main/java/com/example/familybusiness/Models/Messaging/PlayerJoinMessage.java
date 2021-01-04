package com.example.familybusiness.Models.Messaging;

public class PlayerJoinMessage {

    private String player;


    // Constructors
    public PlayerJoinMessage(String player) {
        this.player = player;
    }


    // Getters and Setters
    public String getPlayer() {
        return player;
    }
}

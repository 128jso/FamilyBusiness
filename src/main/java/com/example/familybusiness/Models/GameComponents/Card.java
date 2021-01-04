package com.example.familybusiness.Models.GameComponents;

public class Card {
    public int id;
    public String cardName;
    public String cardDescription;
    public int cardFrequency;
    public int counterCard;

    public Card() {

    }

    public Card(int id, String cardName, String cardDescription, int cardFrequency) {
        this.id = id;
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.cardFrequency = cardFrequency;
    }

    public Card(int id, String cardName, String cardDescription, int cardFrequency, int counterCard) {
        this.id = id;
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.cardFrequency = cardFrequency;
        this.counterCard = counterCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }

    public int getCardFrequency() {
        return cardFrequency;
    }

    public void setCardFrequency(int cardFrequency) {
        this.cardFrequency = cardFrequency;
    }

    public void setCounterCard(int counterCard) {
        this.counterCard = counterCard;
    }
}

package com.example.familybusiness;

public class ActionCards {

    //Attributes
    int cardID;                      // type of card being used
    String cardName;                 // name of card
    String cardDescription;          // description of card
    int cardFrequency;               // frequency of card in deck

    // Constructors for the ActionCard class
    public ActionCards() {
    }

    public ActionCards(int cardID, String cardName, String cardDescription, int cardFrequency) {
        this.cardID = cardID;
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.cardFrequency = cardFrequency;
    }

    // Getters and Setters of the ActionCard Class
    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
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

    @Override
    public String toString() {
        return "ActionCards{" +
                "cardID=" + cardID +
                ", cardName='" + cardName + '\'' +
                ", cardDescription='" + cardDescription + '\'' +
                ", cardFrequency='" + cardFrequency + '\'' +
                '}';
    }
}

package com.example.familybusiness;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

// The CreateDeck class creates a deck of cards that can be used to play the game.
// Utilizes Spring IOC in order to pull beans from a given XML file.
public class CreateDeck {

    // Creates and returns a deck of cards with the given number of types of cards.
    // @param:  types                int number of different types of cards being used.
    // return:                       a list of Action cards that signify a deck of cards.
    public  List<ActionCards> newDeck(int types) {

        // Spring Way | IOC (Inversion of Control)
        ApplicationContext context = new ClassPathXmlApplicationContext("cardbeanPromo.xml");
        List<ActionCards> deck = new ArrayList<ActionCards>();
        for(int i = 0; i < types; i++) {
            ActionCards card = (ActionCards) context.getBean("card" + i);
            for(int j = 0; j < card.cardFrequency; j++) {
                deck.add(card);
            }
        }
        return deck;
    }
}

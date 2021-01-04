package com.example.familybusiness.Models.GameStateModels;

import com.example.familybusiness.Models.GameComponents.*;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.annotation.*;
import java.util.*;

public class GameStateModel {
    public static final String[] COLORS = {
            "RED", "GREEN", "BLUE", "BLACK", "PURPLE", "GOLD"
    };
    public final int MAX_PLAYERS = 6;
    public static final int CARD_TYPES = 3;


    @Id
    public String id;                               // Game ID

    public String name;                             // Name of game
    public Map<String, Player> players;
    public List<Card> deck;
    public List<Card> discard;
    public Queue<Mobster> hitList;

    public boolean started;
    public boolean disconnect;
    public boolean endGame;

    // Game first created
    public GameStateModel(String playerName, String name) {
        this.name = name;
        this.deck = new ArrayList<>();
        this.hitList = new LinkedList<>();
        this.players = new HashMap<>();
        this.started = false;
        this.disconnect = false;
        this.endGame = false;

        // Initialize Gameplay
        // Add new player
        join(playerName);

        // Setting up the deck
        ApplicationContext context = new ClassPathXmlApplicationContext("cardbeanPromo.xml");
        for(int i = 0; i < CARD_TYPES; i++) {
            Card card = (Card) context.getBean("card" + i);
            for(int j = 0; j < card.cardFrequency; j++) {
                deck.add(card);
            }
        }
        Collections.shuffle(deck);

    }


    // Server Methods
    public void join(String pName) {
        Random random = new Random();
        int index = random.nextInt(COLORS.length);
        players.put(name, new Player(pName, COLORS[index]));
        ArrayUtils.remove(COLORS, index);
    }

    public void websocketJoin(String player, String playerId) {
        players.get(player).id = playerId;
    }

    public void disconnect(String player) {
        if (isValidPlayer(player)) {
            disconnect = true;
        }
    }

    public void disconnectById(String playerId) {
        if (isValidPlayerId(playerId)) {
            disconnect = true;
        }
    }


    // Game Actions
    public void makeMove(String player, Card card) {

    }

    // Getters and Setters
    public Map<String, Player> getPlayers() {
        players.replaceAll((n, v) -> v);
        return players;
    }

    public Queue<Mobster> getHitList() {
        return hitList;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public List<Card> getDiscard() {
        return discard;
    }

    public boolean getEndGame() {
        return endGame;
    }


    // Helper Functions
    private boolean isValidPlayer(String player) {
        return players.containsKey(player);
    }

    private boolean isValidPlayerId(String playerId) {
        for (Map.Entry<String, Player> stringPlayerEntry : players.entrySet()) {
            Player p = (Player) ((Map.Entry) stringPlayerEntry).getValue();
            if (p.id.equals(playerId))
                return true;
        }
        return false;
    }

    private boolean gameOver() {
        return endGame;
    }

}

package com.example.familybusiness.Controllers;

import com.example.familybusiness.repository.GameStateRepository;
import com.example.familybusiness.Models.GameStateModels.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ServerController {

    private GameStateRepository repository;

    private SimpMessagingTemplate template;

    // Find Available Game
    @GetMapping("/fm/games")
    public List<AvailableGame> getGames() {
        List<AvailableGame> available = new ArrayList<>();
        List<GameStateModel> games = repository.findByStartedAndDisconnect(false, false);

        for(GameStateModel game : games) {
            available.add(new AvailableGame(game.id, game.name));
        }
        return available;
    }

    // Create Game
    @PostMapping("/fm/game")
    public GameStateModel createGame(
            @RequestParam(value = "player") String playerName,
            @RequestParam(value = "name", defaultValue="A Family Business Game") String name) {
        GameStateModel game = new GameStateModel(playerName, name);
        repository.save(game);
        return game;
    }

    // Join game
    @RequestMapping(method = RequestMethod.PATCH, value = "/fm/game", params = {"id", "player"})
    public GameStateModel joinGame(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "player") String player
    ) {
        GameStateModel game = repository.findBy(id);

        if (game.players.size() != game.MAX_PLAYERS && !game.disconnect) {
            game.join(player);

            repository.save(game);
            updateGameState(id, game);

            return game;
        }
        return null;
    }

    // Disconnect from game
    @RequestMapping(method = RequestMethod.PATCH, value = "/fm/game", params = {"id", "player", "disconnect"})
    public GameStateModel disconnectGame(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "player") String player,
            @RequestParam(value = "disconnect") boolean disconnect) {

        GameStateModel game = repository.findBy(id);

        if (disconnect) {
            game.disconnect(player);
            repository.save(game);
            updateGameState(id, game);
            return game;
        }
        return null;
    }

    // push new game state to websocket
    private void updateGameState(String id, GameStateModel game) {
        template.convertAndSend("/fm/gamestate/" + id, game);
    }
}


//
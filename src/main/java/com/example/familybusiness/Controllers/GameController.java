package com.example.familybusiness.Controllers;

import com.example.familybusiness.repository.GameStateRepository;
import com.example.familybusiness.Models.GameStateModels.GameStateModel;
import com.example.familybusiness.Models.Messaging.*;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    private GameStateRepository repository;

    @MessageMapping("/move/{id}")
    @SendTo("/fm/gamestate/{id}")
    public GameStateModel gamestate(@DestinationVariable String id, PlayerMoveMessage move) {
        GameStateModel game = repository.findBy(id);
        game.makeMove(move.getPlayer(), move.getCard());
        repository.save(game);
        return game;
    }

    @MessageMapping("join/{id}")
    public void join(SimpMessageHeaderAccessor headerAccessor, @DestinationVariable String id, PlayerJoinMessage message) {
        GameStateModel game = repository.findBy(id);

        game.websocketJoin(message.getPlayer(), headerAccessor.getSessionId());
        repository.save(game);
    }
}

//package com.example.familybusiness.Controllers;
//
//import com.example.familybusiness.repository.GameStateRepository;
//import com.example.familybusiness.Models.GameStateModels.GameStateModel;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationListener;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//
//@Component
//public class SessionDisconnectEventListener implements ApplicationListener<SessionDisconnectEvent> {
//
//    private GameStateRepository repository;
//
//    private SimpMessagingTemplate template;
//
//    private static final Logger logger = LoggerFactory.getLogger(SessionDisconnectEventListener.class);
//
//    @Override
//    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
//        String playerId = StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage()).getSessionId();
//
//        GameStateModel game = repository.findByPlayerId(playerId);
//
//        game.disconnectById(playerId);
//
//        repository.save(game);
//        template.convertAndSend("/fm/gamestate/" + game.id, game);
//    }
//
//}

package com.example.familybusiness.repository;

import com.example.familybusiness.Models.GameStateModels.GameStateModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GameStateRepository extends MongoRepository<GameStateModel, String>{

    public GameStateModel findBy(String id);
    public List<GameStateModel> findByStartedAndDisconnect(boolean started, boolean disconnect);
}

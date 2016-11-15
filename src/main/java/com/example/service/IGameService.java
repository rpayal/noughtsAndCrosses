package com.example.service;

import com.example.domain.Game;
import com.example.domain.Player;
import com.example.dto.GameDto;
import com.example.enums.GameStatus;

/**
 * Created by rpayal on 14/11/2016.
 */
public interface IGameService {
    Game createNewGame(Player player, GameDto gameDto);

    Game getGame(Long id);

    GameStatus checkGameStatus(Game game);

    Game updateGameStatus(Game game, GameStatus gameStatus);
}

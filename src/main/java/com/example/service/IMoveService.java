package com.example.service;

import com.example.domain.Game;
import com.example.domain.Move;
import com.example.domain.Player;
import com.example.domain.Position;
import com.example.dto.CreateMoveDto;
import com.example.enums.GameStatus;

import java.util.List;

/**
 * Created by rpayal on 14/11/2016.
 */
public interface IMoveService {
    Move createMove(Game game, Player player, CreateMoveDto createMoveDto);

    List<Position> getPlayerMovePositionsInGame(Game game, Player player);

    List<Position> getFilledPositionsInGame(Game game);
}

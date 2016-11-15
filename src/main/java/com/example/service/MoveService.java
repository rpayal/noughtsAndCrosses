package com.example.service;

import com.example.domain.Game;
import com.example.domain.Move;
import com.example.domain.Player;
import com.example.domain.Position;
import com.example.dto.CreateMoveDto;
import com.example.enums.GameStatus;
import com.example.util.GameRule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rpayal on 14/11/2016.
 */
@Service
public class MoveService implements IMoveService {
    @Override
    public Move createMove(Game game, Player player, CreateMoveDto createMoveDto) {
        Move move = new Move();
        //TODO: id will be handled by sequence no
        move.setId(102);
        move.setBoardColumn(createMoveDto.getBoardColumn());
        move.setBoardRow(createMoveDto.getBoardRow());
        move.setCreated(new Date());
        move.setPlayer(player);
        move.setGame(game);
        // save move
        return move;
    }

    @Override
    public List<Position> getPlayerMovePositionsInGame(Game game, Player player) {
        //TODO: get player moves in game from db
        return new ArrayList<Move>().stream()
                .map(move -> new Position(move.getBoardRow(), move.getBoardColumn()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Position> getFilledPositionsInGame(Game game) {
        //TODO: get all filled positions in game from db
        return new ArrayList<Move>().stream()
                .map(move -> new Position(move.getBoardRow(), move.getBoardColumn()))
                .collect(Collectors.toList());
    }
}

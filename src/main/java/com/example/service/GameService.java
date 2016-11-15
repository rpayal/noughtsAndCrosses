package com.example.service;

import com.example.domain.Game;
import com.example.domain.Player;
import com.example.dto.GameDto;
import com.example.enums.GameStatus;
import com.example.enums.Piece;
import com.example.util.GameRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * Created by rpayal on 14/11/2016.
 */
@Service
public class GameService implements IGameService {
    @Autowired
    private IMoveService moveService;

    @Override
    public Game createNewGame(Player player, GameDto gameDto) {
        Game game = new Game();
        //TODO: id will be handled by sequence no
        game.setId(101l);
        game.setFirstPlayer(player);
        game.setFirstPlayerPieceCode(gameDto.getPiece());
        game.setGameStatus(GameStatus.NEW);
        game.setCreated(new Date());
        // save game
        return game;
    }

    @Override
    public Game getGame(Long id) {
        //TODO: get it from repo.
        return getProxyGame(id);
    }

    @Override
    public GameStatus checkGameStatus(Game game) {
        if (GameRule.isWinner(moveService.getPlayerMovePositionsInGame(game, game.getFirstPlayer()))) {
            return GameStatus.FIRST_PLAYER_WON;
        } else if (GameRule.isWinner(moveService.getPlayerMovePositionsInGame(game, game.getSecondPlayer()))) {
            return GameStatus.SECOND_PLAYER_WON;
        } else if (GameRule.isBoardIsFull(moveService.getFilledPositionsInGame(game))) {
            return GameStatus.TIE;
        } else if (game.getSecondPlayer() == null ) {
            return GameStatus.NEW;
        } else {
            return GameStatus.IN_PROGRESS;
        }
    }

    @Override
    public Game updateGameStatus(Game game, GameStatus gameStatus) {
        game.setGameStatus(gameStatus);
        return game;
    }

    private Game getProxyGame(Long id) {
        Game game = new Game();
        game.setId(id);
        game.setFirstPlayer(new Player("player1", "player1@email.com", "player1"));
        game.setFirstPlayerPieceCode(Piece.X);
        game.setGameStatus(GameStatus.IN_PROGRESS);
        game.setCreated(new Date());
        return game;
    }
}

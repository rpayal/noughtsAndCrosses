package com.example.common;

import com.example.domain.Game;
import com.example.domain.Player;
import com.example.enums.GameStatus;
import com.example.enums.Piece;

import java.util.Date;

/**
 * Created by rpayal on 14/11/2016.
 */
public class TestUtil {

    public static Game getGame(Long gameId, GameStatus gameStatus) {
        return new Game(gameId, getPlayer("player1"), getPlayer("player2"), Piece.X, gameStatus, new Date());
    }

    public static  Player getPlayer(String playerId) {
        return new Player(playerId, "player1@email.com", "player1");
    }
}

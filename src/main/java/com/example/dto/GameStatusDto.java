package com.example.dto;

import com.example.enums.GameStatus;
import com.example.enums.Piece;

/**
 * Created by rpayal on 14/11/2016.
 */
public class GameStatusDto {
    private Long id;
    private GameStatus gameStatus;
    public GameStatusDto() {
    }

    public GameStatusDto(Long id, GameStatus gameStatus) {
        this.id = id;
        this.gameStatus = gameStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}

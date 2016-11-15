package com.example.domain;

import com.example.enums.GameStatus;
import com.example.enums.Piece;

import java.util.Date;

/**
 * Created by rpayal on 14/11/2016.
 */
public class Game {
    private Long id;
    private Player firstPlayer;
    private Player secondPlayer;
    private Piece firstPlayerPieceCode;
    private GameStatus gameStatus;
    private Date created;

    public Game() {
    }

    public Game(Long id, Player firstPlayer, Player secondPlayer, Piece firstPlayerPieceCode, GameStatus gameStatus, Date created) {
        this.id = id;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.firstPlayerPieceCode = firstPlayerPieceCode;
        this.gameStatus = gameStatus;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Piece getFirstPlayerPieceCode() {
        return firstPlayerPieceCode;
    }

    public void setFirstPlayerPieceCode(Piece firstPlayerPieceCode) {
        this.firstPlayerPieceCode = firstPlayerPieceCode;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Game{");
        sb.append("id=").append(id);
        sb.append(", secondPlayer=").append(secondPlayer);
        sb.append(", firstPlayer=").append(firstPlayer);
        sb.append(", firstPlayerPieceCode=").append(firstPlayerPieceCode);
        sb.append(", gameStatus=").append(gameStatus);
        sb.append(", created=").append(created);
        sb.append('}');
        return sb.toString();
    }
}

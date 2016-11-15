package com.example.dto;

import com.example.enums.GameStatus;
import com.example.enums.Piece;

import java.util.Date;

/**
 * Created by rpayal on 14/11/2016.
 */
public class MoveDto {
    private int boardColumn;
    private int boardRow;
    private Date created;
    private String userName;
    private GameStatus gameStatus;
    private Piece playerPieceCode;

    public MoveDto() {
    }

    public MoveDto(int boardColumn, int boardRow, Date created, String userName, GameStatus gameStatus, Piece playerPieceCode) {
        this.boardColumn = boardColumn;
        this.boardRow = boardRow;
        this.created = created;
        this.userName = userName;
        this.gameStatus = gameStatus;
        this.playerPieceCode = playerPieceCode;
    }

    public int getBoardColumn() {
        return boardColumn;
    }

    public void setBoardColumn(int boardColumn) {
        this.boardColumn = boardColumn;
    }

    public int getBoardRow() {
        return boardRow;
    }

    public void setBoardRow(int boardRow) {
        this.boardRow = boardRow;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Piece getPlayerPieceCode() {
        return playerPieceCode;
    }

    public void setPlayerPieceCode(Piece playerPieceCode) {
        this.playerPieceCode = playerPieceCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MoveDto{");
        sb.append("boardColumn=").append(boardColumn);
        sb.append(", boardRow=").append(boardRow);
        sb.append(", created=").append(created);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", gameStatus=").append(gameStatus);
        sb.append(", playerPieceCode=").append(playerPieceCode);
        sb.append('}');
        return sb.toString();
    }
}

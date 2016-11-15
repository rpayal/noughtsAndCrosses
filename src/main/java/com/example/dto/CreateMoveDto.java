package com.example.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by rpayal on 14/11/2016.
 */
public class CreateMoveDto {
    @NotNull
    private long gameId;
    @NotNull
    int boardRow;
    @NotNull
    int boardColumn;

    public CreateMoveDto() {
    }

    public CreateMoveDto(long gameId, int boardRow, int boardColumm) {
        this.boardColumn = boardColumn;
        this.gameId = gameId;
        this.boardRow = boardRow;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public int getBoardRow() {
        return boardRow;
    }

    public void setBoardRow(int boardRow) {
        this.boardRow = boardRow;
    }

    public int getBoardColumn() {
        return boardColumn;
    }

    public void setBoardColumn(int boardColumn) {
        this.boardColumn = boardColumn;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateMoveDto{");
        sb.append("gameId=").append(gameId);
        sb.append(", boardRow=").append(boardRow);
        sb.append(", boardColumn=").append(boardColumn);
        sb.append('}');
        return sb.toString();
    }
}

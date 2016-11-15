package com.example.domain;

import java.util.Objects;

/**
 * Created by rpayal on 14/11/2016.
 */
public class Position {
    int boardRow;
    int boardColumn;

    public Position() {
    }

    public Position(int boardRow, int boardColumn) {
        this.boardRow = boardRow;
        this.boardColumn = boardColumn;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return boardRow == position.boardRow &&
                boardColumn == position.boardColumn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardRow, boardColumn);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Position{");
        sb.append("boardRow=").append(boardRow);
        sb.append(", boardColumn=").append(boardColumn);
        sb.append('}');
        return sb.toString();
    }
}

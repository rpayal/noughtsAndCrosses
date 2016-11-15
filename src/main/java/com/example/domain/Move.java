package com.example.domain;

import java.util.Date;

/**
 * Created by rpayal on 14/11/2016.
 */
public class Move {
    private int id;
    private Game game;
    private int boardRow;
    private int boardColumn;
    private Player player;
    private Date created;

    public Move() {
    }

    public Move(int id, Game game, int boardRow, int boardColumn, Player player, Date created) {
        this.id = id;
        this.game = game;
        this.boardRow = boardRow;
        this.boardColumn = boardColumn;
        this.player = player;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Move{");
        sb.append("id=").append(id);
        sb.append(", game=").append(game);
        sb.append(", boardRow=").append(boardRow);
        sb.append(", boardColumn=").append(boardColumn);
        sb.append(", player=").append(player);
        sb.append(", created=").append(created);
        sb.append('}');
        return sb.toString();
    }
}

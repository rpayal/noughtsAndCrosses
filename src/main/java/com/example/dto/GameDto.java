package com.example.dto;

import com.example.enums.Piece;

/**
 * Created by rpayal on 14/11/2016.
 */
public class GameDto {
    private long id;
    private Piece piece;

    public GameDto() {
    }

    public GameDto(long id, Piece piece) {
        this.id = id;
        this.piece = piece;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameDto{");
        sb.append("id=").append(id);
        sb.append(", piece=").append(piece);
        sb.append('}');
        return sb.toString();
    }
}

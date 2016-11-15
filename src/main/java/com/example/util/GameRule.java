package com.example.util;

import com.example.domain.Game;
import com.example.domain.Position;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by rpayal on 14/11/2016.
 */
public class GameRule {
    private final Game game;

    public GameRule(Game game) {
        this.game = game;
    }

    /**
     * Checks if the player wins
     * @param positions Board positions for player
     * @return true or false if the player is a winner
     */
    public static boolean isWinner(List<Position> positions) {
        return getWinningPositions().stream().anyMatch(positions::containsAll);
    }

    public static boolean isBoardIsFull(List<Position> takenPositions) {
        return takenPositions.size() == 9;
    }

    /**
     * Stores list of winning positions.
     * @return the list of the winning position's list
     */
    private static List<List<Position>> getWinningPositions() {
        List<List<Position>> winingPositions = new ArrayList<>();
        // ho§rizontal match
        winingPositions.add(asList(new Position(1, 1), new Position(1, 2), new Position(1,3)));
        winingPositions.add(asList(new Position(2, 1), new Position(2, 2), new Position(2,3)));
        winingPositions.add(asList(new Position(3, 1), new Position(3, 2), new Position(3,3)));
        // vertical match
        winingPositions.add(asList(new Position(1, 1), new Position(2, 1), new Position(3,1)));
        winingPositions.add(asList(new Position(1, 2), new Position(2, 2), new Position(3,2)));
        winingPositions.add(asList(new Position(1, 3), new Position(2, 3), new Position(3,3)));
        // diagonal match
        winingPositions.add(asList(new Position(1, 1), new Position(2, 2), new Position(3,3)));
        winingPositions.add(asList(new Position(3, 1), new Position(2, 2), new Position(1,3)));

        return winingPositions;
    }
}

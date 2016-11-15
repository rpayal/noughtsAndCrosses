package com.example.service;

import com.example.common.TestUtil;
import com.example.domain.Game;
import com.example.domain.Player;
import com.example.domain.Position;
import com.example.dto.GameDto;
import com.example.enums.GameStatus;
import com.example.enums.Piece;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

/**
 * Created by rpayal on 14/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @Mock
    private IMoveService moveService;
    @InjectMocks
    private GameService target;

    private Long gameId = 101l;

    @Test
    public void testCreateNewGame() throws Exception {
        Player player = TestUtil.getPlayer("player1");
        GameDto gameDto = getGameDto(gameId);

        Game resGame = target.createNewGame(player, gameDto);
        assertNotNull(resGame);
        assertEquals(resGame.getGameStatus(), GameStatus.NEW);
    }

    @Test
    public void testGetGame() {
        Game resGame = target.getGame(gameId);
        assertNotNull(resGame);
        assertEquals(resGame.getId(), gameId);
    }

    @Test
    public void testCheckGameStatus_FirstPlayer_Won() {
        Game game = TestUtil.getGame(gameId, GameStatus.IN_PROGRESS);
        given(moveService.getPlayerMovePositionsInGame(game, game.getFirstPlayer())).willReturn(asList(new Position(1, 1), new Position(1, 2), new Position(1,3)));

        GameStatus status = target.checkGameStatus(game);
        assertNotNull(status);
        assertEquals(status, GameStatus.FIRST_PLAYER_WON);
    }

    @Test
    public void testCheckGameStatus_2ndPlayer_Won() {
        Game game = TestUtil.getGame(gameId, GameStatus.IN_PROGRESS);
        given(moveService.getPlayerMovePositionsInGame(game, game.getSecondPlayer())).willReturn(asList(new Position(1, 1), new Position(1, 2), new Position(1,3)));

        GameStatus status = target.checkGameStatus(game);
        assertNotNull(status);
        assertEquals(status, GameStatus.SECOND_PLAYER_WON);
    }

    @Test
    public void testCheckGameStatus_Game_Tie() {
        Game game = TestUtil.getGame(gameId, GameStatus.IN_PROGRESS);
        given(moveService.getFilledPositionsInGame(game))
                .willReturn(getAllPositions());

        GameStatus status = target.checkGameStatus(game);
        assertNotNull(status);
        assertEquals(status, GameStatus.TIE);
    }

    @Test
    public void testCheckGameStatus_Game_New() {
        Game game = TestUtil.getGame(gameId, GameStatus.NEW);
        game.setSecondPlayer(null);
        given(moveService.getFilledPositionsInGame(game))
                .willReturn(new ArrayList<Position>());

        GameStatus status = target.checkGameStatus(game);
        assertNotNull(status);
        assertEquals(status, GameStatus.NEW);
    }

    @Test
    public void testCheckGameStatus_Game_InProgress() {
        Game game = TestUtil.getGame(gameId, GameStatus.NEW);
        given(moveService.getFilledPositionsInGame(game))
                .willReturn(new ArrayList<Position>());

        GameStatus status = target.checkGameStatus(game);
        assertNotNull(status);
        assertEquals(status, GameStatus.IN_PROGRESS);
    }

    private List<Position> getAllPositions() {
        List<Position> positions = new ArrayList<>();
        IntStream.rangeClosed(1, 3)
                .forEach(r -> IntStream.rangeClosed(1, 3)
                        .forEach(c -> {
                            positions.add(new Position(r, c));
                        }));
        return positions;
    }

    private GameDto getGameDto(long gameId) {
        return new GameDto(gameId, Piece.X);
    }
}
package com.example.controller;

import com.example.common.TestUtil;
import com.example.domain.Game;
import com.example.domain.Move;
import com.example.domain.Player;
import com.example.dto.CreateMoveDto;
import com.example.enums.GameStatus;
import com.example.service.IGameService;
import com.example.service.IMoveService;
import com.example.service.IPlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by rpayal on 14/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MoveControllerTest {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Mock
    private IMoveService moveService;
    @Mock
    private IGameService gameService;
    @Mock
    private IPlayerService playerService;

    @InjectMocks
    private MoveController moveController;

    @Before
    public void setup() {
        mockMvc = standaloneSetup(moveController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testCreateMove() throws Exception {
        long gameId = 101l;
        Player player = TestUtil.getPlayer("player1");
        CreateMoveDto createMoveDto = new CreateMoveDto(101l, 1, 1);

        Game game = TestUtil.getGame(gameId, GameStatus.IN_PROGRESS);
        given(gameService.getGame(gameId)).willReturn(game);
        given(playerService.getLoggedUser()).willReturn(player);
        Move move = new Move(102, game, createMoveDto.getBoardRow(), createMoveDto.getBoardColumn(), player, new Date());
        given(moveService.createMove(any(), any(), any())).willReturn(move);
        given(gameService.checkGameStatus(game)).willReturn(GameStatus.IN_PROGRESS);
        gameService.updateGameStatus(game, GameStatus.IN_PROGRESS);

        this.mockMvc.perform(post("/move/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createMoveDto)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "http://localhost/move/" + String.valueOf(move.getId())));
    }

    @Test
    public void testCreateMove_Player1_Won() throws Exception {
        long gameId = 101l;
        Player player = TestUtil.getPlayer("player1");
        CreateMoveDto createMoveDto = new CreateMoveDto(101l, 1, 1);

        Game game = TestUtil.getGame(gameId, GameStatus.IN_PROGRESS);
        given(gameService.getGame(gameId)).willReturn(game);
        given(playerService.getLoggedUser()).willReturn(player);
        Move move = new Move(102, game, createMoveDto.getBoardRow(), createMoveDto.getBoardColumn(), player, new Date());
        given(moveService.createMove(any(), any(), any())).willReturn(move);
        given(gameService.checkGameStatus(game)).willReturn(GameStatus.FIRST_PLAYER_WON);
        gameService.updateGameStatus(game, GameStatus.FIRST_PLAYER_WON);

        this.mockMvc.perform(post("/move/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createMoveDto)))
                .andExpect(status().isCreated());
    }
}
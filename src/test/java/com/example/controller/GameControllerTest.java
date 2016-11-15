package com.example.controller;

import com.example.common.TestUtil;
import com.example.domain.Game;
import com.example.domain.Player;
import com.example.dto.GameDto;
import com.example.enums.GameStatus;
import com.example.enums.Piece;
import com.example.service.IGameService;
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

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by rpayal on 14/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Mock
    private IGameService gameService;
    @Mock
    private IPlayerService playerService;

    @InjectMocks
    private GameController gameController;

    @Before
    public void setup() {
        mockMvc = standaloneSetup(gameController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testCreateNewGame() throws Exception {
        long gameId = 101l;
        Player player = TestUtil.getPlayer("player1");
        GameDto gameDto = new GameDto(101l, Piece.X);

        given(playerService.getLoggedUser()).willReturn(player);
        given(gameService.createNewGame(any(), any())).willReturn(TestUtil.getGame(gameId, GameStatus.NEW));

        this.mockMvc.perform(post("/game/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(gameDto)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "http://localhost/game/" + String.valueOf(gameId)));
    }

    @Test
    public void testGetGameStatus() throws Exception {
        long gameId = 101l;

        Game game = TestUtil.getGame(gameId, GameStatus.NEW);
        given(gameService.getGame(gameId)).willReturn(game);
        given(gameService.checkGameStatus(game)).willReturn(GameStatus.IN_PROGRESS);

        this.mockMvc.perform(get("/game/" + gameId +"/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gameStatus").value(GameStatus.IN_PROGRESS.name()));
    }
}
package com.example.controller;

import com.example.domain.Game;
import com.example.dto.GameDto;
import com.example.dto.GameStatusDto;
import com.example.enums.GameStatus;
import com.example.service.IGameService;
import com.example.service.IPlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by rpayal on 14/11/2016.
 */
@RestController
@RequestMapping("/game")
public class GameController {
    Logger LOGGER = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private IGameService gameService;
    @Autowired
    private IPlayerService playerService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Game> createNewGame(@RequestBody GameDto gameDto, UriComponentsBuilder ucBuilder) {
        Game game = gameService.createNewGame(playerService.getLoggedUser(), gameDto);
        LOGGER.info("Created new game with id: " + game.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/game/{id}").buildAndExpand(game.getId()).toUri());
        return new ResponseEntity<Game>(game, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{gameId}/status", method = RequestMethod.GET)
    public ResponseEntity<GameStatusDto> getGameStatus(@PathVariable Long gameId) {
        Game game = gameService.getGame(gameId);
        GameStatus gameStatus = gameService.checkGameStatus(game);
        LOGGER.info("Current game status: " + gameStatus);
        return new ResponseEntity<GameStatusDto>(new GameStatusDto(game.getId(), gameStatus), HttpStatus.OK);
    }
}

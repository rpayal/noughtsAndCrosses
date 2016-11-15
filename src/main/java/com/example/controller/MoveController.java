package com.example.controller;

import com.example.domain.Game;
import com.example.domain.Move;
import com.example.dto.CreateMoveDto;
import com.example.service.IGameService;
import com.example.service.IMoveService;
import com.example.service.IPlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by rpayal on 14/11/2016.
 */
@RestController
@RequestMapping("/move")
public class MoveController {
    Logger LOGGER = LoggerFactory.getLogger(MoveController.class);

    @Autowired
    private IMoveService moveService;
    @Autowired
    private IGameService gameService;
    @Autowired
    private IPlayerService playerService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Move> createMove(@RequestBody CreateMoveDto createMoveDto, UriComponentsBuilder ucBuilder) {
        LOGGER.info("Move to mark [{0}, {1}] for game ({3}):", createMoveDto.getBoardColumn(),
                createMoveDto.getBoardRow(), createMoveDto.getGameId());

        Game game = gameService.getGame(createMoveDto.getGameId());
        Move move = moveService.createMove(game, playerService.getLoggedUser(), createMoveDto);
        gameService.updateGameStatus(game, gameService.checkGameStatus(game));

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/move/{id}").buildAndExpand(move.getId()).toUri());

        return new ResponseEntity<Move>(move, headers, HttpStatus.CREATED);
    }
}

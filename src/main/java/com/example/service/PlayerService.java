package com.example.service;

import com.example.domain.Player;
import org.springframework.stereotype.Service;

/**
 * Created by rpayal on 14/11/2016.
 */
@Service
public class PlayerService implements IPlayerService {
    @Override
    public Player getLoggedUser() {
        // get logged in player from spring security context
        return new Player("player1", "player1@email.com", "player1");
    }
}

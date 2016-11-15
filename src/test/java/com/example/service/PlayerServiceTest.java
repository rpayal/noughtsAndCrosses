package com.example.service;

import com.example.domain.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rpayal on 14/11/2016.
 */
public class PlayerServiceTest {
    private PlayerService target;

    @Before
    public void setup() {
        target = new PlayerService();
    }

    @Test
    public void testGetLoggedUser() throws Exception {
        assertNotNull(target.getLoggedUser());
    }
}
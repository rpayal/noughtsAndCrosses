package com.example.service;

import com.example.common.TestUtil;
import com.example.domain.Move;
import com.example.domain.Position;
import com.example.dto.CreateMoveDto;
import com.example.enums.GameStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by rpayal on 14/11/2016.
 */
public class MoveServiceTest {
    private MoveService target;
    private Long gameId = 101l;

    @Before
    public void setup() {
        target = new MoveService();
    }

    @Test
    public void testCreateMove() throws Exception {
        Move resMove = target.createMove(TestUtil.getGame(101l, GameStatus.IN_PROGRESS),
                TestUtil.getPlayer("player1"), getCreateMoveDto());
        assertNotNull(resMove);
        assertEquals(resMove.getGame().getId(), gameId);
    }

    @Test
    public void testGetPlayerMovePositionsInGame() {
        List<Position> positions = target.getPlayerMovePositionsInGame(TestUtil.getGame(101l, GameStatus.IN_PROGRESS),
                TestUtil.getPlayer("player1"));
        assertNotNull(positions);
        assertEquals(positions.size(), 0);
    }

    @Test
    public void testGetFilledPositionsInGame() {
        List<Position> positions = target.getFilledPositionsInGame(TestUtil.getGame(101l, GameStatus.IN_PROGRESS));
        assertNotNull(positions);
        assertEquals(positions.size(), 0);
    }

    private CreateMoveDto getCreateMoveDto() {
        return new CreateMoveDto(gameId, 1, 1);
    }
}
package com.improving.uno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    @Test
    void play() {
        //ARRANGE
        var deck = new Deck();
        var g = new Game();


        //ACT
        g.play();

        //ASSERT
        assertEquals(true , g.getDeck().getDiscard().size() >0);

    }


}
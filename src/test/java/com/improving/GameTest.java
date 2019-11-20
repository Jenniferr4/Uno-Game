package com.improving;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {



    @Test
    void play_should_add_card_to_discard_pile_when_called() {
        //ARRANGE
        var deck = new Deck();
        var g = new Game();


        //ACT
        g.play();

        //ASSERT
        assertEquals(true , g.getDeck().getDiscard().size() >0);

    }


}
package com.improving;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {




    @Test
    void hand_should_initialize_with_7_cards() {
        //Arrange
        var game = new Game();
        var player = new Player(game, "Cortana");

        //Act
        var result = player.handSize();


                //Assert
                assertEquals(7, result);
    }

    @Test
    void hand_should_remove_7_cards_from_deck_when_draw() {
        //Arrange
        var game = new Game();
        var deck = new Deck();
        var player = new Player(game, "Cortana");

        //Act
        var draw = deck.getCards().size();

        //Assert
        assertEquals(112-7, draw);
    }

}
package com.improving.uno;

import com.improving.uno.players.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void hand_should_initialize_with_7_cards() {
        //Arrange
        var deck = new Deck();
        var player = new Player(deck, "Cortana");

        //Act
        var result = player.getHandCards().size();


                //Assert
                assertEquals(7, result);
    }

    @Test
    void hand_should_remove_x_cards_from_deck() {
        //Arrange
        var deck = new Deck();
        var player = new Player(deck, "Cortana");

        //Act
        var result = player.getHandCards().size();
        var draw = deck.getCards().size();

        //Assert
        assertEquals(112-7, draw);
    }

}
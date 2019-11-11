package com.improving.uno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void hand_should_initialize_with_x_cards() {
        //Arrange
        var deck = new Deck();
        var hand = new Hand(deck, 7);

        //Act
        var result = hand.getHandCards().size();

                //Assert
                assertEquals(7, result);
    }

    @Test
    void hand_should_remove_x_cards_from_deck() {
        //Arrange
        var deck = new Deck();
        var hand = new Hand(deck, 7);

        //Act
        var result = hand.getHandCards().size();
        var draw = deck.getCards().size();

        //Assert
        assertEquals(112-7, draw);
    }

}
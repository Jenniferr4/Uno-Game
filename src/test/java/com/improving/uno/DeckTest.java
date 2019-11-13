package com.improving.uno;

import com.improving.uno.Card;
import com.improving.uno.Deck;
import com.improving.uno.Hand;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void draw_should_return_a_card() {
        //Arrange
        var deck = new Deck();

        //Act
        var result = deck.draw().getClass();

        //Assert
        assertEquals(Card.class, result);
    }

    @Test
    void draw_should_remove_card_from_deck() {
        //Arrange
        var deck = new Deck();

        //Act
        var result = deck.draw();

        //Assert
        assertEquals(111, deck.getCards().size());
    }




}
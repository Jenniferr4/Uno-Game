package com.improving.uno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    @Test
    void takeTurn_should_finish_turn_when_none_are_playable_and_player_draws_card() {
        //Arrange
        var deck = new Deck();
        deck.getDiscard().add(new Card(Faces.Eight, Colors.Blue));
        var player = new Player(deck);
        player.getHand().getHandCards().clear();

        player.getHand().getHandCards().add(new Card(Faces.Three, Colors.Red));
        player.getHand().getHandCards().add(new Card(Faces.Two, Colors.Yellow));
        player.getHand().getHandCards().add(new Card(Faces.One, Colors.Yellow));
        player.getHand().getHandCards().add(new Card(Faces.Four, Colors.Yellow));
        player.getHand().getHandCards().add(new Card(Faces.Five, Colors.Yellow));
        player.getHand().getHandCards().add(new Card(Faces.Six, Colors.Yellow));
        player.getHand().getHandCards().add(new Card(Faces.Seven, Colors.Yellow));

        //Act
        player.takeTurn(deck);
        var playerHand = player.getHand().getHandCards().size();


        //Assert
        assertEquals(7+1 , playerHand);
    }

    @Test
    void takeTurn_should_add_top_card_to_discard_pile_of_deck() {
        //Arrange
        var deck = new Deck();
        var player = new Player(deck);

        //Act
        player.takeTurn(deck);

        //Assert
        assertEquals(1, deck.getDiscard().size());
    }

    @Test
    void takeTurn_should_remove_one_card_from_player_hand_if_playable() {
        //Arrange
        var deck = new Deck();
        deck.getDiscard().add(new Card(Faces.Three, Colors.Blue));
        var player = new Player(deck);
        player.getHand().getHandCards().clear();
        player.getHand().getHandCards().add(new Card(Faces.Three, Colors.Red));
        player.getHand().getHandCards().add(new Card(Faces.Two, Colors.Yellow));
        player.getHand().getHandCards().add(new Card(Faces.One, Colors.Yellow));
        player.getHand().getHandCards().add(new Card(Faces.Four, Colors.Yellow));
        player.getHand().getHandCards().add(new Card(Faces.Five, Colors.Yellow));
        player.getHand().getHandCards().add(new Card(Faces.Six, Colors.Yellow));
        player.getHand().getHandCards().add(new Card(Faces.Seven, Colors.Yellow));


        //Act
        player.takeTurn(deck);

        //Assert
        assertEquals(7-1, player.getHand().getHandCards().size());
    }




    @Test
    void isPlayable_should_return_true_when_colors_match() {
            //Arrange
            var deck = new Deck();
            var addedCard = deck.getDiscard().add(new Card(Faces.One, Colors.Red));
            var card = new Card(Faces.One, Colors.Red);

            //Act
            var result = Player.isPlayable(deck, card);

            //Assert
            assertEquals(true, result);
    }

    @Test
    void isPlayable_should_return_true_when_faces_match() {
        //Arrange
        var deck = new Deck();
        var addedCard = deck.getDiscard().add(new Card(Faces.One, Colors.Blue));
        var card = new Card(Faces.One, Colors.Red);


        //Act
        var result = Player.isPlayable(deck, card);

        //Assert
        assertEquals(true, result);
    }

    @Test
    void isPlayable_should_return_true_when_wild() {
        //Arrange
        var deck = new Deck();
        var addedCard = deck.getDiscard().add(new Card(Faces.One, Colors.Red));
        var card = new Card(Faces.Wild, null);


        //Act
        var result = Player.isPlayable(deck, card);

        //Assert
        assertEquals(true, result);
    }

    @Test
    void isPlayable_should_return_true_when_draw_4_wild() {
        //Arrange
        var deck = new Deck();
        deck.getDiscard().add(new Card(Faces.One, Colors.Red));
        var card = new Card(Faces.WildDrawFour, null);


        //Act
        var result = Player.isPlayable(deck, card);

        //Assert
        assertEquals(true, result);
    }

    @Test
    void isPlayable_should_return_FALSE_when_card_is_not_a_match() {
        //Arrange
        var deck = new Deck();
        deck.getDiscard().add(new Card(Faces.One, Colors.Red));
        var card = new Card(Faces.Three, Colors.Blue);


        //Act
        var result = Player.isPlayable(deck, card);

        //Assert
        assertEquals(false, result);
    }


}
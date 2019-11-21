package com.improving;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    @Test
    void takeTurn_should_finish_turn_when_none_are_playable_and_player_draws_card() {
        //Arrange
        List<Card> handCards = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int playersNum = scan.nextInt();
        Game game = new Game(playersNum);
        var deck = new Deck();
        deck.getDiscard().add(new Card(Faces.Eight, Colors.Blue));
        var cortana = new Player(handCards, 1);
        cortana.getHandCards().clear();

        cortana.getHandCards().add(new Card(Faces.Three, Colors.Red));
        cortana.getHandCards().add(new Card(Faces.Two, Colors.Yellow));
        cortana.getHandCards().add(new Card(Faces.One, Colors.Yellow));
        cortana.getHandCards().add(new Card(Faces.Four, Colors.Yellow));
        cortana.getHandCards().add(new Card(Faces.Five, Colors.Yellow));
        cortana.getHandCards().add(new Card(Faces.Six, Colors.Yellow));
        cortana.getHandCards().add(new Card(Faces.Seven, Colors.Yellow));

        //Act
        cortana.takeTurn(game);
        var playerHand = cortana.getHandCards().size();


        //Assert
        assertEquals(7 + 1, playerHand);
    }

    @Test
    void takeTurn_should_remove_one_card_from_player_hand_if_playable() {
        //Arrange
        List<Card> handCards = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int playersNum = scan.nextInt();
        Game game = new Game(playersNum);
        var deck = new Deck();
        deck.getDiscard().add(new Card(Faces.Three, Colors.Blue));
        var player = new Player(handCards, 1);


        player.getHandCards().clear();
        player.getHandCards().add(new Card(Faces.Three, Colors.Red));
        player.getHandCards().add(new Card(Faces.Two, Colors.Yellow));
        player.getHandCards().add(new Card(Faces.One, Colors.Yellow));
        player.getHandCards().add(new Card(Faces.Four, Colors.Yellow));
        player.getHandCards().add(new Card(Faces.Five, Colors.Yellow));
        player.getHandCards().add(new Card(Faces.Six, Colors.Yellow));
        player.getHandCards().add(new Card(Faces.Seven, Colors.Yellow));


        //Act
        player.takeTurn(game);

        //Assert
        assertEquals(7 - 1, player.getHandCards().size());
    }


    @Test
    void isPlayable_should_return_true_when_colors_match() {
        //Arrange
        List<Card> handCards = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int playersNum = scan.nextInt();
        Game game = new Game(playersNum);
        var deck = new Deck();
        var player = new Player(handCards, 1);
        var addedCard = deck.getDiscard().add(new Card(Faces.One, Colors.Red));
        var card = new Card(Faces.One, Colors.Red);

        //Act
        var result = game.isPlayable(card);

        //Assert
        assertEquals(true, result);
    }

    @Test
    void isPlayable_should_return_true_when_faces_match() {
        //Arrange
        List<Card> handCards = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int playersNum = scan.nextInt();
        Game game = new Game(playersNum);
        var deck = new Deck();
        var player = new Player(handCards, 1);
        var addedCard = deck.getDiscard().add(new Card(Faces.One, Colors.Blue));
        var card = new Card(Faces.One, Colors.Red);


        //Act
        var result = game.isPlayable(card);

        //Assert
        assertEquals(true, result);
    }

    @Test
    void isPlayable_should_return_true_when_wild() {
        //Arrange
        List<Card> handCards = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int playersNum = scan.nextInt();
        Game game = new Game(playersNum);
        var deck = new Deck();
        var player = new Player(handCards, 1);
        var addedCard = deck.getDiscard().add(new Card(Faces.One, Colors.Red));
        var card = new Card(Faces.WILD, null);


        //Act
        var result = game.isPlayable(card);

        //Assert
        assertEquals(true, result);
    }

    @Test
    void isPlayable_should_return_true_when_draw_4_wild() {
        //Arrange
        List<Card> handCards = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int playersNum = scan.nextInt();
        Game game = new Game(playersNum);
        var deck = new Deck();
        var player = new Player(handCards, 1);
        deck.getDiscard().add(new Card(Faces.One, Colors.Red));
        var card = new Card(Faces.WILD_DrawFour, null);


        //Act
        var result = game.isPlayable(card);

        //Assert
        assertEquals(true, result);
    }

    @Test
    void isPlayable_should_return_FALSE_when_card_is_not_a_match() {
        //Arrange
        List<Card> handCards = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int playersNum = scan.nextInt();
        Game game = new Game(playersNum);
        var deck = new Deck();
        var player = new Player(handCards, 1);
        deck.getDiscard().add(new Card(Faces.One, Colors.Red));
        var card = new Card(Faces.Three, Colors.Blue);


        //Act
        var result = game.isPlayable(card);

        //Assert
        assertEquals(false, result);
    }


}
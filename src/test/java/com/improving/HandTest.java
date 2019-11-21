package com.improving;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {




    @Test
    void hand_should_initialize_with_7_cards() {
        //Arrange
        List<Card> handCards = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int playersNum = scan.nextInt();
        Game game = new Game(playersNum);
        var player = new Player(handCards, 1);

        //Act
        var result = player.handSize();


                //Assert
                assertEquals(7, result);
    }

    @Test
    void hand_should_remove_7_cards_from_deck_when_draw() {
        //Arrange

        Scanner scan = new Scanner(System.in);
        int playersNum = scan.nextInt();
        Game game = new Game(playersNum);
        var deck = new Deck();


        //Act
        var draw = deck.getCards().size();

        //Assert
        assertEquals(112-7, draw);
    }

}
package com.improving;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {



    @Test
    void play_should_add_card_to_discard_pile_when_called() {
        //ARRANGE
        Scanner scan = new Scanner(System.in);
        int playersNum = scan.nextInt();

        var g = new Game(playersNum);


        //ACT
        g.play();

        //ASSERT
        assertEquals(true , g.getDeck().getDiscard().size() >0);

    }


}
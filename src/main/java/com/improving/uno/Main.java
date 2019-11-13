package com.improving.uno;

import java.util.ArrayList;
import java.util.List;
//TODO: make sure player wins game
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player(deck);

        Game g = new Game(deck, player);
        g.play();


    }
}
//    var deck = new Deck();
//    var hand = new Hand(deck, 7);
//        deck.draw();
//
//
//                System.out.println(hand.getHandCards().toString());
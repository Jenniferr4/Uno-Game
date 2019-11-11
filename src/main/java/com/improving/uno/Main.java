package com.improving.uno;

public class Main {
    public static void main(String[] args) {
        var deck = new Deck();
        var hand = new Hand(deck, 7);
        deck.draw();


        System.out.println(hand.getHandCards().toString());

    }
}

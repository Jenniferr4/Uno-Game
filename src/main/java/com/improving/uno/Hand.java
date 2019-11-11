package com.improving.uno;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> hand;

    public Hand(Deck deck, int startingHand) {
        hand = new ArrayList<>();
        for (int i = 0; i < startingHand; i++) {
            hand.add(deck.draw());
        }

    }

    public List<Card> getHand() {
        return hand;
    }
}

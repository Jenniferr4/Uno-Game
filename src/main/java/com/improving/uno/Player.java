package com.improving.uno;

import java.util.List;

public class Player {
    private Hand hand;

    public Player(Deck deck) {
        this.hand = new Hand(deck, 7);
    }

    public static boolean isPlayable(Deck deck, Card card) {
        if (deck.getTopDiscardCard().getColor() == card.getColor() ||
                deck.getTopDiscardCard().getFace() == card.getFace() ||
                card.getFace() == Faces.Wild ||
                card.getFace() == Faces.WildDrawFour) {
            return true;
        }
        return false;
    }

    public void takeTurn(Deck deck) {
        // TODO: Switch to fori to avoid ConcurrentModificationException
        for (Card card : hand.getHandCards()) {
            if (isPlayable(deck, card)) {
                deck.getDiscard().add(card);
                getHand().getHandCards().remove(card);
                break; //TODO: check this again ....
            }
        }
    }


    public Hand getHand() {
        return hand;
    }
}

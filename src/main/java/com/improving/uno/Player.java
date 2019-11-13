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
        for (Card card : hand.getHandCards()) {
            if (isPlayable(deck, card)) {
                playCard(deck, card);
                if (hand.getHandCards().size() == 1) {
                    System.out.println(
                            "\n   -------------\n" +
                            "-------Uno!------"+
                            "\n   -------------\n"
                    );
                }
                return;
            }
        }var pDrewCard = deck.draw();

        hand.getHandCards().add(pDrewCard);

        System.out.println("Player drew a "+ pDrewCard );
        System.out.println("Player has finished turn \n");
    }

    private void playCard(Deck deck, Card card) {
        deck.getDiscard().add(card);
        System.out.println("Player1 played " + card );
        getHand().getHandCards().remove(card);
    }


    public Hand getHand() {
        return hand;
    }
}

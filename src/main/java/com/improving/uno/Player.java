package com.improving.uno;

import java.util.ArrayList;
import java.util.List;

import static com.improving.uno.Game.isPlayable;

public class Player {
    public static int takeTurnCount =1;
    private final List<Card> handCards;


    public Player(Deck deck) {
        handCards = new ArrayList<>();
        initializeSevenCardsToHand(deck, 7);
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    private void initializeSevenCardsToHand(Deck deck, int startingHand) {
        for (int i = 0; i < startingHand; i++) {
            handCards.add(deck.draw());
        }
    }




    public void takeTurn(Deck deck) {
       var ttc = takeTurnCount++;
        for (Card card : handCards) {
            if (isPlayable(deck, card)) {
                playCard(deck, card);
                System.out.println("==Human has finished turn ("+ ttc+ ") \n");
                if (handCards.size() == 1) {
                    System.out.println(
                            "\n   -------------\n" +
                            "-------Uno!------"+
                            "\n   -------------\n"
                    );
                }
                return;
            }
        }var pDrewCard = deck.draw();

        handCards.add(pDrewCard);

        System.out.println("Human drew a "+ pDrewCard );
        System.out.println("==Human has finished turn ("+ ttc+ ") \n");
    }

    private void playCard(Deck deck, Card card) {
        deck.getDiscard().add(card);
        System.out.println("Human played " + card );
        handCards.remove(card);
    }


}

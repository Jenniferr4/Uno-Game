package com.improving;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Deck implements IDeck {
    private final LinkedList<Card> cards = new LinkedList<>();
    private final LinkedList<Card> discard = new LinkedList<>();
    private final Random random = new Random();


    public Deck() {
        for (var color : Colors.values()) {
            for (var face : Faces.values()) {
                if (face.getValue() == 50) {
                    cards.add(new Card(face, null));
                } else {
                    cards.add(new Card(face, color));
                    cards.add(new Card(face, color));
                }

            }
        }
        Collections.shuffle(cards);
    }


    public Card draw() {
        if (cards.size() == 0) {
            recycleDeck();
        }
        Card card = cards.getLast();
        cards.remove(card);
        return card;
    }

    private void recycleDeck() {
        System.out.println("\n.....REFEREE IS RECYCLING DECK.....\n" +
                ".....DrawPile now has " + getDiscardPileSize());
        var referee = getTopDiscardCard();
        discard.remove(getTopDiscardCard());
        cards.addAll(discard);
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        discard.clear();
        discard.add(referee);
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(discard);
    }

    @Override
    public LinkedList<Card> getDiscard() {
        return discard;
    }

    @Override
    public int getDiscardPileSize() {
        return discard.size();
    }

    public Card getTopDiscardCard() {
        return discard.get(this.discard.size() - 1);
    }


}

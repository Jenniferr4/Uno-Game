package com.improving;

import java.util.LinkedList;

public interface iDeck {
    LinkedList<Card> getDiscard();

    int getDiscardPileSize();
}

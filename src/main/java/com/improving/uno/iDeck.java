package com.improving.uno;

import java.util.ArrayList;
import java.util.LinkedList;

public interface iDeck {
    LinkedList<Card> getDiscard();

    int getDiscardPileSize();
}

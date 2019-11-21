package com.improving;

import java.util.LinkedList;

public interface IDeck {
    LinkedList<Card> getDiscard();

    int getDiscardPileSize();

}

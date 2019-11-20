package com.improving;

import com.improving.Game;
import com.improving.Card;

public interface iPlayer {

    Card draw(Game game);

    int handSize();

    void takeTurn(Game game);


}

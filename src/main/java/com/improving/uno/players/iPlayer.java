package com.improving.uno.players;

import com.improving.uno.Card;
import com.improving.uno.Game;

public interface iPlayer {

    Card draw(Game game);

    int handSize();

    void takeTurn(Game game);


}

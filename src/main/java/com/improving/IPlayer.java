package com.improving;

import com.improving.Game;
import com.improving.Card;

import java.util.List;

public interface IPlayer extends IPlayerInfo{
    void takeTurn(IGame game);
    Card draw(IGame game);
    void newHand(List<Card>cards);
}

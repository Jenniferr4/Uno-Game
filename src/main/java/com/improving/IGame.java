package com.improving;

import java.util.List;
import java.util.Optional;

public interface IGame {
    void playCard(Card card, Optional<Colors> color);
    boolean isPlayable(Card card);
    void play();
    Card draw();
    List<IPlayerInfo> getPlayerInfo();
    IPlayer getNextPlayer();
    IPlayer getPreviousPlayer();
    IPlayer getNextNextPlayer();
    IDeck getDeckInfo();

}

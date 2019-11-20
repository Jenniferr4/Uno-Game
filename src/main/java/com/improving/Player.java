package com.improving;

import java.util.ArrayList;
import java.util.List;


public class Player implements iPlayer {
    public static int takeTurnCount = 1;
    private final List<Card> handCards;
    private final String name;
    private static int gameOverUno = 0;


    public Player(Game game, String name) {
        handCards = new ArrayList<>();
        initializeSevenCardsToHand(game, 7);
        this.name = name;
    }


    @Override
    public int handSize() {
        return handCards.size();
    }

    private void initializeSevenCardsToHand(Game game, int startingHand) {
        for (int i = 0; i < startingHand; i++) {
            handCards.add(draw(game));
        }
    }


    public static int getTakeTurnCount() {
        return takeTurnCount;
    }

    @Override
    public void takeTurn(Game game) {
        var tTurnCount = takeTurnCount++;
        for (Card card : handCards) {
            if (game.isPlayable(card)) {
                game.playCard(card);
                return;
            }
        }
        Card card = draw(game);
        handCards.add(card);
        if (game.isPlayable(card)) {
            game.playCard(card);
            System.out.println("after drawing from deck."  );
            return;
        }


    }

    @Override
    public Card draw(Game game) {
        Card card = game.draw();
        return card;
    }


    public String getName() {
        return name;
    }


    public List<Card> getHandCards() {
        return handCards;
    }
}

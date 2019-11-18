package com.improving.uno.players;

import com.improving.uno.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Player implements iPlayer {
    public static int takeTurnCount = 1;
    private final List<Card> handCards;
    private final String name;
    private static int gameOverUno = 0;


    public Player(Game game,  String name) {
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
        var ttc = takeTurnCount++;
        for (Card card : handCards) {
            if (game.isPlayable(card)) {
                game.playCard(card);
                System.out.print("and has FINISHED turn (" + ttc + ")\n");
                if (handCards.size() == 1) {
                    printUNO();
                }
                return;
            }
        }
        Card card = draw(game);
        handCards.add(card);
        printCardDrawnNTurnAmount(ttc, card);
        if (game.isPlayable(card)){
            game.playCard(card);
            return;
        }

    }

    @Override
    public Card draw(Game game) {
        Card card = game.draw();
        return card;
    }

    private void printUNO() {
        System.out.println(
                "     -------------\n" +
                        "   -------Uno!------" +
                        "\n     -------------\n");
    }

    private void printCardDrawnNTurnAmount(int ttc, Card pDrewCard) {
        System.out.println(getName() + " drew a card and has FINISHED turn (" + ttc + "). ");
    }



    public String getName() {
        return name;
    }


    public List<Card> getHandCards() {
        return handCards;
    }
}

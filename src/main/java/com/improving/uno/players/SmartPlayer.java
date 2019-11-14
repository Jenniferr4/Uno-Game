package com.improving.uno.players;

import com.improving.uno.Card;
import com.improving.uno.Colors;
import com.improving.uno.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.improving.uno.Game.isPlayable;

public class SmartPlayer implements iPlayer {
    public static int takeTurnCount = 1;
    private final List<Card> handCards;
    private final String name;
    private static int gameOverUno = 0;


    public SmartPlayer(Deck deck, String name) {
        handCards = new ArrayList<>();
        initializeSevenCardsToHand(deck, 7);
        this.name = name;
    }



    public List<Card> getHandCards() {
        return handCards;
    }

    private void initializeSevenCardsToHand(Deck deck, int startingHand) {
        for (int i = 0; i < startingHand; i++) {
            handCards.add(deck.draw());
        }
    }


    public static int getTakeTurnCount() {
        return takeTurnCount;
    }

    @Override
    public void takeTurn(Deck deck) {
        var ttc = takeTurnCount++;
        for (Card card : handCards) {
            if (isPlayable(deck, card)) {
                playCard(deck, card);
                if (deck.getTopDiscardCard().getColor() == null){
                    deck.getTopDiscardCard().setColor(Colors.values()[new Random().nextInt(4)]);
                    System.out.print("<--> " +card.getColor().toString() );
                }
                System.out.print(", and has finished turn (" + ttc + ")\n");
                if (handCards.size() == 1) {
                    printUNO();
                }
                return;

            }
        }
        //TODO: game over if player won else draw
        var pDrewCard = deck.draw();
        handCards.add(pDrewCard);
        printCardDrawnNTurnAmount(ttc, pDrewCard);
        if (isPlayable(deck, pDrewCard)){
            playCard(deck, pDrewCard);
        }

    }

    private void printUNO() {
        System.out.println(
                "\n   -------------\n" +
                        "-------Uno!------" +
                        "\n   -------------\n");
    }

    private void printCardDrawnNTurnAmount(int ttc, Card pDrewCard) {
        System.out.println(getName() + " drew a " + pDrewCard + " and has finished turn (" + ttc + "). ");
    }

    private void playCard(Deck deck, Card card) {
        deck.getDiscard().add(card);
        System.out.print("" + getName() + " played " + card+" ");
        handCards.remove(card);
    }

    public String getName() {
        return name;
    }
}

package com.improving.uno;

import com.improving.uno.players.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements iGame {
    private static Deck deck;
    private List<Player> players = new ArrayList<>();
    private Card card;
    private static int amountOfTurnsInGame = 0;
    int numOfPlayers;
    int turnIndex = 0;
    int currentPlayer;
    int turnDirection = 1;


    public Game() {
        this.deck = new Deck();
        this.players.add(new Player(this, "Jen"));
        this.players.add(new Player(this, "Emma"));
        this.players.add(new Player(this, "Grand"));
        numOfPlayers = players.size();
    }

    @Override
    public void play() {
        deck.getDiscard().add(deck.draw());
        ifStartingCardIsWild_AssignColor();
        printStartingGameInfo();
        while (gameInProgress() == true) {
            if (turnIndex < 0) {
                turnIndex = (turnIndex + numOfPlayers) % numOfPlayers;
            }
            currentPlayer = turnIndex % numOfPlayers;
            players.get(currentPlayer).takeTurn(this);

            printPlayingInfo();
            amountOfTurnsInGame++; //counts how many turns have been taken by every player
            if (specialCard() == true) {
                executeSpecialCard();
            }
            turnIndex = turnIndex + turnDirection;

        }
        System.out.println("Total Number of Turns: " + amountOfTurnsInGame);

    }

    public void playCard(Card card) {
        if (card.getColor() == null) {
            card.setColor(Colors.values()[new Random().nextInt(4)]);
            System.out.print("<--> " + card.getColor().toString() + " " );
        }
        deck.getDiscard().add(card);
        System.out.print("" + players.get(currentPlayer).getName() + " played " + card +" ");
        players.get(currentPlayer).getHandCards().remove(card);

    }


    public boolean specialCard() {
        if (deck.getTopDiscardCard().getFace() == Faces.Reverse
                || deck.getTopDiscardCard().getFace() == Faces.Skip
                || deck.getTopDiscardCard().getFace() == Faces.WILD
                || deck.getTopDiscardCard().getFace() == Faces.WILD_DrawFour
                || deck.getTopDiscardCard().getFace() == Faces.DrawTwo) {
            return true;
        }
        return false;
    }

    public void executeSpecialCard() {
        if (deck.getTopDiscardCard().getFace() == Faces.Reverse) {
            turnDirection = turnDirection * -1;
            System.out.println("<-- TURNS HAS BEEN REVERSED -->\n");
        }
        if (deck.getTopDiscardCard().getFace() == Faces.Skip) {
            System.out.println("\n<-- " +
                    players.get((turnIndex+numOfPlayers + turnDirection) % numOfPlayers).getName()
                    + " HAS BEEN SKIPPED. -->\n");
            turnIndex = turnIndex + turnDirection;
        }
        if (deck.getTopDiscardCard().getFace() == Faces.WILD_DrawFour) {
            var playerDraw = players.get((turnIndex +numOfPlayers+ turnDirection) % numOfPlayers);
            playerDraw.draw(this);
            playerDraw.draw(this);
            playerDraw.draw(this);
            playerDraw.draw(this);
            turnIndex = turnIndex + turnDirection;
            System.out.println("\n<---" + playerDraw.getName() +
                    " WAS FORCED TO DRAW FOUR CARDS" +
                    " AND HAS BEEN SKIPPED. ---> \n");

        }
        if (deck.getTopDiscardCard().getFace() == Faces.DrawTwo) {
            var playerDraw = players.get((turnIndex + numOfPlayers+ turnDirection) % numOfPlayers);
            playerDraw.draw(this);
            playerDraw.draw(this);
            turnIndex = turnIndex + turnDirection;
            System.out.println("\n<---" + playerDraw.getName() +
                    " WAS FORCED TO DRAW TWO CARDS" +
                    " AND HAS BEEN SKIPPED. ---> \n");

        }


    }


    public boolean gameInProgress() {
        for (Player player : players) {
            if (player.handSize() == 0) {
                printGOverNWinner();
                return false;
            }
        }
        return true;
    }


    private void printGOverNWinner() {
        System.out.println(
                "=====Game Over=====\n" + " " +
                        winnerWinner() + " has won!");
    }

    @Override
    public boolean isPlayable(Card card) {
        if (deck.getTopDiscardCard().getColor() == card.getColor() ||
                deck.getTopDiscardCard().getFace() == card.getFace() ||
                card.getFace() == Faces.WILD ||
                card.getFace() == Faces.WILD_DrawFour) {
            return true;
        }
        return false;
    }

    public Card draw() {
        return deck.draw();
    }


    public String winnerWinner() {
        for (Player player : players) {
            if (player.handSize() == 0) {
                return player.getName();
            }
        }
        return "NOBODY WON >:)";
    }

    private void printPlayingInfo() {
        System.out.println("Player now has " + players.get(currentPlayer).handSize() + " cards.");
        System.out.println(">>DISCARD pile size: " + deck.getDiscard().size() + " " +
                "||  >>DRAW pile size: " + deck.getCards().size() + "\n");
    }

    private void ifStartingCardIsWild_AssignColor() {
        if (deck.getTopDiscardCard().getColor() == null) {
            deck.getTopDiscardCard().setColor(Colors.values()[new Random().nextInt(4)]);
        }
    }

    private void printStartingGameInfo() {
        System.out.println("        NUMBER OF PLAYERS: " + players.size());
        System.out.println("    STARTING CARD: " + deck.getDiscard().getLast());
        System.out.println(">>DISCARD pile size: " + deck.getDiscard().size() + " " +
                "||  >>DRAW pile size: " + deck.getCards().size() + "");
        System.out.print("   ---------------------------\n");
    }

    ////////////////Getters & Setters ///////////

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public List<Player> getPlayer() {
        return players;
    }


}

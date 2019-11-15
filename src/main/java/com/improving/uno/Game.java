package com.improving.uno;

import com.improving.uno.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private Deck deck;
    private List<Player> players = new ArrayList<>();
    private Card card;
    private static int amountOfTurnsInGame = 0;
    int numOfPlayers;
    int turnIndex = 0;
    int currentPlayer;




    public Game() {
        this.deck = new Deck();
        this.players.add(new Player(deck, "Jennifer"));
        this.players.add(new Player(deck, "Emma"));
        this.players.add(new Player(deck, "Granados"));
        numOfPlayers = players.size();
    }


    public void play() {
        deck.getDiscard().add(deck.draw());
        if (deck.getTopDiscardCard().getColor() == null) {
            deck.getTopDiscardCard().setColor(Colors.values()[new Random().nextInt(4)]);
        }
        System.out.println("        NUMBER OF PLAYERS: " + players.size());
        System.out.println("    STARTING CARD: " + deck.getDiscard().getLast());
        System.out.println(">>DISCARD pile size: " + deck.getDiscard().size() + " " +
                "||  >>DRAW pile size: " + deck.getCards().size() + "");
        System.out.print("   ---------------------------\n");

        while (gameInProgress() == true) {
            if(turnIndex <=0){
                currentPlayer = turnIndex + numOfPlayers;
            }
            currentPlayer = turnIndex%numOfPlayers;

            players.get(currentPlayer).takeTurn(this);
            System.out.println(">>DISCARD pile size: " + deck.getDiscard().size() + " " +
                    "||  >>DRAW pile size: " + deck.getCards().size() + "\n");
            amountOfTurnsInGame++; //counts how many turns have been taken by every player
            players.get(currentPlayer).handSize();
            if (players.get(currentPlayer).handSize() == 0) {
                System.out.println("Total Number of Turns: " + amountOfTurnsInGame);
            }
            turnIndex++;


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


    public static boolean isPlayable(Deck deck, Card card) {
        if (deck.getTopDiscardCard().getColor() == card.getColor() ||
                deck.getTopDiscardCard().getFace() == card.getFace() ||
                card.getFace() == Faces.WILD ||
                card.getFace() == Faces.WILD_DrawFour) {
            return true;
        }
        return false;
    }


    public String winnerWinner() {
        for (Player player : players) {
            if (player.handSize() == 0) {
                return player.getName();
            }
        }
        return "NOBODY WON >:)";
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

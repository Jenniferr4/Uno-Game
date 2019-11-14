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


    public Game() {
        this.deck = new Deck();
        this.players.add(new Player(deck, "Jennifer"));
        this.players.add(new Player(deck, "Emma"));
        this.players.add(new Player(deck, "Granados"));
    }


    public void play() {
        deck.getDiscard().add(deck.draw());
        if (deck.getTopDiscardCard().getColor() == null){
            deck.getTopDiscardCard().setColor(Colors.values()[new Random().nextInt(4)]);
        }
        System.out.println("        NUMBER OF PLAYERS: " + players.size());
        System.out.println("    STARTING CARD: " + deck.getDiscard().getLast() + "\n");

        while (gameInProgress() == true) {
            for (Player player : players) {
                player.takeTurn(deck);
                System.out.println(">>>>>>>>>>>>>DISCARD_SIZE: "+deck.getDiscard().size());
                System.out.println(">>>>>PLAY_DECK_SIZE: " + deck.getCards().size());
                amountOfTurnsInGame++;
                printPlayerHandStatus(player);
                if (player.getHandCards().size() == 0){
                    System.out.println("Total Number of Turns: "+amountOfTurnsInGame);
                    break;
                }

            }
        }

    }

    public boolean gameInProgress() {
        for (Player player : players) {
            if (getHandSize(player) == 0) {
                printGOverNWinner();
                return false;
            }
        }
        return true;
    }


    private void printGOverNWinner() {
        System.out.println(
                "=====Game Over=====\n" +
                        winnerWinner() + " has won");
    }

    private void printPlayerHandStatus(Player player) {
        System.out.println(""+player.getName() + "'s " + getHandSize(player) +
                " cards are: \n" + viewPlayersHand(player) + "\n");


    }

    private String viewPlayersHand(Player player) {
        return player.getHandCards().toString();
    }

    private int getHandSize(Player player) {
        return player.getHandCards().size();
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
            if (player.getHandCards().size() == 0) {
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

package com.improving.uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private Deck deck;
    private List<Player> players = new ArrayList<>();
    private Card card;


    public Game(Deck deck, Player player) {
        this.deck = new Deck();
        this.players.add(new Player(deck));
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public List<Player> getPlayer() {
        return players;
    }


    public void play() {

        deck.getDiscard().add(deck.draw());
        System.out.println("STARTING CARD: " + deck.getDiscard().getLast() +"\n");
        while (gameInProgress() == true){
            players.get(0).takeTurn(deck);

        }
    }

    public boolean gameInProgress(){
        for (Player player : players){
            if (getHandSize(player) != 0){
                System.out.println(
                        "Player1 has "+
                                getHandSize(player) +
                        " cards in hand: \n" +
                                viewPlayersHand(player) +
                        "\n");

                return true;
            }
        }
        System.out.println(
                "\n=====Game Over=====\n" +
                "    Player1 has won");
        System.out.println();
        return false;
    }

    private String viewPlayersHand(Player player) {
        return player.getHandCards().toString();
    }

    private int getHandSize(Player player) {
        return player.getHandCards().size();
    }


}

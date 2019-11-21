package com.improving;

import java.awt.*;
import java.util.List;
import java.util.Optional;


public class Player implements IPlayer {
    public static int takeTurnCount = 1;
    private final List<Card> handCards;
    private static int gameOverUno = 0;
    int id = 0;
    Colors mostCommonColor;
    int yellowCommon = 1;
    int blueCommon = 1;
    int redCommon = 1;
    int greenCommon = 1;


    public Player(List<Card> handCards, int id) {
        this.handCards = handCards;
        this.id = id++;
    }


    @Override
    public int handSize() {
        return handCards.size();
    }

    public void newHand(List<Card> cards) {
        this.handCards.clear();
        this.getHandCards().addAll(cards);
    }

    public static int getTakeTurnCount() {
        return takeTurnCount;
    }

    @Override
    public void takeTurn(IGame game) {
        takeTurnCount++;
        for (Card card : handCards) {
            checkTheColorAmountInHand(card);
            if (game.isPlayable(card)) {
                if (game.getNextPlayer().handSize() <=1 ){
                    smartMove_MakeNextPlayerDrawIfUno(game, card);
                }else
                System.out.println("Player-" + getId() + " played a " + card + " from hand.");
                playSmartColorCard(game);
                return;
            }
        }
        Card cardDrawn = draw(game);
        System.out.println("Player-" + getId() + " drew a card ");
        handCards.add(cardDrawn);
        if (game.isPlayable(cardDrawn)) {
            System.out.println("and decided to play it. --> " + cardDrawn);
            playSmartColorCard(game);
            return;
        }


    }

    public void setMostCommonColor(Colors mostCommonColor) {
        this.mostCommonColor = mostCommonColor;
    }

    public Colors choseWildColor(IGame game, Card card){
        if (yellowIsCommonColor() == true) {
            System.out.println(handCards);
            mostCommonColor = Colors.Yellow;
            game.playCard(card, Optional.of(mostCommonColor));
        } else if (redIsCommonColor() == true) {
            mostCommonColor = Colors.Red;
            game.playCard(card, Optional.of(mostCommonColor));
        } else if (greenIsCommonColor() == true) {
            mostCommonColor = Colors.Green;
            game.playCard(card, Optional.of(mostCommonColor));
        } else if (blueIsCommonColor() == true) {
            mostCommonColor = Colors.Blue;
            game.playCard(card, Optional.of(mostCommonColor));
        }
        return mostCommonColor;
    }

    public Colors getMostCommonColor() {
        return mostCommonColor;
    }


    public void playSmartColorCard(IGame game) {
        for (Card card : handCards) {
            if (yellowIsCommonColor() == true) {
                mostCommonColor = Colors.Yellow;
                game.playCard(card, Optional.of(mostCommonColor));
            } else if (redIsCommonColor() == true) {
                mostCommonColor = Colors.Red;
                game.playCard(card, Optional.of(mostCommonColor));
            } else if (greenIsCommonColor() == true) {
                mostCommonColor = Colors.Green;
                game.playCard(card, Optional.of(mostCommonColor));
            } else if (blueIsCommonColor() == true) {
                mostCommonColor = Colors.Blue;
                game.playCard(card, Optional.of(mostCommonColor));
            }
            return;
        }
        return;
    }

    private void smartMove_MakeNextPlayerDrawIfUno(IGame game, Card card) {
        if (handCards.contains(Faces.DrawTwo) || handCards.contains(Faces.WILD_DrawFour)) {
            game.playCard(card, Optional.of(choseWildColor(game, card)));
        }
    }

    public boolean yellowIsCommonColor() {
        if (yellowCommon >= redCommon && yellowCommon >= blueCommon && yellowCommon >= greenCommon) {
            return true;
        }
        return false;
    }

    public boolean redIsCommonColor() {
        if (redCommon >= yellowCommon && redCommon >= blueCommon && redCommon >= greenCommon) {
            return true;
        }
        return false;
    }

    public boolean greenIsCommonColor() {
        if (greenCommon >= yellowCommon && greenCommon >= blueCommon && greenCommon >= redCommon) {
            return true;
        }
        return false;
    }

    public boolean blueIsCommonColor() {
        if (blueCommon >= yellowCommon && blueCommon >= redCommon && blueCommon >= greenCommon) {
            return true;
        }
        return false;
    }

    private void checkTheColorAmountInHand(Card card) {
        if (card.getColor() == Colors.Yellow) {
            yellowCommon++;
        }
        if (card.getColor() == Colors.Red) {
            redCommon++;
        }
        if (card.getColor() == Colors.Blue) {
            blueCommon++;
        }
        if (card.getColor() == Colors.Yellow) {
            yellowCommon++;
        }
    }

    @Override
    public Card draw(IGame game) {
        Card card = game.draw();
        return card;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Card> getHandCards() {
        return handCards;
    }
}

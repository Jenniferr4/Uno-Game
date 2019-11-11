package com.improving.uno;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private final List<Card> cards = new ArrayList<>();
    private final List<Card> discard = new ArrayList<>();
    private final Random random = new Random();


    public Deck(){
        for(var color : Colors.values()){
            for(var face : Faces.values()){
                if(face.getValue() == 50 ){
                    cards.add(new Card(face, null));
                }else{
                    cards.add(new Card(face, color));
                    cards.add(new Card(face, color));
                }

            }
        }
    }

    public Card draw(){
        var randomIndex = random.nextInt(cards.size());
        var card = cards.get(randomIndex);
        cards.remove(randomIndex);
        return card;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle(){
        Collections.shuffle(discard);
    }

    public List<Card> getDiscard() {
        return discard;
    }

    public Card getTopDiscardCard(){
        return discard.get(this.discard.size()-1);
    }

}

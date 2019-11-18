package io.github.guilhermedelemos.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;
    private int originalSize;

    public Deck() {
        this.createDeck();
    }

    private void createDeck() {
        this.cards = new ArrayList<>();

        for(int i=0; i<Suit.values().length; i++) {
            this.cards.add(
                new Card(Card.ACE, Suit.values()[i], 1)
            );

            for(int j=2; j<= 10; j++) {
                this.cards.add(
                    new Card(Integer.toString(j), Suit.values()[i], j)
                );
            }
            this.cards.add(
                new Card(Card.JACK, Suit.values()[i], 10)
            );
            this.cards.add(
                new Card(Card.QUEEN, Suit.values()[i], 10)
            );
            this.cards.add(
                new Card(Card.KING, Suit.values()[i], 10)
            );
        }
        this.originalSize = this.cards.size();
        this.shuffle();
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public void shuffle(List<Card> cards) {
        this.cards.addAll(cards);
        this.shuffle();
    }

    public Card draw() {
        return this.cards.size() > 0 ? this.cards.remove(0) : null;
    }

    public int cardsLeft() {
        return this.cards.size();
    }

    public int cardsDiscarded() {
        return this.originalSize - this.cards.size();
    }

    public Card viewCard(int position){
        return cards.get(position);
    }
}

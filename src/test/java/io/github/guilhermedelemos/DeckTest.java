package io.github.guilhermedelemos;

import io.github.guilhermedelemos.blackjack.Card;
import io.github.guilhermedelemos.blackjack.Deck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test void drawTest() {
        Deck deck = new Deck();
        Card card = deck.draw();
        assertNotNull(card);
    }

    @Test void cardsLeft() {
        Deck deck = new Deck();
        int amount = deck.cardsLeft();
        deck.draw();
        assertTrue(deck.cardsLeft() < amount);
    }

    @Test void cardsDiscarded() {
        Deck deck = new Deck();
        int amount = deck.cardsDiscarded();
        deck.draw();
        assertTrue(deck.cardsDiscarded() > amount);
    }

    @Test void cardsShuffle(){
        Deck deck = new Deck();
        List<Card> deckPadrao = new ArrayList<>();
        for (int i=0; i < 52; i++){
            deckPadrao.add(deck.viewCard(i));
        }
        deck.shuffle();
        List<Card> deckShuffle = new ArrayList<>();
        for (int i=0; i < 52; i++){
            deckShuffle.add(deck.viewCard(i));
        }
        assertNotEquals(deckPadrao, deckShuffle);
    }
}

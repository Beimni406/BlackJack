package com.pluralsight;

import java.util.*;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String rank : ranks) {
                int value = switch (rank) {
                    case "Jack", "Queen", "King" -> 10;
                    case "Ace" -> 11;
                    default -> Integer.parseInt(rank);
                };
                cards.add(new Card(suit, rank, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        return cards.remove(0);
    }
}

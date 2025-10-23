package com.pluralsight;

import java.util.*;

public class Player {
    private String name;
    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getHandValue() {
        int total = 0;
        int aceCount = 0;
        for (Card card : hand) {
            total += card.getValue();
            if (card.getRank().equals("Ace")) aceCount++;
        }

        while (total > 21 && aceCount > 0) {
            total -= 10; // count Ace as 1 instead of 11
            aceCount--;
        }
        return total;
    }

    public String getName() { return name; }

    public void showHand() {
        System.out.println(name + "'s hand:");
        for (Card card : hand) {
            System.out.println("  " + card);
        }
        System.out.println("Total: " + getHandValue() + "\n");
    }
}

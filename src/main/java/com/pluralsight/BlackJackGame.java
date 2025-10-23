package com.pluralsight;

import java.util.*;

public class BlackJackGame {
    private List<Player> players = new ArrayList<>();
    private Deck deck = new Deck();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many players? ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        deck.shuffle();

        // deal 2 cards to each player
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.addCard(deck.dealCard());
            }
        }

        // show hands
        for (Player player : players) {
            player.showHand();
        }

        // determine winner
        Player winner = null;
        int bestScore = 0;

        for (Player player : players) {
            int score = player.getHandValue();
            if (score <= 21 && score > bestScore) {
                bestScore = score;
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println("🏆 Winner: " + winner.getName() + " with " + bestScore + " points!");
        } else {
            System.out.println("No winner — everyone busted!");
        }
    }
}

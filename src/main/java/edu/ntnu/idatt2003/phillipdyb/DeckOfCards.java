package edu.ntnu.idatt2003.phillipdyb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfCards {

  // Array with H(Hearts), D(Diamond), C(Clover), S(Spades)
  private char[] suits = {'H', 'D', 'C', 'S'};
  private List<PlayingCard> cards = new ArrayList<>();

  // Function to iterate between cards
  public DeckOfCards() {
    for (char suit : suits) {
      for (int value = 1; value <= 13; value++) {
        cards.add(new PlayingCard(suit, value));
      }
    }
  }

  // Deals a set of 5 cards, shuffled from the collection
//  public List<PlayingCard> dealHand() {
//    Collections.shuffle(cards);
//    return cards.subList(0, 5);
//  }

  public List<PlayingCard> dealHand(int n) {
    Random random = new Random();
    List<PlayingCard> deck = new ArrayList<>(cards);
    List<PlayingCard> hand = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int index = random.nextInt(deck.size());
      hand.add(deck.get(index));
      deck.remove(index);
    }

    return hand;
  }


}

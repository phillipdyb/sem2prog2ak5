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

  public List<PlayingCard> dealHand(int n) {
    if (n < 1 || n > 52) {
      throw new IllegalArgumentException("n must be between 1 and 52");
    }
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

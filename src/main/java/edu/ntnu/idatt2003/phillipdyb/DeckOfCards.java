package edu.ntnu.idatt2003.phillipdyb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class servers as a Deck of Cards.
 * Uses a list of chars for the suits, and a List for playingcards.
 * Iterates and randomizes a set of cards in a List.
 *
 * @author phillipdyb
 * @version 1.0
 */
public class DeckOfCards {
  private final char[] suits = {'H', 'D', 'C', 'S'};
  private final List<PlayingCard> cards = new ArrayList<>();

  /**
   * Iterators in the for loop, creating a card with a suit and a face.
   */
  public DeckOfCards() {
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        cards.add(new PlayingCard(suit, face));
      }
    }
  }

  /**
   *
   * @param n Randomizes a face that iterators through the deck size, creating a new set of decks.
   * @return randomized hand of decks.
   */
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

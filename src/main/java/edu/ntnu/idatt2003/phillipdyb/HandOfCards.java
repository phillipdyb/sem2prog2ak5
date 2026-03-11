package edu.ntnu.idatt2003.phillipdyb;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class servers as a Hand of cards.
 * The player receives a hand of cards, while this class analyzes which cards the player receives.
 *
 * @author phillipdyb
 * @version 1.0
 */
public class HandOfCards {
  private final List<PlayingCard> hand;

  /**
   * Error handling and construction of a "hand" - a set of cards in the players hand.
   *
   * @param hand - Receives a set of cards from PlayingCard class
   */
  public HandOfCards(List<PlayingCard> hand) {
    if (hand == null) {
      throw new IllegalArgumentException("Hand cannot be null");
    }
    this.hand = hand;
  }

  public List<PlayingCard> getHand() {
    return hand;
  }

  /**
   * @return true or false, if the set of hands is of the same suit, making it a flush.
   */
  public boolean isFlush() {
    return hand.stream()
        .map(PlayingCard::getSuit)
        .distinct()
        .count() == 1;
  }

  /**
   * @return Summarizes the value of all the cards.
   */
  public int getSum() {
    return hand.stream()
        .mapToInt(PlayingCard::getValue)
        .sum();
  }

  /**
   * @return Either "No Hearts", meaning the set of hands does not contain any hearts,
   * or lists the Hearts in the set of hands.
   */
  public String getHearts() {
    List<PlayingCard> hearts = hand.stream()
        .filter(card -> card.getSuit() == 'H')
        .collect(Collectors.toList());

    if (hearts.isEmpty()) {
      return "No Hearts";
    }
    return hearts.stream()
        .map(PlayingCard::toString)
        .collect(Collectors.joining(" "));

  }

  /**
   * @return Either "No Queen of Spades", meaning the set of hands does not contain any Queen of Spades,
   * or lists the Queen of Spades in the set of hands.
   */
  public String isS12() {
    List<PlayingCard> s12 = hand.stream()
        .filter(card -> card.getSuit()== 'S' && card.getValue() == 12)
        .collect(Collectors.toList());
    if (s12.isEmpty()) {
      return "No Queen of Spades";
    }
    return s12.stream()
        .map(PlayingCard::toString)
        .collect(Collectors.joining(" "));
  }

}

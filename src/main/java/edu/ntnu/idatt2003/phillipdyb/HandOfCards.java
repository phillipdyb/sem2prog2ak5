package edu.ntnu.idatt2003.phillipdyb;

import java.util.List;
import java.util.stream.Collectors;

public class HandOfCards {
  private List<PlayingCard> hand;

  public HandOfCards(List<PlayingCard> hand) {
    this.hand = hand;
  }

  public List<PlayingCard> getHand() {
    return hand;
  }

  // Checks if the cards are Flush
  public boolean isFlush() {
    return hand.stream()
        .map(PlayingCard::getSuit)
        .distinct()
        .count() == 1;
  }

  // Sum all cards in hand
  public int getSum() {
    return hand.stream()
        .mapToInt(PlayingCard::getValue)
        .sum();
  }

  // List hearts
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

  // Check if there is Queen of Spades (S12)
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

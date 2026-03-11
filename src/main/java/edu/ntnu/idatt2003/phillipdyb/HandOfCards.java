package edu.ntnu.idatt2003.phillipdyb;

import java.util.Collections;
import java.util.List;

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


}
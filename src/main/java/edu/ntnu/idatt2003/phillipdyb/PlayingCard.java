package edu.ntnu.idatt2003.phillipdyb;

public class PlayingCard {
  private final char suit;
  private final int value;

  public PlayingCard(char suit, int value) {
    this.suit = suit;
    this.value = value;
  }

  public char getSuit() {
    return suit;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "" + suit + value;
  }


}

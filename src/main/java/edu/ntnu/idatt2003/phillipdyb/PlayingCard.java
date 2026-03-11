package edu.ntnu.idatt2003.phillipdyb;

public class PlayingCard {
  private final char suit;
  private final int value;

  public PlayingCard(char suit, int value) {
    verifyValue(value);
    verifySuit(suit);

    this.suit = suit;
    this.value = value;
  }

  // Error handling for value
  public void verifyValue(int value) {
    if (value < 1 || value > 13) {
      throw new IllegalArgumentException("Face must be between 1 and 13");
    }
  }

  // Error handling for char suit
  public void verifySuit(char suit) {
    if (suit != 'S' && suit != 'D' && suit != 'C' && suit != 'H') {
      throw new IllegalArgumentException("Invalid character: " + suit);
    }
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

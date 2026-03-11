package edu.ntnu.idatt2003.phillipdyb;

/**
 * This class takes in a suit and a value, making playingcards.
 *
 * @author phillipdyb
 * @version 1.0
 */
public class PlayingCard {
  private final char suit;
  private final int value;

  /**
   * Verifies and then sets the variables.
   *
   * @param suit - Suits of cards
   * @param value - Values of cards
   */
  public PlayingCard(char suit, int value) {
    verifyValue(value);
    verifySuit(suit);

    this.suit = suit;
    this.value = value;
  }

  /**
   * Error handling for suit.
   *
   * @param suit - Suit of card
   */
  public void verifySuit(char suit) {
    if (suit != 'S' && suit != 'D' && suit != 'C' && suit != 'H') {
      throw new IllegalArgumentException("Invalid character: " + suit);
    }
  }

  /**
   * Error handling for value.
   *
   * @param value - Value of card
   */
  public void verifyValue(int value) {
    if (value < 1 || value > 13) {
      throw new IllegalArgumentException("Face must be between 1 and 13");
    }
  }

  /**
   * @return - Suit
   */
  public char getSuit() {
    return suit;
  }

  /**
   * @return - Value
   */
  public int getValue() {
    return value;
  }

  /**
   * @return - Suit and Value on the form "A1", "H15" etc.
   */
  @Override
  public String toString() {
    return "" + suit + value;
  }

}

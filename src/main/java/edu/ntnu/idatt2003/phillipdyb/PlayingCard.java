package edu.ntnu.idatt2003.phillipdyb;

/**
 * This class takes in a suit and a value, making playingcards.
 *
 * @author phillipdyb
 * @version 1.0
 */
public class PlayingCard {
  private final char suit;
  private final int face;

  /**
   * Verifies and then sets the variables.
   *
   * @param suit - Suits of cards
   * @param face - Values of cards
   */
  public PlayingCard(char suit, int face) {
    verifyValue(face);
    verifySuit(suit);

    this.suit = suit;
    this.face = face;
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
   * Error handling for face.
   *
   * @param face - Value of card
   */
  public void verifyValue(int face) {
    if (face < 1 || face > 13) {
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
  public int getFace() {
    return face;
  }

  /**
   * @return - Suit and Value on the form "A1", "H15" etc.
   */
  @Override
  public String toString() {
    return "" + suit + face;
  }

  /**
   * Checks if two PlayingCard objects are equal based on suit and face.
   *
   * @param o   the reference object with which to compare.
   * @return
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayingCard otherCard = (PlayingCard) o;
    return getSuit() == otherCard.getSuit() && getFace() == otherCard.getFace();
  }

  /**
   * @return - Hashed cards
   */
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + getSuit();
    hash = 31 * hash + getFace();
    return hash;
  }

}

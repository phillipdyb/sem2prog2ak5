import edu.ntnu.idatt2003.phillipdyb.DeckOfCards;
import edu.ntnu.idatt2003.phillipdyb.PlayingCard;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Deck of Cards class.
 *
 * @author phillipdyb
 * @version 1.0
 */
class DeckOfCardsTest {

  /**
   * The amount of cards called should be the same as the amount received.
   */
  @Test
  void dealHandReturnsCorrectNumberOfCards() {
    DeckOfCards deck = new DeckOfCards();
    List<PlayingCard> hand = deck.dealHand(5);

    assertEquals(5, hand.size());
  }

  /**
   * The value of a card should be between 1 and 13.
   */
  @Test
  void dealtCardsHaveValidValues() {
    DeckOfCards deck = new DeckOfCards();
    List<PlayingCard> hand = deck.dealHand(10);

    for (PlayingCard card : hand) {
      assertTrue(card.getValue() >= 1 && card.getValue() <= 13);
    }
  }

  /**
   * If the amount of cards requested are less than 0, an error should be thrown.
   */
  @Test
  void dealHandThrowsExceptionIfTooFewCardsRequested() {
    DeckOfCards deck = new DeckOfCards();

    assertThrows(IllegalArgumentException.class,
        () -> deck.dealHand(0));
  }

  /**
   * If too many cards is requested, an error should be thrown.
   */
  @Test
  void dealHandThrowsExceptionIfTooManyCardsRequested() {
    DeckOfCards deck = new DeckOfCards();

    assertThrows(IllegalArgumentException.class,
        () -> deck.dealHand(53));
  }

  /**
   * No card can have the same value and suit. If else, an error should be thrown.
   */
  @Test
  void dealtCardsShouldBeUnique() {
    DeckOfCards deck = new DeckOfCards();

    List<PlayingCard> hand = deck.dealHand(20);

    assertEquals(hand.size(), hand.stream().distinct().count());
  }

}

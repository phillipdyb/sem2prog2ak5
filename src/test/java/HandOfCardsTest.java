import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import edu.ntnu.idatt2003.phillipdyb.HandOfCards;
import edu.ntnu.idatt2003.phillipdyb.PlayingCard;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Hand of Cards class.
 *
 * @author phillipdyb
 * @version 1.0
 */
class HandOfCardsTest {

  /**
   * Checks if the same face cards returns a true for flush.
   */
  @Test
  void isFlush() {
    List<PlayingCard> cards = new ArrayList<>();
    cards.add(new PlayingCard('H', 1));
    cards.add(new PlayingCard('H', 2));
    cards.add(new PlayingCard('H', 3));
    cards.add(new PlayingCard('H', 4));
    cards.add(new PlayingCard('H', 5));

    HandOfCards hand = new HandOfCards(cards);

    assertTrue(hand.isFlush());
  }

  /**
   * Checks if not same face cards returns a false for flush.
   */
  @Test
  void isNotFlush() {
    List<PlayingCard> cards = new ArrayList<>();
    cards.add(new PlayingCard('H', 1));
    cards.add(new PlayingCard('H', 2));
    cards.add(new PlayingCard('H', 3));
    cards.add(new PlayingCard('H', 4));
    cards.add(new PlayingCard('D', 5));

    HandOfCards hand = new HandOfCards(cards);

    assertFalse(hand.isFlush());
  }

  /**
   * Checks if the sum is correct.
   */
  @Test
  void getSumReturnsCorrectFace() {
    List<PlayingCard> cards = List.of(
        new PlayingCard('H', 2),
        new PlayingCard('D', 3),
        new PlayingCard('S', 4)
    );

    HandOfCards hand = new HandOfCards(cards);

    assertEquals(9, hand.getSum());
  }

  /**
   * Checks if the Hearts listed are correct.
   */
  @Test
  void getHeartsReturnsOnlyHeartsCards() {
    List<PlayingCard> cards = List.of(
        new PlayingCard('H', 2),
        new PlayingCard('D', 3),
        new PlayingCard('H', 10)
    );

    HandOfCards hand = new HandOfCards(cards);

    assertEquals("H2 H10", hand.getHearts());
  }

  /**
   * Check if No Hearts is listed correctly.
   */
  @Test
  void getHeartsReturnsNoHeartsIfNoneExist() {
    List<PlayingCard> cards = List.of(
        new PlayingCard('D', 2),
        new PlayingCard('S', 3)
    );

    HandOfCards hand = new HandOfCards(cards);

    assertEquals("No Hearts", hand.getHearts());
  }

  /**
   * Check if the Queen of Spades are listed correctly.
   */
  @Test
  void isS12DetectsQueenOfSpades() {
    List<PlayingCard> cards = List.of(
        new PlayingCard('S', 12),
        new PlayingCard('H', 5)
    );

    HandOfCards hand = new HandOfCards(cards);

    assertEquals("S12", hand.isS12());
  }

  /**
   * Check if the No Queen of Spades is listed correctly.
   */
  @Test
  void isS12ReturnsMessageIfNotPresent() {
    List<PlayingCard> cards = List.of(
        new PlayingCard('H', 10),
        new PlayingCard('D', 8)
    );

    HandOfCards hand = new HandOfCards(cards);

    assertEquals("No Queen of Spades", hand.isS12());
  }

}

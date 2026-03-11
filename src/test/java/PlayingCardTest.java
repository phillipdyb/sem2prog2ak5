import edu.ntnu.idatt2003.phillipdyb.PlayingCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Playing Card class.
 */
class PlayingCardTest {

  /**
   * Validates creation of cards.
   */
  @Test
  void validCardShouldBeCreated() {
    PlayingCard card = new PlayingCard('S', 10);

    assertEquals('S', card.getSuit());
    assertEquals(10, card.getFace());
  }

  /**
   * An error should be thrown if the suit is invalid.
   */
  @Test
  void invalidSuitShouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> new PlayingCard('X', 5));
  }

  /**
   * An error should be thrown if the value is too low.
   */
  @Test
  void invalidLowValueShouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> new PlayingCard('H', 0));
  }

  /**
   * An error should be thrown if the value is too high.
   */
  @Test
  void invalidHighValueShouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> new PlayingCard('D', 14));
  }

}

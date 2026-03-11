import edu.ntnu.idatt2003.phillipdyb.PlayingCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayingCardTest {

  @Test
  void validCardShouldBeCreated() {
    PlayingCard card = new PlayingCard('S', 10);

    assertEquals('S', card.getSuit());
    assertEquals(10, card.getValue());
  }

  @Test
  void invalidSuitShouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> new PlayingCard('X', 5));
  }

  @Test
  void invalidLowValueShouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> new PlayingCard('H', 0));
  }

  @Test
  void invalidHighValueShouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> new PlayingCard('D', 14));
  }

}

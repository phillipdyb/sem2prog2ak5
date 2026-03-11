import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.ntnu.idatt2003.phillipdyb.HandOfCards;
import edu.ntnu.idatt2003.phillipdyb.PlayingCard;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class HandOfCardsTest {

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

}

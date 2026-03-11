import edu.ntnu.idatt2003.phillipdyb.DeckOfCards;
import edu.ntnu.idatt2003.phillipdyb.PlayingCard;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

  @Test
  void dealHandReturnsCorrectNumberOfCards() {
    DeckOfCards deck = new DeckOfCards();
    List<PlayingCard> hand = deck.dealHand(5);

    assertEquals(5, hand.size());
  }

  @Test
  void dealtCardsHaveValidValues() {
    DeckOfCards deck = new DeckOfCards();
    List<PlayingCard> hand = deck.dealHand(10);

    for (PlayingCard card : hand) {
      assertTrue(card.getValue() >= 1 && card.getValue() <= 13);
    }
  }

  @Test
  void dealHandThrowsExceptionIfTooFewCardsRequested() {
    DeckOfCards deck = new DeckOfCards();

    assertThrows(IllegalArgumentException.class,
        () -> deck.dealHand(0));
  }

  @Test
  void dealHandThrowsExceptionIfTooManyCardsRequested() {
    DeckOfCards deck = new DeckOfCards();

    assertThrows(IllegalArgumentException.class,
        () -> deck.dealHand(53));
  }

  @Test
  void dealtCardsShouldBeUnique() {
    DeckOfCards deck = new DeckOfCards();

    List<PlayingCard> hand = deck.dealHand(20);

    assertEquals(hand.size(), hand.stream().distinct().count());
  }

}

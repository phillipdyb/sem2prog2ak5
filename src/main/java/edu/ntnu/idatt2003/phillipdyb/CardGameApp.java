package edu.ntnu.idatt2003.phillipdyb;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * This class uses JavaFX for GUI.
 *
 * @author phillipdyb
 * @version 1.0
 */
public class CardGameApp extends Application {

  /**
   * Starts the GUI with labels counting as functions from other classes.
   * This only has 1 view, primaryStage.
   *
   * Button dealButton calls all functions again, to get a new set of cards.
   * This also updates all functions to check the new cards.
   */
  @Override
  public void start(Stage primaryStage) {
    DeckOfCards deck = new DeckOfCards();
    HandOfCards[] currentHand = {new HandOfCards(deck.dealHand(5))};

    HBox cardImages = new HBox(10);
    cardImages.setAlignment(Pos.CENTER);
    updateCardImages(cardImages, currentHand[0]);

    Label isFlush = new Label("");
    Label getSum = new Label("");
    Label getHearts = new Label("");
    Label isS12 = new Label("");

    Button dealButton = new Button("Deal new hand");
    dealButton.setOnAction(e -> {
      currentHand[0] = new HandOfCards(deck.dealHand(5));
      updateCardImages(cardImages, currentHand[0]);
      isFlush.setText("");
      getSum.setText("");
      getHearts.setText("");
      isS12.setText("");
    });
    dealButton.setId("deal-button");

    Button checkButton = new Button("Check hand");
    checkButton.setOnAction(e -> {
      isFlush.setText(currentHand[0].isFlush() ? "Flush!" : "No flush");
      getSum.setText(String.valueOf(currentHand[0].getSum()));
      getHearts.setText(currentHand[0].getHearts());
      isS12.setText(currentHand[0].isS12());
    });
    checkButton.setId("check-button");

    HBox buttonRow = new HBox(10, dealButton, checkButton);
    buttonRow.setAlignment(Pos.CENTER);

    StackPane flushBox = createInfoBox("Flush?", isFlush);
    StackPane sumBox = createInfoBox("Sum", getSum);
    StackPane heartsBox = createInfoBox("Hearts", getHearts);
    StackPane queenBox = createInfoBox("Queen of Spades", isS12);

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.add(flushBox, 0, 0);
    grid.add(sumBox, 1, 0);
    grid.add(heartsBox, 0, 1);
    grid.add(queenBox, 1, 1);
    grid.setAlignment(Pos.CENTER);

    VBox root = new VBox(20, cardImages, buttonRow, grid);
    root.setAlignment(Pos.CENTER);
    root.setPadding(new Insets(40));
    root.setId("root");

    Scene scene = new Scene(root, 1280, 720);
    scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

    primaryStage.setTitle("Card Game");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Creates an ImageView for a playing card based on its toString value.
   *
   * @param card - The playing card to create an image for
   * @return ImageView with the card image
   */
  private ImageView createCardImage(PlayingCard card) {
    String filename = "/" + card.toString() + ".png";
    Image image = new Image(getClass().getResourceAsStream(filename));
    ImageView imageView = new ImageView(image);
    imageView.setFitHeight(300);
    imageView.setPreserveRatio(true);
    return imageView;
  }

  /**
   * Updates the HBox with card images for the current hand.
   *
   * @param cardImages - HBox to update
   * @param hand       - The hand of cards to display
   */
  private void updateCardImages(HBox cardImages, HandOfCards hand) {
    cardImages.getChildren().clear();
    for (PlayingCard card : hand.getHand()) {
      cardImages.getChildren().add(createCardImage(card));
    }
  }

  /**
   * Creates an info box with a title and a value label.
   *
   * @param title      - Title of the box
   * @param valueLabel - Label to display the value
   * @return StackPane with the info box
   */
  private StackPane createInfoBox(String title, Label valueLabel) {
    Label titleLabel = new Label(title);
    titleLabel.getStyleClass().add("box-title");

    valueLabel.getStyleClass().add("box-value");

    VBox content = new VBox(8, titleLabel, valueLabel);
    content.setAlignment(Pos.CENTER);

    StackPane box = new StackPane(content);
    box.getStyleClass().add("info-box");
    box.setPrefSize(200, 100);
    return box;
  }

}
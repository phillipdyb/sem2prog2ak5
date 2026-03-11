package edu.ntnu.idatt2003.phillipdyb;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CardGameApp extends Application {


  // Start GUI
  @Override
  public void start(Stage primaryStage) {
    DeckOfCards deck = new DeckOfCards();
    HandOfCards hand = new HandOfCards(deck.dealHand());

    Label getHand = new Label(hand.getHand().toString());
    getHand.setStyle("-fx-font-size: 20px;");

    Label isFlush = new Label(hand.isFlush() ? "Flush!" : "No flush");
    isFlush.setText(hand.isFlush() ? "Flush!" : "No flush");

    Button dealButton = new Button("Deal new hand");
    dealButton.setOnAction(e -> {
      HandOfCards newHand = new HandOfCards(deck.dealHand());
      getHand.setText(newHand.getHand().toString());
      isFlush.setText(newHand.isFlush() ? "Flush!" : "No flush");
    });

    Scene scene = new Scene(new VBox(getHand, dealButton, isFlush), 600, 400);

    primaryStage.setTitle("Card Game");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}

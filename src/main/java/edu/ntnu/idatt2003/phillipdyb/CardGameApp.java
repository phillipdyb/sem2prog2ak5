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
    HandOfCards hand = new HandOfCards(deck.dealHand(5));

    Label getHand = new Label(hand.getHand().toString());
    getHand.setStyle("-fx-font-size: 20px;");

    Label isFlush = new Label(hand.isFlush() ? "Flush!" : "No flush");

    Label getSum = new Label(String.valueOf(hand.getSum()));

    Label getHearts = new Label(hand.getHearts());

    Label isS12 = new Label(hand.isS12());

    Button dealButton = new Button("Deal new hand");
    dealButton.setOnAction(e -> {
      HandOfCards newHand = new HandOfCards(deck.dealHand(5));
      getHand.setText(newHand.getHand().toString());
      isFlush.setText(newHand.isFlush() ? "Flush!" : "No flush");
      getSum.setText(String.valueOf(newHand.getSum()));
      getHearts.setText(newHand.getHearts());
      isS12.setText(newHand.isS12());
    });

    Scene scene = new Scene(new VBox(getHand, dealButton, isFlush, getSum, getHearts, isS12), 600, 400);

    primaryStage.setTitle("Card Game");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}

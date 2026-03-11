package edu.ntnu.idatt2003.phillipdyb;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CardGameApp extends Application {

  @Override
  public void start(Stage primaryStage) {
    DeckOfCards deck = new DeckOfCards();
    HandOfCards hand = new HandOfCards(deck.dealHand());

    Label label = new Label(hand.getHand().toString());
    label.setStyle("-fx-font-size: 20px;");

    Button dealButton = new Button("Deal new hand");
    dealButton.setOnAction(e -> {
      HandOfCards newHand = new HandOfCards(deck.dealHand());
      label.setText(newHand.getHand().toString());
    });

    Scene scene = new Scene(new VBox(label, dealButton), 600, 400);

    primaryStage.setTitle("Card Game");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}

package net.lyxnx.bingo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    private int score = 0;

    @FXML
    private Label scoreLabel;

    private Parent root;

    /**
     * This method is called on start up.
     */
    void load(Parent root) {
        this.root = root;
    }

    @FXML
    private void handleButton(ActionEvent event) {
        // can blindly cast here as this method is for buttons only
        ((Button) event.getSource()).setDisable(true); // can no longer use this button

        updateScore(score+1);
    }

    @FXML
    private void exit() {
        root.getScene().getWindow().hide();
    }

    @FXML
    private void reset() {
        updateScore(0);
        root.getChildrenUnmodifiable().stream().filter(item -> item instanceof Button).forEach(btn -> btn.setDisable(false));
    }

    private void updateScore(int score) {
        this.score = score;

        if(this.score == 16) {
            scoreLabel.setText("BINGO!");
            new Thread(() -> new AudioPlayer().play(getClass().getResource("/bingo.wav"))).start();
        } else {
            scoreLabel.setText("" + score);
        }
    }
}
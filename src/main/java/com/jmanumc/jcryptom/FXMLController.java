package com.jmanumc.jcryptom;

import edu.uci.qa.crypt.Crypt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    @FXML
    private TextField keyTextField;

    @FXML
    private Button encryptButton;

    @FXML
    private Button decryptButton;

    @FXML
    private TextArea encryptTextArea;

    @FXML
    private TextArea decryptTextArea;
    
    @FXML
    private void handleEncryptButtonAction(ActionEvent event) {
        String key = keyTextField.getText().trim();
        String text = encryptTextArea.getText().trim();
        
        if (key.isEmpty()) {
            keyTextField.setStyle("-fx-border-color: red");
        } else {
            keyTextField.setStyle("-fx-border-color: none");
        }

        if (text.isEmpty()) {
            encryptTextArea.setStyle("-fx-border-color: red");
        } else {
            encryptTextArea.setStyle("-fx-border-color: none");
        }
        
        if (! key.isEmpty() && ! text.isEmpty()) {
            decryptTextArea.setText(Crypt.encrypt(text, key));
        }
    }
    
    @FXML
    private void handleDecryptButtonAction(ActionEvent event) {
        String key = keyTextField.getText().trim();
        String encryptation = decryptTextArea.getText().trim();
        
        if (key.isEmpty()) {
            keyTextField.setStyle("-fx-border-color: red");
        } else {
            keyTextField.setStyle("-fx-border-color: none");
        }

        if (encryptation.isEmpty()) {
            decryptTextArea.setStyle("-fx-border-color: red");
        } else {
            decryptTextArea.setStyle("-fx-border-color: none");
        }
        
        if (! key.isEmpty() && ! encryptation.isEmpty()) {
            encryptTextArea.setText(Crypt.decrypt(encryptation, key));
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
}

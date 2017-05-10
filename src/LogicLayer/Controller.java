package LogicLayer;

import DataLayer.UserCredentials;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;

/**
 * Created by Thomas on 06-05-2017.
 */
public class Controller {

    @FXML
   private TextField usernameInput, passwordInput;

    @FXML
   private  Button loginButton;

    @FXML
    private Label wrongPW;


    private boolean validateUser()
    {
        UserCredentials userCredentials = new UserCredentials();
        String userName = usernameInput.getText();
        String password = passwordInput.getText();


        if(userName.equals(userCredentials.getUserName()) && password.equals(userCredentials.getPassword()))
            return true;

        return false;
    }



    public void login()
    {


        if(validateUser()) {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();

            openNewWindow();

        }
        else{

            wrongPW.setText("Wrong username/password");
        }

    }

    public void loginWithEnter()
    {

        passwordInput.setOnKeyPressed(e-> {
           if(e.getCode() == KeyCode.ENTER && validateUser()) {
               openNewWindow();
           }
            wrongPW.setText("Wrong username/password");
        });


    }

    private void openNewWindow()
    {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setTitle("Second window");
            stage.setScene(new Scene(root1));
            stage.show();


        }catch (Exception e) {
            System.out.println("Cant load window");
        }
    }

}

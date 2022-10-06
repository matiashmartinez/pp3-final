/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pp3.st.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import pp3.st.Main;

/**
 * FXML Controller class
 *
 * @author Matyas
 */
public class PrincipalController implements Initializable {

    private Stage stage;
    private Main main = new Main();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    private void verClientes(ActionEvent event) {
        main.centrar_scena_gestion();
    }

    public void setMain(Main main) {
        this.main = main;
    }



}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp3.st.vistas;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pp3.st.Main;
import pp3.st.conexion.LoginDB;
import pp3.st.modelo.Login;
import pp3.st.utils.Cifrado;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tfUsuario;
    @FXML
    private PasswordField tfPassword;

    private Main main;
    LoginDB ldb = new LoginDB();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onIngresar(ActionEvent event) {
        try {
            //        try {
            main.verVistaPrincipal();
//        if (validarLogin()) {
//            System.out.println("Cargando vista principal");
//
//
//        }
//        } catch (IOException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void setMain(FinalLub main) {
//        this.main = main;
//    }
    public boolean validarLogin() {

        if (tfUsuario.getText() == "" || tfPassword.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos vacíos");
            alert.setContentText("Por favor digite su usuario y contraseña:\n");

            alert.showAndWait();
        }

        Login login = new Login(tfUsuario.getText(), tfPassword.getText());

        System.out.println("Clave: " + login.getPassword());

        System.out.println("Otro:" + Cifrado.sha1(login.getPassword()));
        System.out.println("Cifrado:" + Cifrado.md5(login.getPassword()));
        login.setUsuario(tfUsuario.getText());
        login.setPassword(Cifrado.md5(login.getPassword()));

        if (ldb.validarLoginDB(login)) {
            System.out.println("Validacion correcta recibida");
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//
//            alert.setTitle("Ingreso");
//            alert.setHeaderText("Ingresando al sistema");
//            alert.setContentText("Acceso autorizado");
//
//            alert.showAndWait();
            return true;
        } else {
            System.out.println("Validacion incorrecta");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Usuario y/o contraseña inválidos");
            alert.setHeaderText("Por favor digite su usuario y contraseña");
            alert.setContentText("Acceso no autorizado");

            alert.showAndWait();
        }
        return false;
    }

    private void onCancelar(ActionEvent event) {
        try {
            main.stop();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void onIniciarSesion(ActionEvent event) {
    }

    public void setMain(Main main) {
        this.main = main;
    }

}

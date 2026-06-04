/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package pp3.st;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import pp3.st.vistas.GestionController;
import pp3.st.vistas.LoginController;
import pp3.st.vistas.PrincipalController;

/**
 *
 * @author Matyas
 */
public class Main extends Application {

    private Stage stage;
//    Stage stageLogin;
    private BorderPane rootLayout;
    private AnchorPane regCliente;
    
    

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        verLogin();
    }

    public void verLogin() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("vistas/Login.fxml"));
            AnchorPane login;
            login = loader.load();

            Scene scene = new Scene(login);
            LoginController lc = loader.getController();
            lc.setMain(this);

            stage.setScene(scene);

//            stage.initStyle(StageStyle.DECORATED);

            stage.setResizable(false);
            stage.setTitle("Gestión Servicio Técnico");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void verVistaPrincipal() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("vistas/Principal.fxml"));
        rootLayout = loader.load();
        
        Scene scene = new Scene(rootLayout);
        PrincipalController pc = loader.getController();
        pc.setMain(this);
        stage.setResizable(false);
        stage.setHeight(700);
        stage.setWidth(1100);
        
        stage.setScene(scene);
        stage.show();

        centrar_scena_gestion();

    }

    public void centrar_scena_gestion() {
//        this.stage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("vistas/Gestion.fxml"));
        try {
            regCliente = (AnchorPane) loader.load();
            GestionController c = loader.getController();
            c.setMain(this);
            rootLayout.setCenter(regCliente);

        } catch (IOException ex) {
            System.err.println("Error al cargar rootLayout" + ex.getMessage());
        }

    }

}

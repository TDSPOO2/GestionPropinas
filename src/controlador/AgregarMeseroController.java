package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Mesero;

public class AgregarMeseroController implements Initializable {
    
    private Main main;
    private Stage stage;
    
    @FXML 
    TextField nombre;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void setMain(Main main, Stage stage) {
        this.main = main;
        this.stage = stage;
    }
    
    public void agregarMesero() {
        String nombre_mesero = nombre.getText();
        Mesero nuevo = new Mesero(nombre_mesero);
        this.main.vc1.agregarMesero(nuevo);
        this.stage.close();        
    }
}
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Mesero;

public class AgregarPropinaController implements Initializable {

    private Main main;
    private Stage stage;
    
    @FXML
    TextField propina;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        
    }    
    
    public void setMain(Main main, Stage stage) {
        this.main = main;
        this.stage = stage;
    }
    
    public void agregarPropina() {
        double valor_propina = Double.parseDouble(propina.getText());
        Mesero seleccionado = this.main.vc1.get_seleccionado();
        seleccionado.agregarPropina(valor_propina);
        this.main.vc1.refrescarTabla();
        this.stage.close();
    }
}

package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Mesero;

public class GestionMeserosController implements Initializable {
    
    private Main main;
    
    @FXML
    Label detalle_mesero;
    @FXML
    Label detalle_propina;

    @FXML
    TableView <Mesero> meseros;
    @FXML
    TableColumn <Mesero,String> mesero;
    @FXML
    TableColumn <Mesero,Double> propina;
    
    ObservableList listaMeseros;
    
    public void setMain(Main main) {
        this.main = main;
    }
           
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaMeseros = FXCollections.observableArrayList();
        mesero.setCellValueFactory(new PropertyValueFactory<Mesero,String>("nombre"));        
        propina.setCellValueFactory(new PropertyValueFactory<Mesero,Double>("total"));
        
        meseros.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                mostraDetalle((Mesero)newValue);
            }
        });
    }    
        
    public void abrirVentanaAgregarMesero() {
        this.main.AgregarMesero();
    }
    
    public void refrescarTabla() {
        meseros.setItems(null);
        meseros.layout();
        meseros.setItems(listaMeseros);
    }
    
    public void agregarMesero(Mesero nuevo) {
        listaMeseros.add(nuevo);
        refrescarTabla();
    }
    
    public void mostraDetalle(Mesero mesero) {
        if (mesero != null) {            
            detalle_mesero.setText(mesero.get_nombre());
            detalle_propina.setText(Double.toString(mesero.get_total()));
        } else {
            detalle_mesero.setText("");
            detalle_propina.setText("");
        }
    }
    
    public Mesero get_seleccionado() {
        return this.meseros.getSelectionModel().getSelectedItem();
    }
    
    public void eliminarMesero() {
        Mesero seleccionado = this.get_seleccionado();
        if (seleccionado != null) {
            listaMeseros.remove(seleccionado);
            refrescarTabla();
        }
    }
    
    public void abrirVentanaAgregarPropina() {
        Mesero seleccionado = this.get_seleccionado();
        if (seleccionado != null) {
            this.main.AgregarPropina();
        }
    }
}

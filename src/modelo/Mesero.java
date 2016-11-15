package modelo;

import java.util.ArrayList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mesero {
    public String nombre;
    public ArrayList<Propina> propinas;
    
    public Mesero(String nombre) {
        this.nombre = nombre;
        this.propinas = new ArrayList<Propina>();
    }
    
    public String get_nombre() {
        return this.nombre;
    }
    
    public double get_total() {
        double total = 0;
        for (int i=0; i < propinas.size(); i++) {
            total += this.propinas.get(i).get_monto();
        }
        return total;
    }
    
    public StringProperty nombreProperty() {
        final StringProperty name = new SimpleStringProperty(this.nombre);
        return name;
    }
    
    public DoubleProperty totalProperty() {
        final DoubleProperty monto = new SimpleDoubleProperty(this.get_total());
        return monto;
    }
    
    public void agregarPropina(double valor) {
        this.propinas.add(new Propina(valor));        
    }
}

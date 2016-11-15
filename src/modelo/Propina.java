package modelo;

import java.time.LocalTime;
import java.util.Date;

public class Propina {
    public double monto;
    public LocalTime fechahora;
    
    public Propina(Double monto) {
        this.monto = monto;
        this.fechahora = LocalTime.now();
    }
    
    public double get_monto() {
        return this.monto;
    }
}

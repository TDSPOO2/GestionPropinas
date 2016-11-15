package controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;
    public GestionMeserosController vc1;    
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        GestionMeseros();
    }
    
    public void GestionMeseros() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/vista/GestionMeseros.fxml"));
            Parent root = loader.load();
            vc1 = loader.getController();
            vc1.setMain(this);
            Scene scene = new Scene(root); 
            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestión de meseros");
            primaryStage.show();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void AgregarMesero() {
        try {
            FXMLLoader loader2 = new FXMLLoader(Main.class.getResource("/vista/AgregarMesero.fxml"));
            Parent root = loader2.load();
            Scene scene = new Scene(root); 
            Stage secondaryStage = new Stage();
            secondaryStage.initModality(Modality.APPLICATION_MODAL);
            secondaryStage.initOwner(this.primaryStage);
            secondaryStage.setScene(scene);
            AgregarMeseroController vc2 = loader2.getController();
            vc2.setMain(this,secondaryStage);
            secondaryStage.setTitle("Agregar mesero");
            secondaryStage.show();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void AgregarPropina() {
         try {
            FXMLLoader loader3 = new FXMLLoader(Main.class.getResource("/vista/AgregarPropina.fxml"));
            Parent root = loader3.load();
            Scene scene = new Scene(root); 
            Stage tertiaryStage = new Stage();
            tertiaryStage.initModality(Modality.APPLICATION_MODAL);
            tertiaryStage.initOwner(this.primaryStage);
            tertiaryStage.setScene(scene);
            AgregarPropinaController vc3 = loader3.getController();
            vc3.setMain(this,tertiaryStage);
            tertiaryStage.setTitle("Agregar propina");
            tertiaryStage.show();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

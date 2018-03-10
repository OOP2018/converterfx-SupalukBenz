package converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for run and show program converter
 *
 * @author Supaluk Jaroensuk
 */
public class Main extends Application{

    /**
     * The application initialization method
     * @param stage is the primary stage for this application
     */
    @Override
    public void start(Stage stage)  {
        try {

            Parent root = (Parent) FXMLLoader.load(getClass().getResource("ConverterUI.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Length Converter");
            stage.setScene(scene);
            stage.sizeToScene();
            stage.show();

        }catch (Exception e){
            System.out.println("Exception creating scene: "+ e.getMessage());
        }
    }

    /**
     * Launch a standalone application
     * @param args is the command line arguments passed to the application
     */
    public static void main(String[] args) {
        launch(args);
    }
}

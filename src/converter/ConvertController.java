package converter;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * ConvertController class for initial the ComboBoxes with length values
 * and control handle method include with handleConvert and handleClear
 *
 * @author Supaluk Jaroensuk
 */
public class ConvertController {

    @FXML
    TextField textfield1;

    @FXML
    TextField textfield2;

    @FXML
    private ComboBox<Length> unitbox1;

    @FXML
    private ComboBox<Length> unitbox2;

    @FXML
    private Button convert;

    @FXML
    private Button clear;

    /**
     * Initialize the ComboBoxes by use length units from Length enum
     */
    @FXML
    public void initialize(){

        System.out.println("Running initialize");
        if(unitbox1 != null){
            unitbox1.getItems().addAll(Length.values());
            unitbox1.getSelectionModel().select(0);
        }
        if(unitbox2 != null){
            unitbox2.getItems().addAll(Length.values());
            unitbox2.getSelectionModel().select(1);
        }
    }

    /**
     * Enable the user to press ENTER in a TextField
     */
    @FXML
    public void onEnter(){
        convert.fire();
    }

    /**
     * Convert value by length unit
     */
    public void handleConvert(){
        Length unit1 = unitbox1.getValue();
        Length unit2 = unitbox2.getValue();
        if(textfield1.getLength() != 0 && textfield2.getLength() == 0) {

            String text = textfield1.getText().trim();
            double value = (Double.parseDouble(text) * unit1.getValue()) / unit2.getValue();
            textfield2.setText(String.format("%.4g " , value));

        }else if(textfield1.getLength() == 0 && textfield2.getLength() != 0){

            String text = textfield2.getText().trim();
            double value = (Double.parseDouble(text) * unit2.getValue())/unit1.getValue();
            textfield1.setText(String.format("%.4g " , value));

        }else if(textfield1.getLength() == 0 && textfield2.getLength() == 0) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setContentText("Please, Input number.");

            alert.showAndWait();

        }else{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setContentText("Should clear value before converting.");
            clear.fire();
            alert.showAndWait();

        }
    }

    /**
     * Clear all TextFields
     */
    public void handleClear(){

        if(textfield2 != null && textfield1 !=null) {
            textfield1.clear();
            textfield2.clear();
        }

    }
}

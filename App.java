import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class App extends Application{
    
    Button button;
    private TextField metric;
    private TextField imperial;

    @Override
    public void start(Stage window) throws Exception{
         window.setTitle("Metric Converter");

         //Create a layout and make spacing
         GridPane layout = new GridPane(); 
         layout.setMinSize(500, 500);
         Insets padding = new Insets(10, 10, 10, 10);
         layout.setPadding(padding);
         layout.setHgap(5);
         layout.setVgap(5);
         
         //Make an area for users to input their value
         Label metricLabel = new Label("Metric value to be converted: "); 
         metric = new TextField();
         metric.setEditable(true);
         layout.add(metricLabel, 5, 0);
         layout.add(metric, 6, 0);

         //Make an area to display the converted value
         Label imperialLabel = new Label("Imperial: ");
         imperial = new TextField();
         imperial.setEditable(false);
         layout.add(imperialLabel, 5, 4);
         layout.add(imperial, 6, 4);
         
         //Create a drop down options box
         ChoiceBox<String> choiceBox = new ChoiceBox<>();
         choiceBox.getItems().addAll("Kilograms -> Pounds", "Centimeters -> Inches", "Celsius -> Degrees", "Meters -> Feet");
         choiceBox.setValue("Kilograms -> Pounds");
         layout.add(choiceBox, 8, 0);

         //Create a button to convert the value when pressed
         button = new Button(); 
         button.setText("Convert!");
         button.setOnAction(e -> getChoice(choiceBox)); 
         layout.add(button, 6, 2); 

         //Complete the window
         Scene scene = new Scene(layout); 
         window.setScene(scene); 
         window.show();
    }

    private void getChoice(ChoiceBox<String> choiceBox){
        String unit = choiceBox.getValue(); //Gets which option user chose from the drop down menu

        //Converts the value based on which option the user chose
        if(unit == "Kilograms -> Pounds")
        {
            String input = metric.getText();
            double kg = Integer.parseInt(input);
            double pounds = kg * 2.205;
            imperial.setText(Double.toString(pounds));
        }

        if(unit == "Centimeters -> Inches")
        {
            String input = metric.getText();
            double cm = Integer.parseInt(input);
            double inches = cm / 2.54;
            imperial.setText(Double.toString(inches));
        }

        if(unit == "Celsius -> Degrees")
        {
            String input = metric.getText();
            double celsius = Integer.parseInt(input);
            double degrees = (celsius / 1.8) + 32;
            imperial.setText(Double.toString(degrees));
        }

        if(unit == "Meters -> Feet")
        {
            String input = metric.getText();
            double meters = Integer.parseInt(input);
            double feet = meters * 3.281;
            imperial.setText(Double.toString(feet));
        }
    }
    

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}

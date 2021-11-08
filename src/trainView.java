import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;

public class trainView {

    GridPane startview;
    Label StartStation;
    Label EndStationLbl;
    Label Timelbl;
    Button exitBtn;
    Button FindTrains;
    TextArea TextField;
    ComboBox<String> startStationComB;
    ComboBox<String> endStationComB;
    ComboBox<Integer> hourComB;
    ComboBox<Integer> minComB;

    ObservableList<String> obsList;
    ObservableList<Integer> hoursList;
    ObservableList<Integer> minuteList;


    public trainView(){

        CreateView();


    }
    public void CreateView(){
        startview= new GridPane();
        startview.setMinSize(300,200);
        startview.setPadding(new Insets(10,10,10,10));
        startview.setVgap(5);
        startview.setHgap(1);

        StartStation = new Label("Select Start Station");
        startview.add(StartStation,1,1);

        exitBtn = new Button("Exit");
        startview.add(exitBtn,20,20);
        FindTrains = new Button("Find Departure");
        startview.add(FindTrains,15,9);

        EndStationLbl=new Label("Select Destination");
        startview.add(EndStationLbl,1,2);
        Timelbl=new Label("Select Time");
        startview.add(Timelbl,1,4);

        startStationComB = new ComboBox<>();
        startview.add(startStationComB,2,1);
        endStationComB = new ComboBox<>();
        startview.add(endStationComB,2,2);
        hourComB = new ComboBox<>();
        startview.add(hourComB,5,4);
        minComB = new ComboBox<>();
        startview.add(minComB,6,4);

        TextField = new TextArea();
        startview.add(TextField,1,10,15,10);


    }
    public void configure(){
        startStationComB.setItems(obsList);
        startStationComB.getSelectionModel().selectFirst();

        endStationComB.setItems(obsList);
        endStationComB.getSelectionModel().selectFirst();

        hourComB.setItems(hoursList);
        hourComB.getSelectionModel().selectFirst();

        minComB.setItems(minuteList);
        minComB.getSelectionModel().selectFirst();



    }
    public Parent asParent(){
        return startview;
    }
}

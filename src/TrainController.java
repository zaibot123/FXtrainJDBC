import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrainController {
    trainView view;
    TrainModel model;

    public TrainController(trainView v, TrainModel m) throws SQLException {
        view = v;
        model = m;
        view.exitBtn.setOnAction(e -> Platform.exit());
        model.connectToTrainData();
        model.CreateStatement();
        view.obsList = getStations();
        view.hoursList = getHours();
        view.minuteList=getMinutes();
        view.FindTrains.setOnAction(e->HandlerPrintTrainRoutes(view.startStationComB.getValue(), view.endStationComB.getValue(),
                view.hourComB.getValue(),view.minComB.getValue(), view.TextField));

        view.configure();

    }

    public ObservableList<String> getStations() throws SQLException {
        ArrayList<String> stations = model.SQLQueryStationNames();
        ObservableList<String> stationnames = FXCollections.observableArrayList(stations);
        return stationnames;
    }

    public ObservableList<Integer> getHours() {
        ArrayList<Integer> hours = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            hours.add(i);
        }
 return FXCollections.observableArrayList(hours);
    }

    public ObservableList<Integer> getMinutes() {
        ArrayList<Integer> mins = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            mins.add(i);
        }
        return FXCollections.observableArrayList(mins);
    }
    public void HandlerPrintTrainRoutes(String From, String To, Integer Hour, Integer Minutes, TextArea txtArea){
        txtArea.clear();
        txtArea.appendText(" Train, From Station: Departure -> To station: arrival \n");
        double time=(double) Hour +((double) Minutes/100);
        try {
            ArrayList<TrainInfo> trips = model.QueryforDepartures(From, To, time);  //method
            for (int i = 0; i < trips.size(); i++) {
                String deptime = String.format("%.2f", trips.get(i).departuretime);
                String arrtime = String.format("%.2f", trips.get(i).arrivaltime);
                txtArea.appendText(i + ";" + trips.get(i).startstation + ": " + deptime + " -> " + trips.get(i).endstation + ": " + arrtime + "\n");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

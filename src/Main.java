import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    public void start(Stage primaryStage) {
        trainView view = new trainView();
        TrainModel model = new TrainModel("jdbc:sqlite:C:\\Users\\Bruger\\IdeaProjects\\FXtrainJDBC\\src\\TrainData.db");
        TrainController controller = null;

        try{
            controller = new TrainController(view, model);
        }
        catch ( SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        primaryStage.setTitle("Train Trip Finder");
        primaryStage.setScene(new Scene(view.asParent(), 600,472));
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);

    }
}
/*
        String url="jdbc:sqlite:C:Users\Bruger\IdeaProjects\traindata.db";
        TrainModel TDB=new TrainModel(url);
        try {
         conn = DriverManager.getConnection(url);
            TDB.connectToTrainData();
            stmt= conn.createStatement();
            TDB.CreateStatement();
            rs=stmt.executeQuery(sql);
            TDB.SQLQueryStationNames();
            while(rs!=null && rs.next()){
                String name=rs.getString(1);
                System.out.println(name);
            }
            TDB.PstmtRetrieveDeparturesforStation();
            TDB.QueryforDepartures();

        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
                try {
                    TDB.closeTrainDataConnection();
                }catch (SQLException e2){

            }
        }
    }
}
*/



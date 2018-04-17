import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class gui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

        @Override
        public void start(Stage primaryStage) {

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));

            Label userName = new Label("Podaj swoje imie: ");
            grid.add(userName, 0, 1);

            TextField userTextField = new TextField();
            grid.add(userTextField, 1, 1,2,1);


            Label pytanie1 = new Label("1 pytanie: ");
            grid.add(pytanie1, 0, 4);

            ToggleGroup odpowiedz1 = new ToggleGroup();

            RadioButton odp1A = new RadioButton("a");
            odp1A.setUserData("RadioButton1");
            odp1A.setToggleGroup(odpowiedz1);
            odp1A.setSelected(true);
            grid.add(odp1A, 1, 4);

            RadioButton odp1B = new RadioButton("b");
            odp1B.setUserData("RadioButton2");
            odp1B.setToggleGroup(odpowiedz1);
            grid.add(odp1B, 2, 4);

            RadioButton odp1C = new RadioButton("c");
            odp1C.setUserData("RadioButton3");
            odp1C.setToggleGroup(odpowiedz1);
            odp1C.setSelected(true);
            grid.add(odp1C, 3, 4);

            RadioButton odp1D = new RadioButton("d");
            odp1D.setUserData("RadioButton4");
            odp1D.setToggleGroup(odpowiedz1);
            grid.add(odp1D, 4, 4);

            // 2 pytanie

            Label pytanie2 = new Label("2 pytanie: ");
            grid.add(pytanie2, 0, 5);

            ToggleGroup odpowiedz2 = new ToggleGroup();

            RadioButton odp2A = new RadioButton("a");
            odp2A.setUserData("RadioButton1");
            odp2A.setToggleGroup(odpowiedz2);
            odp2A.setSelected(true);
            grid.add(odp2A, 1, 5);

            RadioButton odp2B = new RadioButton("b");
            odp2B.setUserData("RadioButton2");
            odp2B.setToggleGroup(odpowiedz2);
            grid.add(odp2B, 2, 5);

            RadioButton odp2C = new RadioButton("c");
            odp2C.setUserData("RadioButton3");
            odp2C.setToggleGroup(odpowiedz2);
            odp2C.setSelected(true);
            grid.add(odp2C, 3, 5);

            RadioButton odp2D = new RadioButton("d");
            odp2D.setUserData("RadioButton4");
            odp2D.setToggleGroup(odpowiedz2);
            grid.add(odp2D, 4, 5);

            // 3 pytanie
            Label pytanie3 = new Label("3 pytanie: ");
            grid.add(pytanie3, 0, 6);

            ToggleGroup odpowiedz3 = new ToggleGroup();

            RadioButton odp3A = new RadioButton("a");
            odp3A.setUserData("RadioButton1");
            odp3A.setToggleGroup(odpowiedz3);
            odp3A.setSelected(true);
            grid.add(odp3A, 1, 6);

            RadioButton odp3B = new RadioButton("b");
            odp3B.setUserData("RadioButton2");
            odp3B.setToggleGroup(odpowiedz3);
            grid.add(odp3B, 2, 6);

            RadioButton odp3C = new RadioButton("c");
            odp3C.setUserData("RadioButton3");
            odp3C.setToggleGroup(odpowiedz3);
            odp3C.setSelected(true);
            grid.add(odp3C, 3, 6);

            RadioButton odp3D = new RadioButton("d");
            odp3D.setUserData("RadioButton4");
            odp3D.setToggleGroup(odpowiedz3);
            grid.add(odp3D, 4, 6);

            // 4 pytanie
            Label pytanie4 = new Label("4 pytanie: ");
            grid.add(pytanie4, 0, 7);

            ToggleGroup odpowiedz4 = new ToggleGroup();

            RadioButton odp4A = new RadioButton("a");
            odp4A.setUserData("RadioButton1");
            odp4A.setToggleGroup(odpowiedz4);
            odp4A.setSelected(true);
            grid.add(odp4A, 1, 7);

            RadioButton odp4B = new RadioButton("b");
            odp4B.setUserData("RadioButton2");
            odp4B.setToggleGroup(odpowiedz4);
            grid.add(odp4B, 2, 7);

            RadioButton odp4C = new RadioButton("c");
            odp4C.setUserData("RadioButton3");
            odp4C.setToggleGroup(odpowiedz4);
            odp4C.setSelected(true);
            grid.add(odp4C, 3, 7);

            RadioButton odp4D = new RadioButton("d");
            odp4D.setUserData("RadioButton4");
            odp4D.setToggleGroup(odpowiedz4);
            grid.add(odp4D, 4, 7);

            Button btn = new Button("Zatwierdz");
            HBox hbBtn = new HBox(10);
            hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtn.getChildren().add(btn);
            grid.add(hbBtn, 4, 8);

            Scene scene = new Scene(grid, 600, 500);
            primaryStage.setTitle("Ankieta");
            primaryStage.setScene(scene);
            primaryStage.show();
        }


}

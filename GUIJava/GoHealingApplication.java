import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GoHealingApplication extends Application {
    private GoHealingUser user;
    

    @Override
    public void start(Stage primaryStage) {
        user = new GoHealingUser("John Doe");

        Button placeOrderButton = new Button("Place Order");
        Button calculateTotalButton = new Button("Calculate Total");

        placeOrderButton.setOnAction(event -> new PlaceOrderWindow(user));
        calculateTotalButton.setOnAction(event -> new CalculateTotalWindow(user));

        VBox root = new VBox(20, placeOrderButton, calculateTotalButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setBackground(new Background(new BackgroundFill(Color.web("#F0F0F0"), CornerRadii.EMPTY, Insets.EMPTY)));

        placeOrderButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        calculateTotalButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        placeOrderButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        calculateTotalButton.setStyle("-fx-background-color: #FF5722; -fx-text-fill: white;");

        placeOrderButton.setPrefSize(200, 50);
        calculateTotalButton.setPrefSize(200, 50);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Go Healing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
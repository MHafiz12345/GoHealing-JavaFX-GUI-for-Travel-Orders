import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.UUID;

public class PlaceOrderWindow {
    private Stage stage;
    private GridPane gridPane;
    private TextField distanceField, numDaysField;
    private ComboBox<String> orderTypeComboBox;
    private GoHealingUser user;

    public PlaceOrderWindow(GoHealingUser user) {
        this.user = user;
        stage = new Stage();
        stage.setTitle("Place Order");
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Label orderTypeLabel = new Label("Order Type:");
        gridPane.add(orderTypeLabel, 0, 0);

        orderTypeComboBox = new ComboBox<>();
        orderTypeComboBox.getItems().addAll("PlaneTicket", "TrainTicket", "HotelRoomRental", "CarRental");
        orderTypeComboBox.valueProperty().addListener((obs, oldValue, newValue) -> handleOrderTypeChange(newValue));
        gridPane.add(orderTypeComboBox, 1, 0);

        Label distanceLabel = new Label("Distance (km):");
        gridPane.add(distanceLabel, 0, 1);

        distanceField = new TextField();
        gridPane.add(distanceField, 1, 1);

        Label numDaysLabel = new Label("Number of Days:");
        gridPane.add(numDaysLabel, 0, 2);

        numDaysField = new TextField();
        gridPane.add(numDaysField, 1, 2);

        Button placeOrderButton = new Button("Place Order");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(placeOrderButton);
        gridPane.add(hBox, 1, 3);

        placeOrderButton.setOnAction(event -> placeOrder());

        Scene scene = new Scene(gridPane, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void handleOrderTypeChange(String orderType) {
        if (orderType == null) {
            distanceField.setVisible(true);
            numDaysField.setVisible(true);
        } else {
            switch (orderType) {
                case "PlaneTicket":
                case "TrainTicket":
                    distanceField.setVisible(true);
                    numDaysField.setVisible(false);
                    break;
                case "HotelRoomRental":
                case "CarRental":
                    distanceField.setVisible(false);
                    numDaysField.setVisible(true);
                    break;
            }
        }
    }

    private void placeOrder() {
        String orderType = orderTypeComboBox.getValue();
        double distance = distanceField.isVisible() ? Double.parseDouble(distanceField.getText()) : 0;
        int numDays = numDaysField.isVisible() ? Integer.parseInt(numDaysField.getText()) : 0;
        Order order;
        String orderId = UUID.randomUUID().toString(); // Generate unique order ID

        switch (orderType) {
            case "PlaneTicket":
                order = new PlaneTicket(orderId, distance);
                break;
            case "TrainTicket":
                order = new TrainTicket(orderId, distance);
                break;
            case "HotelRoomRental":
                order = new HotelRoomRental(orderId, numDays);
                break;
            case "CarRental":
                order = new CarRental(orderId, numDays);
                break;
            default:
                return;
        }

        user.addOrder(order);
        distanceField.clear();
        numDaysField.clear();
    }
}
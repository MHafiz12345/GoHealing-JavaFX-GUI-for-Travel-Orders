import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.Locale;

public class CalculateTotalWindow {
    private Stage stage;
    private GoHealingUser user;

    public CalculateTotalWindow(GoHealingUser user) {
        this.user = user;
        stage = new Stage();
        stage.setTitle("Calculate Total");

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20));
        vBox.setStyle("-fx-background-color: #F0F0F0;");

        double total = user.calculateAllTransactions();

        Label totalLabel = new Label("Total: ");
        totalLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        vBox.getChildren().add(totalLabel);

        Label totalAmountLabel = new Label();
        totalAmountLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        totalAmountLabel.setStyle("-fx-text-fill: #4CAF50;");
        vBox.getChildren().add(totalAmountLabel);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String formattedTotal = currencyFormat.format(total);
        totalAmountLabel.setText(formattedTotal);

        Label orderDetailsLabel = new Label("Order Details:");
        orderDetailsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        vBox.getChildren().add(orderDetailsLabel);

        int orderCount = 1;
        for (Order order : user.getOrderList()) {
            double transaction = order.calculateTransaction();
            double discount = order.calculateDiscount();

            String orderType = order.getClass().getSimpleName();

            String orderDetails = String.format("Order %d:\nOrder Type: %s\nTransaction: %s\nDiscount: %s",
                    orderCount, orderType, currencyFormat.format(transaction), currencyFormat.format(discount));

            Label orderLabel = new Label(orderDetails);
            orderLabel.setFont(Font.font("Arial", 14));
            orderLabel.setWrapText(true);
            vBox.getChildren().add(orderLabel);
            orderCount++;
        }

        Scene scene = new Scene(vBox, 600, 600);
        stage.setScene(scene);
        stage.show();
    }
}
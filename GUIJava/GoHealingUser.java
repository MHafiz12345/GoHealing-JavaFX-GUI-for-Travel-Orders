import java.util.ArrayList;

public class GoHealingUser {
    public String userName;
    private ArrayList<Order> orderList;

    public GoHealingUser(String userName) {
        this.userName = userName;
        this.orderList = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void removeOrder(int index) {
        orderList.remove(index);
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public double calculateAllTransactions() {
        double total = 0;
        for (Order order : orderList) {
            total += order.calculateTransaction() - order.calculateDiscount();
        }
        return total;
    }
}
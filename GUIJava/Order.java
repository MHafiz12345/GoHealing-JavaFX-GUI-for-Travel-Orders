abstract class Order implements Discount {
    private String id;

    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract double calculateTransaction();

    public abstract double calculateDiscount();
}
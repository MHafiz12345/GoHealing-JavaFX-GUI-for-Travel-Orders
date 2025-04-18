abstract class Travel extends Order implements Discount {
    protected double distance;

    public Travel(String id, double distance) {
        super(id);
        this.distance = distance;
    }

    public abstract double calculateDiscount();

    public abstract double calculateTransaction();
}
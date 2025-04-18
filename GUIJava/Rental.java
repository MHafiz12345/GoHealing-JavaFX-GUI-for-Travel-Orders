abstract class Rental extends Order {
    protected int numDays;

    public Rental(String id, int numDays) {
        super(id);
        this.numDays = numDays;
    }

    public int getNumDays() {
        return numDays;
    }

    public abstract double calculateTransaction();
}

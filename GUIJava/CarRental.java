class CarRental extends Rental {
    public CarRental(String id, int numDays) {
        super(id, numDays);
    }

    @Override
    public double calculateTransaction() {
        return 500000 * numDays;
    }

    @Override
    public double calculateDiscount() {
        return (numDays >= 3 && numDays <= 7) ? 0.15 * calculateTransaction() : 0; 
    }
}
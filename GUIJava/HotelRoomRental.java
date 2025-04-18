class HotelRoomRental extends Rental {
    public HotelRoomRental(String id, int numDays) {
        super(id, numDays);
    }

    @Override
    public double calculateTransaction() {
        return 1500000 * numDays;
    }

    @Override
    public double calculateDiscount() {
        int discountPeriod = 10; 
        double discountRate = 0.05; 
        double maxDiscount = 0.3; 
        int fullPeriods = numDays / discountPeriod;
        double discount = fullPeriods * discountRate;
        discount = Math.min(discount, maxDiscount); 
        return discount * calculateTransaction();
    }
}
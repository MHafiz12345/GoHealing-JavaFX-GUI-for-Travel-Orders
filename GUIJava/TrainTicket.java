class TrainTicket extends Travel {
    public TrainTicket(String id, double distance) {
        super(id, distance);
    }

    @Override
    public double calculateTransaction() {
        return 750 * distance;
    }

    @Override
    public double calculateDiscount() {
        return distance < 100 ? 0.1 * calculateTransaction() : 0; 
    }
}
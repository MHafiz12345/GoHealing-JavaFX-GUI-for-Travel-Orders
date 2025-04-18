class PlaneTicket extends Travel {
    public PlaneTicket(String id, double distance) {
        super(id, distance);
    }

    @Override
    public double calculateTransaction() {
        return 4000 * distance;
    }

    @Override
    public double calculateDiscount() {
        return 0; 
    }
}
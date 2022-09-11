class ParkingSystem {
    int[] freeParking = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        freeParking[0] = big;
        freeParking[1] = medium;
        freeParking[2] = small;
    }
    
    public boolean addCar(int carType) {
        if (freeParking[carType - 1] > 0) {
            freeParking[carType - 1] = freeParking[carType - 1] - 1;
        } else {
            return false;
        }

        return true;
    }
}

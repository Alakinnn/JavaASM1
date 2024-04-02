package Database;

import Customer.Customer;

import java.util.Random;

public interface Recordable {
    Random RANDOM_ID_GENERATOR = new Random();
    default String generateID() {
        if (this instanceof Customer) {
            int randomNumber = RANDOM_ID_GENERATOR.nextInt(1, 10000001);
            return String.format("%07d", randomNumber);
        } else {
            int randomNumber = RANDOM_ID_GENERATOR.nextInt(1, 1000000001);
            return String.format("%09d", randomNumber);
        }
    }
    String getID();
    String setID();
}

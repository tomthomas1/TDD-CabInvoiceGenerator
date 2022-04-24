package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;

    // Method to calculate fare
    public double calculateFare(double distance, int time) {
       double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
       if(totalFare < MINIMUM_FARE)
           return MINIMUM_FARE;
       return totalFare;
    }

    // Method to calculate fare for multiple rides
    public double calculateFare(Ride[] rides){
        double totalFare =0;
        for ( Ride ride : rides){
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    // Method to calculate enhanced invoice with total rides and average fare.
    public InvoiceSummary calculateFareEnhanced(Ride[] rides){
        double totalFare =0;
        for ( Ride ride : rides){
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare, totalFare/ rides.length);
    }

    // Method to add multiple users and calculate enhanced fare
    public InvoiceSummary calculateFareEnhanced(int i, HashMap<Integer, Ride[]> rideRepo) {

        for (Map.Entry<Integer, Ride[]> rideEntry : rideRepo.entrySet()) {
            if (rideEntry.getKey() == i)
                return calculateFareEnhanced(rideEntry.getValue());
        }
        return null;
    }
}

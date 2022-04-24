package com.bridgelabz;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class InvoiceServiceTest {
    InvoiceGenerator invoice;
    RideRepository rideRepository = new RideRepository();
    HashMap<Integer, Ride[]> rideRepo;
    @Before
    public void initialization() {

        invoice = new InvoiceGenerator();
        rideRepo = rideRepository.getRideRepo();
    }


    // UC1 : Calculate Fare
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
       double fare = invoiceGenerator.calculateFare(distance, time);
       assertEquals(25, fare, 0.0);
    }

    //UC 1: Minimum fare
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(5, fare, 0.0);
    }
    // UC 2 : Multiple Rides
    @Test
    public void givenMultipleRides_ShouldReturnTotalFare(){
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        double fare = invoice.calculateFare(rides);
        assertEquals(30, fare,0.0);
    }

    //UC 3 : Enhanced Invoice
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary(){
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoice.calculateFareEnhanced(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30, 15);
        assertEquals(summary, expectedInvoiceSummary);
    }

    // UC 4 : With User-Id get the list from Repo and return invoice.
    @Test
    public void GivenUserId_getListOfRideFromRepo_returnInvoice() {

        Ride[] rides1 = { new Ride(0.1, 2), new Ride(10, 3) };
        Ride[] rides2 = { new Ride(3, 2), new Ride(1, 3), new Ride(150, 300) };
        Ride[] rides3 = { new Ride(5, 7) };

        rideRepo.put(1, rides1);
        rideRepo.put(2, rides2);
        rideRepo.put(3, rides3);

        InvoiceSummary invoices = new InvoiceSummary(3, 1845, 615);

        assertEquals(invoices, invoice.calculateFareEnhanced(2, rideRepo));
    }

}

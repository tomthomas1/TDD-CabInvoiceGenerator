package com.bridgelabz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvoiceServiceTest {
    InvoiceGenerator invoice;
    @Before
    public void initialization() {
        invoice = new InvoiceGenerator();
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

}

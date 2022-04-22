package com.bridgelabz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvoiceServiceTest {

    // UC1 : Calculate Fare
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
       double fare = invoiceGenerator.calculateFare(distance, time);
       assertEquals(25, fare, 0.0);
    }
}

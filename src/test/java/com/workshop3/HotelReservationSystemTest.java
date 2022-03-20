package com.workshop3;

/**
 * import Assertions class
 * import test class
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * creating a class name as HotelReservationSystemTest
 */
public class HotelReservationSystemTest {

    //uc1
    @Test
    public void givenHotelNamesWhenAddedShouldReturnSize() {
        HotelReservationSystem obj = new HotelReservationSystem();
        obj.addHotel();
        Assertions.assertEquals(3, obj.hotelReservation.size());
    }
}
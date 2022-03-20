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

    //UC1
    @Test
    public void givenHotelNamesWhenAddedShouldReturnSize() {
        HotelReservationSystem obj = new HotelReservationSystem();
        obj.addHotel();
        Assertions.assertEquals(3, obj.hotelReservation.size());
    }
     // Output :- True test case passed


    //UC2
    @Test
    public void givenDateRangeShouldReturnTheCheapestHotelRate() {
        HotelReservationSystem  obj = new HotelReservationSystem();
        obj.addHotel();
        Assertions.assertEquals(220, obj.findCheapestHotel("2020-09-10", "2020-09-11"));
    }
      //  Output :-
      //  The cheapest hotel is Lakewood, Rating : 3, Total Rates = $220


    //UC3
    @Test
    public void givenWeekDayWeekEndRatesShouldReturnThoseRates() {
        HotelReservationSystem obj = new HotelReservationSystem();
        obj.addHotel();
        Assertions.assertEquals(90, obj.hotelReservation.get("Lakewood").getWeekendRate());
        Assertions.assertEquals(50, obj.hotelReservation.get("Bridgewood").getWeekendRate());
        Assertions.assertEquals(150, obj.hotelReservation.get("Ridgewood").getWeekendRate());
    }
     // Output :- True test case passed


    //UC4
    @Test
    public void givenDateRangeShouldReturnTheCheapestHotelRateForWeekdayAndWeekend() {
        HotelReservationSystem obj = new HotelReservationSystem();
        obj.addHotel();
        Assertions.assertEquals(200, obj.findCheapestHotelForWeekdayAndWeekend("2020-09-11", "2020-09-12"));
    }
      //  Output :-
      //  The cheapest hotels are Bridgewood and Lakewood, Total Rates = $200


    //UC5
    @Test
    public void givenRatingShouldReturnsThoseRatings() {
        HotelReservationSystem obj = new  HotelReservationSystem();
        obj.addHotel();
        Assertions.assertEquals(5, obj.hotelReservation.get("Ridgewood").getRating());
        Assertions.assertEquals(4, obj.hotelReservation.get("Bridgewood").getRating());
        Assertions.assertEquals(3, obj.hotelReservation.get("Lakewood").getRating());
    }
      // Output :- True test case passed


    //UC6
    @Test
    public void givenDateRangeShouldReturnTheCheapestBestRatedHotel() {
        HotelReservationSystem obj = new HotelReservationSystem();
        obj.addHotel();
        Assertions.assertEquals(200, obj.findCheapestBestBestRatedHotel("2020-09-11", "2020-09-12"));
    }
      //Output :-
      // The cheapest hotel is Bridgewood, Rating 4, Total Rates = $200


    //UC7
      @Test
      public void givenDateRangeShouldReturnTheBestRatedHotel() {
          HotelReservationSystem obj = new  HotelReservationSystem();
          obj.addHotel();
          Assertions.assertEquals(370, obj.findBestRatedHotel("2020-09-11", "2020-09-12"));
      }
      // Output :-
      // The Best Rated hotel is: Ridgewood, Rating: 5, Total Rates = $370
}


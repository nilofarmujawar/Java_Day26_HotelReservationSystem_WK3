package com.workshop3;// package name

/**
 * UC1 :- Ability to add Hotel in a Hotel Reservation System with Name and rates for Regular Customer...
 */

/**
 * import hashmap class
 * import map class
 */
import java.util.HashMap;
import java.util.Map;
/**
 * create a class name as HotelReservationSystem
 */
public class HotelReservationSystem {
    /**
     * 1. Creating map of Hotel
     * 2. creating an object name as hotelReservation
     */
    Map<String, Hotel> hotelReservation = new HashMap<>();

    /**
     * Method for adding Hotel to the HotelReservationSystem
     */
    public void addHotel() {
        /**
         *A) Creating Hotels objects and pass the parameter as hotel names,rating,weekdayRate,weekend rate,
         *   special weekday rate,special weekend rate.
         */
        Hotel obj1 = new Hotel("Lakewood", 3, 110, 90, 80, 80);
        Hotel obj2 = new Hotel("Bridgewood", 4, 150, 50, 110, 50);
        Hotel obj3 = new Hotel("Ridgewood", 5, 220, 150, 100, 40);
        /**
         * b) Adding hotel to hotelReservation.
         *    hotelReservation is object of hotel class
         */
        /**
         * 1) put 1st hotel lakewood
         */
        hotelReservation.put(obj1.getHotelName(), obj1);
        /**
         * 2) put 2nd hotel Bridgewood
         */
        hotelReservation.put(obj2.getHotelName(), obj2);
        /**
         * 3) put 2nd hotel Ridgewood
         */
        hotelReservation.put(obj3.getHotelName(), obj3);
    }

    /**
     * create a main method,all program execute in main method
     * @param args no arguments
     */
    public static void main(String[] args) {

        /**
         * 1st display welcome msg
         */
        System.out.println("Welcome to the Hotel Reservation System");
        /**
         * create object for HotelReservationSystem class and object name is hotel
         */
        HotelReservationSystem hotel = new HotelReservationSystem();
        /**
         * calling addHotel method from object name as hotel
         */
        hotel.addHotel();

    }

}

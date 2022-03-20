package com.workshop3;// package name

/**
 * UC1 :- Ability to add Hotel in a Hotel Reservation System with Name and rates for Regular Customer...
 * UC2 :- Ability to find the cheapest Hotel for a given Date Range.
 *         - I/P – 10Sep2020, 11Sep2020
 *         - O/P – Lakewood, Total Rates: $220
 */

/**
 * import DayOfWeek class
 * import LocalDate class
 * import java.util.* = import all class in this package
 * import Collectors class
 */
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * create a class name as HotelReservationSystem
 */
public class HotelReservationSystem {
    /**
     * Creating map of Hotel
     * creating an object name as hotelReservation
     */
    Map<String, Hotel> hotelReservation = new HashMap<>();

    /**
     * Method for adding Hotel to the HotelReservationSystem
     */
    public void addHotel() {
        /**
         * Creating Hotels objects and pass the parameter as hotel names,rating,weekdayRate,weekend rate,
         * special weekday rate,special weekend rate.
         */
        Hotel obj1 = new Hotel("Lakewood", 3, 110, 90, 80, 80);
        Hotel obj2 = new Hotel("Bridgewood", 4, 150, 50, 110, 50);
        Hotel obj3 = new Hotel("Ridgewood", 5, 220, 150, 100, 40);
        /**
         * Adding hotel to hotelReservation.
         * hotelReservation is object of hotel class
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
     * create a method name as enterDates
     * Method for inputting the dates from user
     */
    public void enterDates() {
        /**
         * 1. create a scanner class object
         * 2. scanner class is used to taking i/p from user
         */
        Scanner sc = new Scanner(System.in);
        /**
         * 3. 1St display the "Enter the 2 dates in yyyymmdd format: " msg
         */
        System.out.println("Enter the 2 dates in yyyymmdd format: ");
        /**
         * 4. put 1st date 2020/09/10
         */
        String date1 = sc.nextLine();
        /**
         * 5. put 2nd date 2020/09/11
         */
        String date2 = sc.nextLine();
        /**
         * 6. find cheapeast hotel for 2 days
         * 7. O/P:- The cheapest hotel is Lakewood, Rating : 3, Total Rates = $220
         */
        findCheapestHotel(date1, date2);
    }

    /**
     * creating a parameterized method name as findCheapestHotel.
     * this Method for finding the cheapest Hotel for given dates
     *
     * @param d1 day1 is passed as String parameter
     * @param d2 day2 is passed as String parameter
     * @return returns the cheapest total rates
     */
    public int findCheapestHotel(String d1, String d2) {
        /**
         * getting the parsed local date for day1 and day2
         */
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();

        List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekdayRate)).collect(Collectors.toList());
        /**
         *  The cheapest hotel is Lakewood, Rating : 3, Total Rates = $220
         */
        System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekdayRate() * 2);
        /**
         * Cheapest Hotel in list is lakewood = 110 rate;
         * lakewood.110 * 2;
         * lakwood = 220 for 2 days .
         */
        return (hotelObjList.get(0).getWeekdayRate() * 2);
    }

    /**
     * create a main method,all program execute in main method
     *
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
        /**
         * calling enterDates method from object name as hotel
         */
        hotel.enterDates();
    }
}
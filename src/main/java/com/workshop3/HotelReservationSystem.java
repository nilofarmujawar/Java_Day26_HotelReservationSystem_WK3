package com.workshop3;// package name

/**
 * UC1 :- Ability to add Hotel in a Hotel Reservation System with Name and rates for Regular Customer...
 * UC2 :- Ability to find the cheapest Hotel for a given Date Range.
 *         - I/P – 10Sep2020, 11Sep2020
 *         - O/P – Lakewood, Total Rates: $220
 * UC3 :- Ability to add weekday and weekend rates for each Hotel
 *         - For Lakewood Weekday & Weekend Rates per day is $110 & $90
 *         - For Bridgewood $150 and $50
 *         - For Ridgewood $220 and $150
 * UC4 :- Ability to find the cheapest Hotel for a given Date Range based on weekday and weekend
 *        - I/P – 11Sep2020, 12Sep2020
 *        - O/P – Lakewood and Bridgewood with Total Rates $200
 * UC5 :- Ability to add ratings to each Hotel
 *        - Lakewood is 3, Bridgewood is 4 and Ridgewood is 5
 *
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
     * creating a parameterized method name as findCheapestHotelForWeekdayAndWeekend.
     *  Method for finding the cheapest Hotel for given dates
     *
     * @param d1 day1 is passed as String parameter
     * @param d2 day2 is passed as String parameter
     * @return returns the cheapest total rates
     */
    public int findCheapestHotelForWeekdayAndWeekend(String d1, String d2) {
        /**
         * variable
         */
        int weekEnds = 0;
        /**
         * getting the parsed local date for day1 and day2
         */
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
        /**
         * using logical or operator.
         * they returns true if one of the conditions is true
         * check if day1 is sunday or saturday
         */
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        /**
         * check if day2 is sunday or saturday
         */
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (weekEnds == 0) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekdayRate)).collect(Collectors.toList());
            System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Total Rates = $" + hotelObjList.get(0).getWeekdayRate() * 2);
            return hotelObjList.get(0).getWeekdayRate() * 2;

        } else if (weekEnds == 2) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekendRate)).collect(Collectors.toList());
            /**
             * The cheapest hotel is Lakewood, Rating : 3, Total Rates = $220
             */
            System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Total Rates = $" + hotelObjList.get(0).getWeekendRate() * 2);
            /**
             * in the list lakewood is 0th index and lakewood rate is 110
             * for 2 days rate is :- lakewood =110 * 2 =220
             */
            return hotelObjList.get(0).getWeekendRate() * 2;
            /**
             * if 1st condition is not true then else statement execute
             */
        } else {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.avgRate)).collect(Collectors.toList());
            /**
             *  check lakewood and Bridgewood avrgRate same or not
             */
            if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate()) {
                /**
                 * op-The cheapest hotels are Bridgewood and Lakewood, Total Rates = $200
                 */
                System.out.println("The cheapest hotels are " + hotelObjList.get(0).getHotelName() + " and " + hotelObjList.get(1).getHotelName() + ", Total Rates = $" + (hotelObjList.get(0).getAvgRate()));
                return hotelObjList.get(0).getAvgRate();
                /**
                 * if condition is false then execute else statement
                 */
            } else {
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Total Rates = $" + (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
                return hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate();
            }
        }
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
        /**
         * calling enterDates method from object name as hotel
         */
        hotel.enterDates();

        /**
         * calling findCheapestHotelForWeekdayAndWeekend method from object name as hotel
         */
        hotel.findCheapestHotelForWeekdayAndWeekend("2020-09-11", "2020-09-12");
    }

}

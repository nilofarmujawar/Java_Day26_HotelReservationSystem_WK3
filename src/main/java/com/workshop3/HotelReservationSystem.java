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
 * UC6 :- Ability to find the cheapest best rated hotel Hotel for a given Date Range
 *        - I/P – 11Sep2020, 12Sep2020
 *        - O/P – Bridgewood, Rating: 4 and Total Rates: $200
 * UC7 :- Ability to find the Best Rated Hotel for a given Date Range
 *        - I/P – 11Sep2020, 12Sep2020
 *        - O/P - Ridgewood & Total Rates $370
 * UC8 :- not giving in problem statement
 * UC9 :- Ability to add special rates for reward customers as  part of Loyalty Program
 *        - For Lakewood for Reward Customer Weekday & Weekend Rates per day is $80 & $80
 *        - For Bridgewood $110 and $50
 *        - For Ridgewood $100 and $40
 * UC10 :- Ability to find the cheapest best rated hotel Hotel for a given Date Range for a Reward Customer
 *         - Ability to validate the user inputs for Date Range and  customer type
 *         - Throw Exceptions for invalid entries
 *         - I/P – 11Sep2020, 12Sep2020
 *         - O/P – Ridgewood, Rating: 5 and Total Rates: $140
 *         Ability to find the cheapest best
 * UC11 :- rated hotel Hotel for a given Date Range for a Reward Customer using Java Streams
 *          - Use Regex Validation, Exceptions and Java 8 Date Feature
 *          - I/P – 11Sep2020, 12Sep2020
 *          - O/P – Ridgewood, Rating: 5 and Total Rates: $140
 * UC12 :- Ability to find the cheapest best rated hotel Hotel for a given Date Range for a Regular Customer using Java Streams
 *          - Use Regex Validation, Exceptions and Java 8 Date Feature
 *
 */

/**
 * import DayOfWeek class
 * import LocalDate class
 * import java.util.* = import all class in this package
 * import Collectors class
 * import matcher class
 * import pattern class
 */
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
         * 1.Creating Hotels objects and pass the parameter as hotel names,rating,weekdayRate,weekend rate,
         * 2.special weekday rate,special weekend rate.
         */
        Hotel obj1 = new Hotel("Lakewood", 3, 110, 90, 80, 80);
        Hotel obj2 = new Hotel("Bridgewood", 4, 150, 50, 110, 50);
        Hotel obj3 = new Hotel("Ridgewood", 5, 220, 150, 100, 40);
        /**
         * 2.Adding hotel to hotelReservation.
         * 3.hotelReservation is object of hotel class
         */
        /**
         * a) put 1st hotel lakewood
         */
        hotelReservation.put(obj1.getHotelName(), obj1);
        /**
         * b) put 2nd hotel Bridgewood
         */
        hotelReservation.put(obj2.getHotelName(), obj2);
        /**
         * c) put 2nd hotel Ridgewood
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
         *1. getting the parsed local date for day1 and day2
         */
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();

        /**
         * 2.
         *  a) Here, we've made a list of Hotel objects.
         *  b) We're streaming that list, and using the sorted() method with a Comparator.
         *  c) we're using the comparing() method, and supplying the weekdayRate the comparing() method,
         *     which accepts a sorting key function  just like the other ones.
         *  d) All of them simply return a comparator, with the passed function as the sorting key.
         *  e) If we wanted save the results of sorting after the program was executed,
         *     we would have to collect() the data back in a Collection
         *
         */
        List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekdayRate)).collect(Collectors.toList());
        /**
         * 3. The cheapest hotel is Lakewood, Rating : 3, Total Rates = $220
         */
        System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekdayRate() * 2);
        /**
         * 4.
         * a) Cheapest Hotel in list is lakewood = 110 rate;
         * b) lakewood.110 * 2;
         * c) lakwood = 220 for 2 days .
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
         * 1. variable
         */
        int weekEnds = 0;
        /**
         * 2.getting the parsed local date for day1 and day2
         */
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
        /**
         * 3.
         *  a) using logical or operator.
         *  b) they returns true if one of the conditions is true
         *  c) check if day1 is sunday or saturday
         */
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        /**
         * 4.check if day2 is sunday or saturday
         */
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (weekEnds == 0) {
            /**
             * 5.
             *  a) Here, we've made a list of Hotel objects.
             *  b) We're streaming that list, and using the sorted() method with a Comparator.
             *  c) we're using the comparing() method, and supplying the weekdayRate the comparing() method,
             *     which accepts a sorting key function  just like the other ones.
             *  d) All of them simply return a comparator, with the passed function as the sorting key.
             *  e) If we wanted save the results of sorting after the program was executed,
             *     we would have to collect() the data back in a Collection
             *
             */
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekdayRate)).collect(Collectors.toList());
            /**
             * 6. The cheapest hotel is Lakewood, Rating : 3, Total Rates = $220
             */
            System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Total Rates = $" + hotelObjList.get(0).getWeekdayRate() * 2);
            /**
             * 7.
             *  a) in this list 0th position is lakewood
             *  b) lakewood = weekdayrate * 2
             *  c)        = 110 * 2
             *  d)        =$220
             */
            return hotelObjList.get(0).getWeekdayRate() * 2;

            /**
             * 8.condition checked if 1st is false then checked else if condition if its true then this condition is executed
             */
        } else if (weekEnds == 2) {
            /**
             * 9.
             *  a) Here, we've made a list of Hotel objects.
             *  b) We're streaming that list, and using the sorted() method with a Comparator.
             *  c) we're using the comparing() method, and supplying the weekendRate the comparing() method,
             *     which accepts a sorting key function  just like the other ones.
             *  d) All of them simply return a comparator, with the passed function as the sorting key.
             *  e) If we wanted save the results of sorting after the program was executed,
             *     we would have to collect() the data back in a Collection
             *
             */
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekendRate)).collect(Collectors.toList());

            System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Total Rates = $" + hotelObjList.get(0).getWeekendRate() * 2);
            /**
             * 10.
             *  a) in the list lakewood is 0th index and lakewood weekendrate is 90
             *  b) for 2 days rate is :- lakewood =90 * 2 =180
             */
            return hotelObjList.get(0).getWeekendRate() * 2;
            /**
             * 11. if 1st condition is not true then else statement execute
             */
        } else {
            /**
             * 12.
             *  a) Here, we've made a list of Hotel objects.
             *  b) We're streaming that list, and using the sorted() method with a Comparator.
             *  c) we're using the comparing() method, and supplying the avgRate the comparing() method,
             *      which accepts a sorting key function  just like the other ones.
             *  d) All of them simply return a comparator, with the passed function as the sorting key.
             *  e) If we wanted save the results of sorting after the program was executed,
             *      we would have to collect() the data back in a Collection
             *
             */
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.avgRate)).collect(Collectors.toList());
            /**
             * 13. check lakewood and Bridgewood avrgRate same or not
             */
            if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate()) {
                /**
                 * 14. op-The cheapest hotels are Bridgewood and Lakewood, Total Rates = $200
                 */
                System.out.println("The cheapest hotels are " + hotelObjList.get(0).getHotelName() + " and " + hotelObjList.get(1).getHotelName() + ", Total Rates = $" + (hotelObjList.get(0).getAvgRate()));
                return hotelObjList.get(0).getAvgRate();
                /**
                 * 15. if condition is false then execute else statement
                 */
            } else {
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Total Rates = $" + (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
                /**
                 * 16.
                 *   a) lakwood is 0th index in hotel list
                 *   b) weekday rate + weekend rate
                 *   c) 110 + 90
                 *   d) $200
                 */
                return hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate();
            }
        }
    }
    /**
     * create a parameterized method name as findCheapestBestBestRatedHotel
     * Method for finding the cheapest Hotel for given dates
     *
     * @param d1 day1 is passed as String parameter
     * @param d2 day2 is passed as String parameter
     * @return returns the cheapest total rates
     */
    public int findCheapestBestBestRatedHotel(String d1, String d2) {
        /**
         * 1. variables
         */
        int weekEnds = 0;
        /**
         * 2. getting the parsed local date for day1 and day2
         */
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
        /**
         * 3.
         *  a) using logical or operator.
         *  b) they returns true if one of the conditions is true
         *  c) check if day1 is sunday or saturday
         */
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        /**
         * 4. check if day2 is sunday or saturday
         */
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (weekEnds == 0) {
            /**
             * 5.
             *  a) Here, we've made a list of Hotel objects.
             *  b) We're streaming that list, and using the sorted() method with a Comparator.
             *  c) we're using the comparing() method, and supplying the weekdayRate the comparing() method,
             *     which accepts a sorting key function  just like the other ones.
             *  d) All of them simply return a comparator, with the passed function as the sorting key.
             *  e) If we wanted save the results of sorting after the program was executed,
             *     we would have to collect() the data back in a Collection
             *
             */
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekdayRate)).collect(Collectors.toList());
            /**
             * 6. The cheapest hotel is Lakewood, Rating : 3, Total Rates = $220
             */
            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekdayRate() * 2);
            /**
             * 7.
             *  a) in 0th position is lakewood in the hotel list
             *  b) weekdayrate * 2
             *  c) 110 * 2
             *  d) $220
             */
            return hotelObjList.get(0).getWeekdayRate() * 2;
        }
        /**
         * 8. condition checked if 1st is false then checked else if condition if its true then this condition is executed
         */
        if (weekEnds == 2) {
            /**
             * 9
             *  a) Here, we've made a list of Hotel objects.
             *  b) We're streaming that list, and using the sorted() method with a Comparator.
             *  c) we're using the comparing() method, and supplying the weekendRate the comparing() method,
             *     which accepts a sorting key function  just like the other ones.
             *  d) All of them simply return a comparator, with the passed function as the sorting key.
             *  e) If we wanted save the results of sorting after the program was executed,
             *     we would have to collect() the data back in a Collection
             *
             */
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekendRate)).collect(Collectors.toList());

            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekendRate() * 2);
            /**
             * 10.
             *  a) in the list lakewood is 0th index and lakewood weekendrate is 90
             *  b) for 2 days rate is :- lakewood =90 * 2 =180
             */
            return hotelObjList.get(0).getWeekendRate() * 2;
        }
        /**
         * 11.
         *  a) Here, we've made a list of Hotel objects.
         *  b) We're streaming that list, and using the sorted() method with a Comparator.
         *  c) we're using the comparing() method, and supplying the avgRate the comparing() method,
         *      which accepts a sorting key function  just like the other ones.
         *  d) All of them simply return a comparator, with the passed function as the sorting key.
         *  e) If we wanted save the results of sorting after the program was executed,
         *      we would have to collect() the data back in a Collection
         *
         */
        List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.avgRate)).collect(Collectors.toList());
        /**
         * 12. check the condition comparing the 2 hotels avgrate lakewood and bridgewood
         */
        if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate() && hotelObjList.get(0).getRating() < hotelObjList.get(1).getRating()) {
            System.out.println("The cheapest hotel is " + hotelObjList.get(1).getHotelName() + ", Rating " + hotelObjList.get(1).getRating() + ", Total Rates = $" + (hotelObjList.get(1).getWeekdayRate() + hotelObjList.get(1).getWeekendRate()));
            /**
             * 13.
             *   a) 1st position in hotel list is Bridgewood
             *   b) AvgRate = weekdayrate + weekendrate
             *   c)     = 160 + 60
             *   d)    =220
             */
            return hotelObjList.get(1).getAvgRate();
        }
        if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate() && hotelObjList.get(0).getRating() > hotelObjList.get(1).getRating()) {

            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(0).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
            /**
             * 14.
             *   a) lakewood is 0th position
             *   b) avgrate= weekdayrate + weekendrate
             *   c)    110 + 90 = 200
             */
            return hotelObjList.get(0).getAvgRate();
            /**
             * 15. if condition is false then execute else statement
             */
        } else {
            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(0).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
            /**
             * 16. lakewood = 110 + 90 = $200
             */
            return hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate();
        }
    }

    /**
     * Method to find the Best Rated Hotel
     * @param d1 day1 is passed as String parameter
     * @param d2 day2 is passed as String parameter
     * @return returns the best rated hotel
     */
    public int findBestRatedHotel(String d1, String d2) {
        /**
         * 1. variable
         */
        int weekEnds = 0;
        /**
         * 2. getting the parsed local date for day1 and day2
         */
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
        /**
         * 3.
         *  a) using logical or operator.
         *  b) they returns true if one of the conditions is true
         *  c) check if day1 is sunday or saturday
         */
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        /**
         * 4. check if day2 is sunday or saturday
         */
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        /**
         * 5.
         *  a) Here, we've made a list of Hotel objects.
         *  b) We're streaming that list, and using the sorted() method with a Comparator.
         *  c) we're using the comparing() method, and supplying the rating the comparing() method,
         *     which accepts a sorting key function  just like the other ones.
         *  d) All of them simply return a comparator, with the passed function as the sorting key.
         *  e) If we wanted save the results of sorting after the program was executed,
         *     we would have to collect() the data back in a Collection
         *
         */
        List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.rating)).collect(Collectors.toList());
        if (weekEnds == 0) {
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + hotelObjList.get(2).getWeekdayRate() * 2);
            /**
             * 6.
             *   a) RidgeWood= Weekday rate * 2
             *   b)      = 220 * 2
             *   c)      = $440
             */
            return hotelObjList.get(2).getWeekdayRate() * 2;
        }
        if (weekEnds == 2) {

            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + hotelObjList.get(2).getWeekendRate() * 2);
            /**
             * 7.
             *   a) Ridgewood is 2nd no in hotel list
             *   b) Ridgewood = 150 * 2
             *   c)        =$ 300
             */
            return hotelObjList.get(2).getWeekendRate() * 2;
        } else {
            /**
             * 8. The Best Rated hotel is: Ridgewood, Rating: 5, Total Rates = $370
             */
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + (hotelObjList.get(2).getWeekdayRate() + hotelObjList.get(2).getWeekendRate()));
            /**
             * 9.
             *   a) Ridgewood = weekdayrate + WeekendRate
             *   b)       =$220 + $150
             *   c)       = $370
             */
            return (hotelObjList.get(2).getWeekdayRate() + hotelObjList.get(2).getWeekendRate());
        }
    }
    /**
     * Creating parameterized method name as findCheapestHotelForRewardCustomer
     * Method for finding the cheapest Hotel for given dates for Reward Customer
     *
     * @param d1 day1 is passed as String parameter
     * @param d2 day2 is passed as String parameter
     * @return returns the cheapest total rates
     */
    public int findCheapestHotelForRewardCustomer(String d1, String d2) {
        /**
         * 1. variable
         */
        int weekEnds = 0;
        /**
         * 2. getting the parsed local date for day1 and day2
         */
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
        /**
         * 3.
         *  a) using logical or operator.
         *  b) they returns true if one of the conditions is true
         *  c) check if day1 is sunday or saturday
         */
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        /**
         * 4. check if day2 is sunday or saturday
         */
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (weekEnds == 0) {
            /**
             * 5.
             *  a) Here, we've made a list of Hotel objects.
             *  b) We're streaming that list, and using the sorted() method with a Comparator.
             *  c) we're using the comparing() method, and supplying the specialWeekdayRate the comparing() method,
             *     which accepts a sorting key function  just like the other ones.
             *  d) All of them simply return a comparator, with the passed function as the sorting key.
             *  e) If we wanted save the results of sorting after the program was executed,
             *     we would have to collect() the data back in a Collection
             *
             */
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.specialWeekdayRate)).collect(Collectors.toList());
            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getSpecialWeekdayRate() * 2);
            /**
             * 6.
             *   a) 0th position is lakewood
             *   b) lakewood = special Weekday rate * 2
             *   c)      = 80 * 2
             *   d)      =$160
             */
            return hotelObjList.get(0).getSpecialWeekdayRate() * 2;
        }
        if (weekEnds == 2) {
            /**
             * 7.
             *  a) Here, we've made a list of Hotel objects.
             *  b) We're streaming that list, and using the sorted() method with a Comparator.
             *  c) we're using the comparing() method, and supplying the specialWeekdayRate the comparing() method,
             *     which accepts a sorting key function  just like the other ones.
             *  d) All of them simply return a comparator, with the passed function as the sorting key.
             *  e) If we wanted save the results of sorting after the program was executed,
             *     we would have to collect() the data back in a Collection
             *
             */
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.specialWeekendRate)).collect(Collectors.toList());
            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getSpecialWeekendRate() * 2);
            /**
             * 8.
             *   a) lakewood is 0th position in the hotel list
             *   b) lakewood = specialweekendrate * 2
             *   c)     = 80 * 2
             *   d)    = $160
             */
            return hotelObjList.get(0).getSpecialWeekendRate() * 2;
        } else {
            /**
             * 9
             *  a) Here, we've made a list of Hotel objects.
             *  b) We're streaming that list, and using the sorted() method with a Comparator.
             *  c) we're using the comparing() method, and supplying the specialAvgRate the comparing() method,
             *     which accepts a sorting key function  just like the other ones.
             *  d) All of them simply return a comparator, with the passed function as the sorting key.
             *  e) If we wanted save the results of sorting after the program was executed,
             *     we would have to collect() the data back in a Collection
             *
             */
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.specialAvgRate)).collect(Collectors.toList());
            if (hotelObjList.get(0).getSpecialAvgRate() == hotelObjList.get(1).getSpecialAvgRate() && hotelObjList.get(0).getRating() < hotelObjList.get(1).getRating()) {
                System.out.println("The cheapest hotel is " + hotelObjList.get(1).getHotelName() + ", Rating " + hotelObjList.get(1).getRating() + ", Total Rates = $" + (hotelObjList.get(1).getSpecialWeekdayRate() + hotelObjList.get(1).getSpecialWeekendRate()));
                /**
                 * 10.
                 *   a) Bridgewood is 1th position in hotel list
                 *   b) specialAvgRate = specialWeekdayRate + specialWeekendRate
                 *   c)             = 110 + 50
                 *   d)            = $160
                 */
                return hotelObjList.get(1).getSpecialAvgRate();
            }
            if (hotelObjList.get(0).getSpecialAvgRate() == hotelObjList.get(1).getSpecialAvgRate() && hotelObjList.get(0).getRating() > hotelObjList.get(1).getRating()) {
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(0).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getSpecialWeekdayRate() + hotelObjList.get(0).getSpecialWeekendRate()));
                /**
                 * 11.
                 *  a) 0th position is lakewood in hotel list
                 *  b) specialAvgRate = specialWeekdayRate + specialWeekendRate
                 *  c)              = 80 + 80
                 *  d)             =$160
                 *
                 */
                return hotelObjList.get(0).getSpecialAvgRate();
            } else {
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(0).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getSpecialWeekdayRate() + hotelObjList.get(0).getSpecialWeekendRate()));
                /**
                 * 12.
                 *   a) 0th position lakewood in hotel list
                 *   b) SpecialWeekdayrate + specialweekendrate
                 *   c) 80 + 80
                 *   d) $160
                 */
                return hotelObjList.get(0).getSpecialWeekdayRate() + hotelObjList.get(0).getSpecialWeekendRate();
            }
        }
    }
    /**
     * Method for validating date format using regex
     *
     * @param d1 takes in the date 1 String
     * @param d2 takes in the date 2 String
     * @return returns true if entered dates are valid
     */
    public boolean isDateValid(String d1, String d2) {
        /**
         * 1. Regex to check date.
         * a) ^ represents starting character of the string.
         * b) [0-9]{4} represents a digit must occur at least four time.
         * c) [0-9]{2} represents a digit must occur at least two time.
         * d) [0-9]{2} represents a digit must occur at least two time.
         * e) $ represents the end of the string.
         */
        String regex = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
        /**
         * 2. Compile the Regex
         */
        Pattern pattern = Pattern.compile(regex);
        /**
         * 3. Pattern class contains matcher() method to find matching between given date
         *    and regular expression.
         */
        Matcher matcher1 = pattern.matcher(d1);
        Matcher matcher2 = pattern.matcher(d2);
        /**
         * 4. Return if the date matched the Regex
         */
        return matcher1.matches() && matcher2.matches();
    }

    /**
     * create a main method,all program execute in main method
     * @param args no arguments
     */
    public static void main(String[] args) {

        /**
         * 1. 1st display welcome msg
         */
        System.out.println("Welcome to the Hotel Reservation System");
        /**
         * 2. create object for HotelReservationSystem class and object name is hotel
         */
        HotelReservationSystem hotel = new HotelReservationSystem();
        /**
         * 3. calling addHotel method from object name as hotel
         */
        hotel.addHotel();
        /**
         * 4. calling enterDates method from object name as hotel
         */
        hotel.enterDates();

        /**
         * 5. calling findCheapestHotelForWeekdayAndWeekend method from object name as hotel
         */
        hotel.findCheapestHotelForWeekdayAndWeekend("2020-09-11", "2020-09-12");
        /**
         * 6. calling findCheapestBestBestRatedHotel method from object name as hotel
         */
        hotel.findCheapestBestBestRatedHotel("2020-09-11", "2020-09-12");
        /**
         * 7. calling findBestRatedHotel method from object name as hotel
         */
        hotel.findBestRatedHotel("2020-09-11", "2020-09-12");
        /**
         * 8. calling findCheapestHotelForRewardCustomer method from object name as hotel
         */
        hotel.findCheapestHotelForRewardCustomer("2020-09-11", "2020-09-12");
    }

}

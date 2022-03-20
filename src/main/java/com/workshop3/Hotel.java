package com.workshop3;

/**
 * Hotel class for creating template for the hotel object
 */
class Hotel {
    /**
     * we are using enum for customer types.
     * In hotel reservation system there are two types of customer
     * 1) Regular
     * 2) reward
     */
    enum customer {
        REGULAR, REWARD;
    }

    /**
     * variables
     */
    String hotelName;
    int rating;
    int weekdayRate;
    int weekendRate;
    int specialWeekdayRate;
    int specialWeekendRate;

    /**
     * create a parameterized constructor
     * @param hotelName hotels name in hotel reservation system
     * @param rating rating of hotel
     * @param weekdayRate for customer
     * @param weekendRate for customer
     * @param specialWeekdayRate for customer
     * @param specialWeekendRate for customer
     */
    public Hotel(String hotelName, int rating, int weekdayRate, int weekendRate, int specialWeekdayRate, int specialWeekendRate) {
        /**
         *  "this" keyword is used to refer to the current object.
         */
        this.hotelName = hotelName;
        this.rating = rating;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.specialWeekdayRate = specialWeekdayRate;
        this.specialWeekendRate = specialWeekendRate;
    }
/**
 * 1) The get method returns the variable value, and the set method sets the value.
 * 2) "this" keyword is used to refer to the current object.
 */

    /**
     * The getHotelName method returns the value of the variable hotelName.
     * @return hotelName
     */
    public String getHotelName() {
        return hotelName;
    }
    /**
     * The setHotelName method takes a parameter (hotelName) and assigns it to the hotelName variable
     * @param hotelName taking in this Hotel reservation system.
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    /**
     * The getRating method returns the value of the variable rating.
     * @return rating
     */
    public int getRating() {
        return rating;
    }
    /**
     * The setRating method takes a parameter (rating) and assigns it to the rating variable
     * @param rating taking in this Hotel reservation system.
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    /**
     * The getWeekdayRate method returns the value of the variable weekdayRate.
     * @return weekdayRate
     */
    public int getWeekdayRate() {
        return weekdayRate;
    }
    /**
     * The setWeekdayRate method takes a parameter (weekdayRate) and assigns it to the weekdayRate variable
     * @param weekdayRate taking in this Hotel reservation system.
     */
    public void setWeekdayRate(int weekdayRate) {
        this.weekdayRate = weekdayRate;
    }
    /**
     * The getWeekendRate method returns the value of the variable weekendRate.
     * @return weekendRate
     */
    public int getWeekendRate() {
        return weekendRate;
    }
    /**
     * The setWeekendRate method takes a parameter (weekendRate) and assigns it to the weekendRate variable
     * @param weekendRate taking in this Hotel reservation system.
     */
    public void setWeekendRate(int weekendRate) {
        this.weekendRate = weekendRate;
    }
    /**
     * The getSpecialWeekdayRate method returns the value of the variable specialWeekdayRate.
     * @return specialWeekdayRate
     */
    public int getSpecialWeekdayRate() {
        return specialWeekdayRate;
    }
    /**
     * The setSpecialWeekdayRate method takes a parameter (specialWeekdayRate) and assigns it to the specialWeekdayRate variable
     * @param specialWeekdayRate taking in this Hotel reservation system.
     */
    public void setSpecialWeekdayRate(int specialWeekdayRate) {
        this.specialWeekdayRate = specialWeekdayRate;
    }
    /**
     * The getSpecialWeekendRate method returns the value of the variable  specialWeekendRat.
     * @return specialWeekendRate
     */
    public int getSpecialWeekendRate() {
        return specialWeekendRate;
    }
    /**
     * The setSpecialWeekendRate method takes a parameter (specialWeekendRate) and assigns it to the specialWeekendRate variable
     * @param specialWeekendRate taking in this Hotel reservation system.
     */
    public void setSpecialWeekendRate(int specialWeekendRate) {
        this.specialWeekendRate = specialWeekendRate;
    }
}

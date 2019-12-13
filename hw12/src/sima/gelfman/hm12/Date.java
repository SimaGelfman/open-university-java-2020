/**
 *
 * This class present a date object
 *
 * @author Sima Gelfman
 * @version 10-12-2019
 *
 */

package sima.gelfman.hm12;

public class Date {
    public static void main(String [] args){
        if(validateDate(30, 6, 2008) == true)
            System.out.println("true");
        else System.out.println("false");


    }
    // instance variables
    private int _day;
    private int _month;
    private int _year;

    private final int DEFAULT_DAY = 1;
    private final int DEFAULT_MONTH = 1;
    private final int DEFAULT_YEAR = 2000;


    /**
     * Constructs a new Date with the specified date, month and year
     * If one parameter is incorrect - constructs a default date
     *
     * @param day  The day
     * @param month The hour
     * @param year The year
     */

    public Date(int day, int month, int year) {
        if(validateDate( day, month, year) == true){
            _day = day;
            _month = month;
            _year = year;
        }
        else {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }

    }

    /**
     *Constructs a new Date equivalent to the given Date
     * @param other
     */

    public Date(Date other) {
        if(other != null){
            _day = other._day;
            _month = other._month;
            _year = other._year;
        }
        else {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }
    }

    //getters and setters

    /**
     * Returns the day of the current object
     *
     * @return The _day
     */

    public int getDay() {
        return _day;
    }

    /**
     * Returns the month of the current object
     * @return The _month
     */

    public int getMonth() {
        return _month;
    }

    /**
     * Returns the year of the current object
     * @return the _year
     */

    public int getYear() {
        return _year;
    }

    /**
     * Sets the day of the object (only if the given day is a valid day)
     *
     * @param dayToSet The day to set
     */
    public void setDay(int dayToSet) {
        if (validateDate( dayToSet, _month, _year) == true)
            _day = dayToSet;
    }

    /**
     * Sets the month of the object (only if the given month is a valid month)
     *
     * @param monthToSet The day to set
     */
    public void setMonth(int monthToSet) {
        if (validateDate( _day, monthToSet, _year) == true)
            _month = monthToSet;

    }

    /**
     * Sets the year of the object (only if the given year is a valid year)
     *
     * @param yearToSet The day to set
     */
    public void setYear(int yearToSet) {
        if (validateDate( _day, _month, yearToSet) == true)
            _year = yearToSet;
    }

    /**
     * Compare current object(Date) to given object(otherDate)
     * The method return true in case otherDate != null and both of objects are the same date
     *
     * @param otherDate
     * @return true when each attribute of given object equal to current object attributes
     */

    public boolean equals(Date otherDate) {
        if (otherDate == null)
            return false;
        if (_day == otherDate._day && _month == otherDate._month && _year == otherDate._year)
            return true;
        else return false;
    }


    /**
     *
     * @return The String representation of the Date object
     */
    public String toString() {
        return (_day < 10 ? "0" + _day : _day) + "/" + (_month < 10 ? "0" + _month : _month) + "/" + _year;
    }

    /**
     *
     * @param day
     * @param month
     * @param year
     * @return true when with the given day, month and year can be created valid date; @return false when with
     * given param cannot be created valid date
     * Param requirements are day should be between 1 and 31, month should be between 1 - 12,
     * year should consisted 4 digits
     * For feb
     */

    private static boolean validateDate(int day, int month, int year) {
        if (year < 1000 || year > 9999)
            return false;
        if (month < 1 || month > 12)
                return false;
        switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:{
                        if (day < 1 || day > 31)
                            return false;
                        break;
                    }
                    case 4:
                    case 6:
                    case 9:
                    case 11: {
                        if (day < 1 || day > 30)
                            return false;
                        break;
                    }
                    case 2: {
                        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                            if (day < 1 || day > 29)
                                return false;
                        } else {
                            if (day < 1 || day > 28)
                                return false;
                        }
                    }
         }
         return true;
    }

}
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
        if(validateValidDateParam(30, 12, 1000) == true)
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
     * Constructs a new Date with the specified date, month and minute
     * If one parameter is incorrect - constructs a default date
     *
     * @param day  The day
     * @param hour The hour
     * @param year The year
     */

    public Date(int day, int hour, int year) {


    }

    public Date(Date other) {

    }

    public int getDay() {
        return _day;
    }

    public int getMonth() {
        return _month;
    }

    public int getYear() {
        return _year;
    }

    /**
     * Sets the day of the object (only if the given day is a valid day)
     *
     * @param dayToSet The day to set
     */
    public void setDay(int dayToSet) {
        if (dayToSet >= 1 && dayToSet <= 31)
            _day = dayToSet;
    }

    public void setMonth(int monthToSet) {

    }

    public void setYear(int yearToSet) {

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

    public String toString() {
        return (_day < 10 ? "0" + _day : _day) + "/" + (_month < 10 ? "0" + _month : _month) + "/" + _year;
    }


    public static boolean validateValidDateParam(int day, int month, int year) {
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
                    case 12:
                        if (day < 1 || day > 31)
                            return false;

                    case 4:
                    case 6:
                    case 9:
                    case 11: {
                        if (day < 1 || day > 30)
                            return false;
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
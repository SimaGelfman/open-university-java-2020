/**
 * This class present a date object
 *
 * @author Sima Gelfman
 * @version 10-12-2019
 */

package sima.gelfman.hm12;

public class Date {

    // instance variables
    private int _day;
    private int _month;
    private int _year;

    private static final int DEFAULT_DAY = 1;
    private static final int DEFAULT_MONTH = 1;
    private static final int DEFAULT_YEAR = 2000;


    /**
     * Constructs a new Date with the specified date, month and year
     * If one parameter is incorrect - constructs a default date
     *
     * @param day   The day
     * @param month The hour
     * @param year  The year
     */

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            _day = day;
            _month = month;
            _year = year;
        } else {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }

    }

    /**
     * Constructs a new Date equivalent to the given Date
     *
     * @param other given Date
     */

    public Date(Date other) {
        if (other != null) {
            _day = other._day;
            _month = other._month;
            _year = other._year;
        } else {
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
     *
     * @return The _month
     */

    public int getMonth() {
        return _month;
    }

    /**
     * Returns the year of the current object
     *
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
        if (isValidDate(dayToSet, _month, _year))
            _day = dayToSet;
    }

    /**
     * Sets the month of the object (only if the given month is a valid month)
     *
     * @param monthToSet The day to set
     */
    public void setMonth(int monthToSet) {
        if (isValidDate(_day, monthToSet, _year))
            _month = monthToSet;

    }

    /**
     * Sets the year of the object (only if the given year is a valid year)
     *
     * @param yearToSet The day to set
     */
    public void setYear(int yearToSet) {
        if (isValidDate(_day, _month, yearToSet))
            _year = yearToSet;
    }

    //Methods

    /**
     * Compare current object(Date) to given object(otherDate)
     * The method return true in case otherDate != null and both of objects are the same date
     *
     * @param otherDate the date to compare this date to
     * @return true when each attribute of given object equal to current object attributes
     */

    public boolean equals(Date otherDate) {
        if (otherDate == null)
            return false;
        return (_day == otherDate._day &&
                _month == otherDate._month &&
                _year == otherDate._year
        );
    }


    /**
     * @return The String representation of the Date object
     */
    public String toString() {
        return (_day < 10 ? "0" : "") + _day + "/" + (_month < 10 ? "0" : "") + _month + "/" + _year;
    }

    /**
     * check if this date is before other date
     *
     * @param otherDate date to compare this date to
     * @return true if this date is before other date
     */

    public boolean before(Date otherDate) {
        if (otherDate == null)
            return false;
        if (_year < otherDate._year)
            return true;
        if (_year == otherDate._year && _month < otherDate._month)
            return true;
        if (_year == otherDate._year && _month == otherDate._month && _day < otherDate._day)
            return true;
        return false;
    }

    /**
     * check if this date is after other date
     *
     * @param otherDate date to compare this date to
     * @return true if this date is after other date
     */

    public boolean after(Date otherDate) {
        if (otherDate == null)
            return false;
        if (otherDate.before(this))
            return true;
        return false;
    }

    /**
     * calculates the difference in days between two dates
     *
     * @param otherDate the date to calculate the difference between
     * @return the number of days between the dates
     */

    public int difference(Date otherDate) {
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(otherDate._day, otherDate._month, otherDate._year));
    }

    /**
     * calculate the date of tomorrow
     *
     * @return tomorrow date
     */

    public Date tomorrow() {
        switch (_month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10: {
                if (_day == 31)
                    return new Date(1, _month + 1, _year);
                return new Date(_day + 1, _month, _year);
            }
            case 12: {
                if (_day == 31)
                    return new Date(1, 1, _year + 1);
                return new Date(_day + 1, _month, _year);
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                if (_day == 30)
                    return new Date(1, _month + 1, _year);
                return new Date(_day + 1, _month, _year);
            }
            case 2: {
                if (_year % 4 == 0 && _year % 100 != 0 || _year % 400 == 0) {
                    if (_day == 29)
                        return new Date(1, _month + 1, _year);
                } else {
                    if (_day == 28)
                        return new Date(1, _month + 1, _year);
                }
                return new Date(_day + 1, _month, _year);
            }


        }
        //this line is not reachable because all valid cases are coverage in switch;
        return null;
    }

    /**
     * Calculate current day in a week  with next rule: Saturday - 0; Sunday - 1; etc..
     *
     * @return current day in a week
     */

    public int dayInWeek() {
        int y = _year;
        int month = _month;

        if (_month < 3) {
            y--;
            month += 12;
        }
        int c = y / 100;
        y = y % 100;
        return ((_day + (26 * (month + 1)) / 10 + y + y / 4 + c / 4 - 2 * c) % 7 + 7) % 7;
    }


    /**
     * @param day   day for validation
     * @param month month for validation
     * @param year  year for validation
     * @return true when with the given day, month and year can be created valid date; @return false when with
     * given param cannot be created valid date
     * Param requirements are day should be between 1 and 31, month should be between 1 - 12,
     * year should consisted 4 digits
     */

    private static boolean isValidDate(int day, int month, int year) {
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
            case 12: {
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

    //computes the day number since the beginning of the Christian counting of years
    private static int calculateDate(int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
    }

}
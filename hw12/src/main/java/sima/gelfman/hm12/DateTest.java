package sima.gelfman.hm12;

public class DateTest {
    public static void main(String[] args) {
        {
            Date d1 = new Date(12, 2, 1999);
            Date d2 = new Date(12, 2, 1999);
            boolean actual = d1.after(d2);
            boolean expected = false;
            System.out.println("isAfter() on equal dates: " + (actual == expected ? "OK" : "FAILED"));
        }
        {
            Date d1 = new Date(23, 2, 1999);
            Date d2 = new Date(12, 2, 1999);
            boolean actual = d1.after(d2);
            boolean expected = true;
            System.out.println("isAfter() on d1 day > d2 day: " + (actual == expected ? "OK" : "FAILED"));
        }
        {
            Date d1 = new Date(12, 2, 1999);
            Date d2 = new Date(23, 2, 1999);
            boolean actual = d1.after(d2);
            boolean expected = false;
            System.out.println("isAfter() on d1 day < d2 day: " + (actual == expected ? "OK" : "FAILED"));
        }

        {
            Date d1 = new Date(12, 3, 1999);
            Date d2 = new Date(12, 2, 1999);
            boolean actual = d1.after(d2);
            boolean expected = true;
            System.out.println("isAfter() on d1 month > d2 month: " + (actual == expected ? "OK" : "FAILED"));
        }

        {
            Date d1 = new Date(12, 2, 1999);
            Date d2 = new Date(12, 2, 1999);

            System.out.println("diff between 2 dates is " + d1.difference(d2));
        }
        {

            Date d1 = new Date(1, 1, 1999);
            Date d2 = new Date(1, 1, 2000);

            System.out.println("diff between 2 dates is " + d1.difference(d2));
        }


        {
            Date d1 = new Date(12, 1, 2019);
            System.out.println("The day in a week should be 0: " + d1.dayInWeek());
        }

        {
            Date d1 = new Date(12, 2, 2019);
            System.out.println("The day in a week should be 3: " + d1.dayInWeek());
        }

        {
            Date d1 = new Date(29, 3, 2019);
            System.out.println("The day in a week should be 6: " + d1.dayInWeek());
        }

        {
            Date d1 = new Date(29, 2, 2000);
            System.out.println("The day in a week should be 3: " + d1.dayInWeek());
        }


        {
            Date d1 = new Date(29, 2, 1900);
            System.out.println(d1.toString());
            System.out.println("The day in a week should be 0: " + d1.dayInWeek());

        }

        {
            Date d1 = new Date(15, 1, 2009);
            System.out.println(d1.toString());
            System.out.println("The day in a week should be 5: " + d1.dayInWeek());
        }

        {
            Date d1 = new Date(1, 3, 2018);
            System.out.println(d1.toString());
            System.out.println("The day in a week should be 5: " + d1.dayInWeek());
        }


    }
}

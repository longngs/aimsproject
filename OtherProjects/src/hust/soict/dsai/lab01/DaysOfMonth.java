// 6.4 Number of days of a month
package hust.soict.dsai.lab01;

import java.util.Scanner;

public class DaysOfMonth {
    private static final String[][] MONTH_NAMES = {
            { "january", "jan.", "jan", "1" }, { "february", "feb.", "feb", "2" },
            { "march", "mar.", "mar", "3" }, { "april", "apr.", "apr", "4" },
            { "may", "may", "may", "5" }, { "june", "june", "jun", "6" },
            { "july", "july", "jul", "7" }, { "august", "aug.", "aug", "8" },
            { "september", "sept.", "sep", "9" }, { "october", "oct.", "oct", "10" },
            { "november", "nov.", "nov", "11" }, { "december", "dec.", "dec", "12" } };
    private static final int[] DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    /** @return month number 1..12, or -1 if invalid */
    public static int parseMonth(String input) {
        String s = input.trim().toLowerCase();
        for (int i = 0; i < 12; i++) {
            for (String name : MONTH_NAMES[i]) {
                if (name.equals(s)) return i + 1;
            }
        }
        return -1;
    }

    /** @return year, or -1 if invalid (must be all digits, non-negative) */
    public static int parseYear(String input) {
        String s = input.trim();
        if (!s.matches("\\d+")) return -1;
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static int daysOf(int month, int year) {
        if (month == 2 && isLeapYear(year)) return 29;
        return DAYS[month - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month, year;
        while (true) {
            System.out.print("Enter a month (e.g. January, Jan., Jan, 1): ");
            month = parseMonth(sc.nextLine());
            if (month != -1) break;
            System.out.println("Invalid month. Please enter again.");
        }
        while (true) {
            System.out.print("Enter a year (all digits, e.g. 1999): ");
            year = parseYear(sc.nextLine());
            if (year != -1) break;
            System.out.println("Invalid year. Please enter again.");
        }
        System.out.println("Month " + month + "/" + year + " has " + daysOf(month, year) + " days.");
        sc.close();
    }
}

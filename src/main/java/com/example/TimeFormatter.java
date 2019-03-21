package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class can parse a time string into a numerical value, add minutes to the parsed time value and format
 * the time value back into a string. The format of the time value must match the pattern, "[H]H:MM {AM|PM}". The
 * output format matches this pattern as well.
 */
public class TimeFormatter {

    private static String TIME_FORMAT = "^(\\d?\\d):(\\d\\d) (AM|PM)$";
    private static Pattern PATTERN = Pattern.compile(TIME_FORMAT);
    private static int ONE_DAY_IN_MINUTES = 1440;

    private int totalMinutes;

    /**
     * Parses the specified time string into a numeric value representing the minutes in a day. The time string
     * must match the pattern, "[H]H:MM {AM|PM}".
     *
     * @param timeStr Time string to parse
     */
    public TimeFormatter(String timeStr) throws Exception {
        Matcher matcher = PATTERN.matcher(timeStr);
        if (matcher.find()) {
            int hours = Integer.parseInt(matcher.group(1));
            if (hours < 0 || hours > 12) {
                throw new Exception("Invalid Time String. Hours must be: 0 <= Hours <= 12");
            }
            int minutes = Integer.parseInt(matcher.group(2));
            if (minutes >= 60 || minutes < 0 ) {
                throw new Exception("Invalid Time String. Minutes must be: 0 <= minutes < 60");
            }
            boolean isAM = matcher.group(3).equals("AM");
            if (isAM && hours == 12) {
                hours = 0;
            }
            if (!isAM) {
                if (hours < 12) {
                    hours += 12;
                }
            }
            totalMinutes = (hours * 60) + minutes;
        } else {
            throw new Exception("Invalid Time String Format");
        }
    }

    /**
     * Adds a number of minutes to add to the total minutes this object represents. The additionalMinutes can be
     * positive or negative.
     *
     * @param additionalMinutes The number of minutes to add to this object
     * @return This object is returned to allow for method chaining
     */
    public TimeFormatter addMinutes(int additionalMinutes) {
        totalMinutes += additionalMinutes;
        if (totalMinutes < 0) {
            totalMinutes += ONE_DAY_IN_MINUTES;
        }
        return this;
    }

    /**
     * Formats the total minutes this object represents into a string matching the pattern, "[H]H:MM {AM|PM}".
     * This format is the same as the input pattern used in the constructor.
     *
     * @return Formatted string using pattern, "[H]H:MM {AM|PM}".
     */
    public String format() {
        String amPm = "AM";
        int hours = (totalMinutes / 60) % 24;
        if (hours >= 12) {
            amPm = "PM";
            if (hours > 12) {
                hours -= 12;
            }
        }
        if (hours == 0) {
            hours = 12;
        }
        int minutes = totalMinutes % 60;
        return String.format("%d:%02d %s", hours, minutes, amPm);
    }
}

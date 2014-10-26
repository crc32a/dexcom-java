package org.cgarza.exp.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class DateTimeUtils {

    private static final DateTime EPOCH;
    private static final DateTimeFormatter sqlDateTimeFormat;
    private static final DateTimeFormatter isoFormat;

    static {
        EPOCH = new DateTime(2009, 1, 1, 0, 0, 0, 0, DateTimeZone.UTC);
        isoFormat = ISODateTimeFormat.dateTimeNoMillis();
        sqlDateTimeFormat = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");
    }

    public static DateTime convertTime(long dexSeconds) {
        return EPOCH.plusSeconds((int) dexSeconds);
    }
}

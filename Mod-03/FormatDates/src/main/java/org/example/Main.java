package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {



    public static void main(String[] args){// Get current time in UTC (GMT)

        //get GMT time
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));

        System.out.println(gmtTime);

        LocalDateTime currDateTime = LocalDateTime.now();
        System.out.println("Today is: " + currDateTime);


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nLOCAL TIME\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        formatLocalDateTime(currDateTime, "MM/dd/yyyy");
        formatLocalDateTime(currDateTime, "yyyy-MM-dd");
        formatLocalDateTime(currDateTime, "MMMM dd, yyyy");
        formatLocalDateTime(currDateTime, "E, MMM dd, yyyy hh:mm");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nGMT TIME\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        formatZonedDateTime(gmtTime, "MM/dd/yyyy");
        formatZonedDateTime(gmtTime, "yyyy-MM-dd");
        formatZonedDateTime(gmtTime, "MMMM dd, yyyy");
        formatZonedDateTime(gmtTime, "E, MMM dd, yyyy hh:mm");

    }

    public static void formatZonedDateTime(ZonedDateTime _dateTime, String _pattern){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(_pattern);
        String formattedDate = _dateTime.format(fmt);
        System.out.println(formattedDate);
    }

    public static void formatLocalDateTime(LocalDateTime _dateTime,String _pattern){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(_pattern);
        String formattedDate = _dateTime.format(fmt);
        System.out.println(formattedDate);
    }
}
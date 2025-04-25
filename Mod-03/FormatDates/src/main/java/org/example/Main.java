package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class Main {



    public static void main(String[] args){
        TimeZone tz = TimeZone.getTimeZone("GMT");
        LocalDateTime currDateTime = LocalDateTime.now();
        System.out.println("Today is: " + currDateTime);

        formatDateTime(currDateTime, "MM/dd/yyyy");
        formatDateTime(currDateTime, "yyyy-MM-dd");
        formatDateTime(currDateTime, "MMMM dd, yyyy");
        formatDateTime(currDateTime, "E, MMM dd, yyyy hh:mm");

    }

    public static void formatDateTime(LocalDateTime _dateTime,String _pattern){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(_pattern);
        String formattedDate = _dateTime.format(fmt);
        System.out.println(formattedDate);
    }
}
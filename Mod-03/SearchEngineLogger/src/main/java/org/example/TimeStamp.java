package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStamp {
    public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
    public static LocalDateTime currDateTime;
    public static String formattedDate;

    public TimeStamp() {

    }

    public static void log(BufferedWriter _write, String _log) throws IOException {
        currDateTime = LocalDateTime.now();
        String formattedDate = currDateTime.format(fmt);
        String fLog = String.format("%s %s\n",formattedDate, _log);
        //WriteDateTime yyyy-MM-dd hh:mm:ss then text
        //System.out.printf(fLog);
        _write.write(fLog);
    }
}

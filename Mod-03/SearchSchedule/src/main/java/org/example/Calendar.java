package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class Calendar {

    private static ArrayList<Event> contents = new ArrayList<Event>();
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    public static void readFile(BufferedReader _br) throws IOException {

        _br.readLine();//skip header


        String dataLine = _br.readLine();
        while(dataLine != null) {
            String[] fields = dataLine.split("\\|");

            Event nEvent = new Event(LocalDate.parse(fields[0]), LocalTime.parse(fields[1]), fields[2]);
            contents.add(nEvent);
            dataLine = _br.readLine();
        }
    }

    public static void sortEvents(){
        contents.sort(Comparator.comparing(Event::getDate).reversed());
    }

    public static void displayEvents(){
        for (Event event : contents){
            System.out.println(event.getDate());
        }
    }
}

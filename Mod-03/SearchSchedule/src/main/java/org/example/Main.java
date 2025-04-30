package org.example;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

import java.io.*;


public class Main {

    public static final String fileName = "calendar.csv";

    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(fileName,true);
            BufferedWriter bw = new BufferedWriter(fw);


            String dataLine = br.readLine();

            String header = "Date|Time|Description";
            if (dataLine == null ||  !dataLine.equals(header)) {
                prependFile(header, bw, br, dataLine);
            }

            br.close();
            bw.close();
            //reset readfile
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            Calendar.readFile(br);
            Calendar.displayEvents();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Calendar.sortEvents();
            Calendar.displayEvents();

        }catch (IOException e){
            System.out.println("File Write Error");
            e.printStackTrace();
        }
    }

    public static void prependFile(String _prependText, BufferedWriter _bw, BufferedReader _br, String _firstLine){
        try {
            ArrayList<String> tempFile = new ArrayList<String>();
            tempFile.add(_prependText);
            if(_firstLine != null) tempFile.add(_firstLine);
            String dataLine = _br.readLine();
            while (dataLine != null) {
                tempFile.add(dataLine);
                dataLine = _br.readLine();
            }

            _bw.close();
            FileWriter fw = new FileWriter(fileName);
            _bw = new BufferedWriter(fw);

            for (String line: tempFile){
                _bw.write(line);
                _bw.newLine();
                System.out.println(line);
            }
            _bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void reportScreen() {
        System.out.println("");
    }
}
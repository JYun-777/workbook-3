package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;


public class Event {

    private LocalTime time;
    private LocalDate date;
    private String description;

    public Event(){
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.description = "Default Event";
    }

    public Event(LocalDate _date, LocalTime _time, String _description) {
        this.date = _date;
        this.time = _time;
        this.description = _description;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate _date) {
        this.date = _date;
    }

    public LocalTime getTime(){
        return this.time;
    }

    public void setTime(LocalTime _time) {
        this.time = LocalTime.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

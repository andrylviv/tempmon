package com.tempmon.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity // This tells Hibernate to make a table out of this class
public class Temperature {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime date_time;

    private Double temperature;

    public void setDateTime(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
package com.project.farmmanagement.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Entity
public class SoilMoisture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String value;
    @DateTimeFormat
    private String dateAndTime;

    public SoilMoisture() {
    }

    public SoilMoisture(String value, String dateAndTime) {
        this.value = value;
        this.dateAndTime = dateAndTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @Override
    public String toString() {
        return "SoilMoisture{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", dateAndTime='" + dateAndTime + '\'' +
                '}';
    }
}


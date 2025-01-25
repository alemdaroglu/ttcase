package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class TransportationOperatingDays {

    private @Id
    @GeneratedValue Long id;

    private Boolean monday;
    private Boolean tuesday;
    private Boolean wednesday;
    private Boolean thursday;
    private Boolean friday;
    private Boolean saturday;
    private Boolean sunday;


    public TransportationOperatingDays() {

    }

    TransportationOperatingDays(
            Boolean monday,
            Boolean tuesday,
            Boolean wednesday,
            Boolean thursday,
            Boolean friday,
            Boolean saturday,
            Boolean sunday) {

        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }


    public Long getId() {
        return this.id;
    }


    public Boolean getMonday() {
        return this.monday;
    }
    public Boolean getTuesday() {
        return this.tuesday;
    }
    public Boolean getWednesday() {
        return this.wednesday;
    }
    public Boolean getThursday() {
        return this.thursday;
    }
    public Boolean getFriday() {
        return this.friday;
    }
    public Boolean getSaturday() {
        return this.saturday;
    }
    public Boolean getSunday() {
        return this.sunday;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMonday(Boolean monday) {
        this.monday = monday;
    }
    public void setTuesday(Boolean tuesday) {
        this.tuesday = tuesday;
    }
    public void setWednesday(Boolean wednesday) {
        this.wednesday = wednesday;
    }
    public void setThursday(Boolean thursday) {
        this.thursday = thursday;
    }
    public void setFriday(Boolean friday) {
        this.friday = friday;
    }
    public void setSaturday(Boolean saturday) {
        this.saturday = saturday;
    }
    public void setSunday(Boolean sunday) {
        this.sunday = sunday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TransportationOperatingDays tod))
            return false;
        return Objects.equals(this.id, tod.id)
                && Objects.equals(this.monday, tod.monday)
                && Objects.equals(this.tuesday, tod.tuesday)
                && Objects.equals(this.wednesday, tod.wednesday)
                && Objects.equals(this.thursday, tod.thursday)
                && Objects.equals(this.friday, tod.friday)
                && Objects.equals(this.saturday, tod.saturday)
                && Objects.equals(this.sunday, tod.sunday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id, this.monday, this.tuesday, this.wednesday,
                this.thursday, this.friday, this.saturday, this.sunday);
    }

    @Override
    public String toString() {
        return "TOD{" + "id=" + this.id + '}';
    }
}
package com.vcard.mk;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpeningHoursSpecification {
    @JsonProperty("@type")
    public String type;
    public String dayOfWeek;
    public String opens;
    public String closes;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OpeningHoursSpecification{" +
                "type='" + type + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", opens='" + opens + '\'' +
                ", closes='" + closes + '\'' +
                '}';
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getOpens() {
        return opens;
    }

    public void setOpens(String opens) {
        this.opens = opens;
    }

    public String getCloses() {
        return closes;
    }

    public void setCloses(String closes) {
        this.closes = closes;
    }
}

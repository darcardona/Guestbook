package com.habuma.guestbook;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class Guest {

    private String name;
    private String email;
    private Date dateOfVisit;

    public Guest(String name, String email, Date dateOfVisit) {
        this.name = name;
        this.email = email;
        this.dateOfVisit = dateOfVisit;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfVisit() {
        return dateOfVisit;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);
    }
}

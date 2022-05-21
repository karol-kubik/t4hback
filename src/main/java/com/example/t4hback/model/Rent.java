package com.example.t4hback.model;

import java.util.Date;

public class Rent {
    protected int id_rent;
    protected int id_guest;
    protected int id_owner;
    protected int id_housing;
    protected Date startDate;
    protected Date endDate;
    protected String state;
    protected int eval;
    protected String comment;

    public Rent(int id_rent, int id_guest, int id_owner, int id_housing, Date startDate, Date endDate, String state, int eval, String comment) {
        super();
        this.id_rent = id_rent;
        this.id_guest = id_guest;
        this.id_owner = id_owner;
        this.id_housing = id_housing;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.eval = eval;
        this.comment = comment;
    }

    public Rent(int id_guest, int id_owner, int id_housing, Date startDate, Date endDate, String state, int eval, String comment) {
        super();
        this.id_guest = id_guest;
        this.id_owner = id_owner;
        this.id_housing = id_housing;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.eval = eval;
        this.comment = comment;
    }

    public Rent(int id_rent, int eval, String comment) {
        super();
        this.id_rent = id_rent;
        this.eval = eval;
        this.comment = comment;
    }

    public int getId_housing() {
        return id_housing;
    }

    public void setId_housing(int id_housing) {
        this.id_housing = id_housing;
    }

    public int getId_rent() {
        return id_rent;
    }

    public void setId_rent(int id_rent) {
        this.id_rent = id_rent;
    }

    public int getId_guest() {
        return id_guest;
    }

    public void setId_guest(int id_guest) {
        this.id_guest = id_guest;
    }

    public int getId_owner() {
        return id_owner;
    }

    public void setId_owner(int id_owner) {
        this.id_owner = id_owner;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getEval() {
        return eval;
    }

    public void setEval(int eval) {
        this.eval = eval;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

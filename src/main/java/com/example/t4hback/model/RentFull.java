package com.example.t4hback.model;

import java.util.Date;

public class RentFull {

    protected String ownerFirstname;
    protected String ownerLastname;
    protected Integer ownerPhone;
    protected String housingTitle;
    protected String housingAddress;
    protected String housingCity;
    protected String guestFirstname;
    protected String guestLastname;
    protected Integer guestPhone;
    protected int id_rent;
    protected int id_guest;
    protected int id_owner;
    protected int id_housing;
    protected Date startDate;
    protected Date endDate;
    protected String state;
    protected int eval;
    protected String comment;

    public RentFull() {

    }

    public RentFull(String ownerFirstname, String ownerLastname, Integer ownerPhone, String housingTitle, String housingAddress, String housingCity, String guestFirstname, String guestLastname, Integer guestPhone, int id_rent, int id_guest, int id_owner, int id_housing, Date startDate, Date endDate, String state, int eval, String comment) {
        super();
        this.ownerFirstname = ownerFirstname;
        this.ownerLastname = ownerLastname;
        this.ownerPhone = ownerPhone;
        this.housingTitle = housingTitle;
        this.housingAddress = housingAddress;
        this.housingCity = housingCity;
        this.guestFirstname = guestFirstname;
        this.guestLastname = guestLastname;
        this.guestPhone = guestPhone;
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

    public RentFull(String ownerFirstname, String ownerLastname, Integer ownerPhone, String housingTitle, String housingAddress, String housingCity, int id_rent, int id_guest, int id_owner, int id_housing, Date startDate, Date endDate, String state, int eval, String comment) {
        super();
        this.ownerFirstname = ownerFirstname;
        this.ownerLastname = ownerLastname;
        this.ownerPhone = ownerPhone;
        this.housingTitle = housingTitle;
        this.housingAddress = housingAddress;
        this.housingCity = housingCity;
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

    public RentFull(String guestFirstname, String guestLastname, Integer guestPhone, String housingTitle, int id_rent, int id_guest, int id_owner, int id_housing, Date startDate, Date endDate, String state, int eval, String comment) {
        super();
        this.guestFirstname = guestFirstname;
        this.guestLastname = guestLastname;
        this.guestPhone = guestPhone;
        this.housingTitle = housingTitle;
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

    public String getOwnerFirstname() {
        return ownerFirstname;
    }

    public void setOwnerFirstname(String ownerFirstname) {
        this.ownerFirstname = ownerFirstname;
    }

    public String getOwnerLastname() {
        return ownerLastname;
    }

    public void setOwnerLastname(String ownerLastname) {
        this.ownerLastname = ownerLastname;
    }

    public Integer getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(Integer ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getHousingTitle() {
        return housingTitle;
    }

    public void setHousingTitle(String housingTitle) {
        this.housingTitle = housingTitle;
    }

    public String getHousingAddress() {
        return housingAddress;
    }

    public void setHousingAddress(String housingAddress) {
        this.housingAddress = housingAddress;
    }

    public String getHousingCity() {
        return housingCity;
    }

    public void setHousingCity(String housingCity) {
        this.housingCity = housingCity;
    }

    public String getGuestFirstname() {
        return guestFirstname;
    }

    public void setGuestFirstname(String guestFirstname) {
        this.guestFirstname = guestFirstname;
    }

    public String getGuestLastname() {
        return guestLastname;
    }

    public void setGuestLastname(String guestLastname) {
        this.guestLastname = guestLastname;
    }

    public Integer getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(Integer guestPhone) {
        this.guestPhone = guestPhone;
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

    public int getId_housing() {
        return id_housing;
    }

    public void setId_housing(int id_housing) {
        this.id_housing = id_housing;
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

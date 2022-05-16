package com.example.t4hback.model;

public class Housing {
    protected int id_housing;
    protected int id_owner;
    protected String title;
    protected String address;
    protected String city;
    protected String description;
    protected Boolean noSmoke;
    protected Boolean noiseCurfew;
    protected Boolean noChild;
    protected Boolean noPets;
    protected Boolean petKeep;
    protected Boolean plantWater;
    protected Boolean houseClean;

    public Housing(int id_housing, int id_owner, String title, String address, String city, String description, Boolean noSmoke, Boolean noiseCurfew, Boolean noChild, Boolean noPets, Boolean petKeep, Boolean plantWater, Boolean houseClean) {
        super();
        this.id_housing = id_housing;
        this.id_owner = id_owner;
        this.title = title;
        this.address = address;
        this.city = city;
        this.description = description;
        this.noSmoke = noSmoke;
        this.noiseCurfew = noiseCurfew;
        this.noChild = noChild;
        this.noPets = noPets;
        this.petKeep = petKeep;
        this.plantWater = plantWater;
        this.houseClean = houseClean;
    }

    public Housing(int id_owner, String title, String address, String city, String description, Boolean noSmoke, Boolean noiseCurfew, Boolean noChild, Boolean noPets, Boolean petKeep, Boolean plantWater, Boolean houseClean) {
        super();
        this.id_owner = id_owner;
        this.title = title;
        this.address = address;
        this.city = city;
        this.description = description;
        this.noSmoke = noSmoke;
        this.noiseCurfew = noiseCurfew;
        this.noChild = noChild;
        this.noPets = noPets;
        this.petKeep = petKeep;
        this.plantWater = plantWater;
        this.houseClean = houseClean;
    }

    public int getId_housing() {
        return id_housing;
    }

    public void setId_housing(int id_housing) {
        this.id_housing = id_housing;
    }

    public int getId_owner() {
        return id_owner;
    }

    public void setId_owner(int id_owner) {
        this.id_owner = id_owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getNoSmoke() {
        return noSmoke;
    }

    public void setNoSmoke(Boolean noSmoke) {
        this.noSmoke = noSmoke;
    }

    public Boolean getNoiseCurfew() {
        return noiseCurfew;
    }

    public void setNoiseCurfew(Boolean noiseCurfew) {
        this.noiseCurfew = noiseCurfew;
    }

    public Boolean getNoChild() {
        return noChild;
    }

    public void setNoChild(Boolean noChild) {
        this.noChild = noChild;
    }

    public Boolean getNoPets() {
        return noPets;
    }

    public void setNoPets(Boolean noPets) {
        this.noPets = noPets;
    }

    public Boolean getPetKeep() {
        return petKeep;
    }

    public void setPetKeep(Boolean petKeep) {
        this.petKeep = petKeep;
    }

    public Boolean getPlantWater() {
        return plantWater;
    }

    public void setPlantWater(Boolean plantWater) {
        this.plantWater = plantWater;
    }

    public Boolean getHouseClean() {
        return houseClean;
    }

    public void setHouseClean(Boolean houseClean) {
        this.houseClean = houseClean;
    }
}

package com.lff.poison.domain;

public class Par {
    private Integer breedId;

    private String breedName;

    private Integer toxinId;

    private String toxinName;

    private Float par;

    public Integer getBreedId() {
        return breedId;
    }

    public void setBreedId(Integer breedId) {
        this.breedId = breedId;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName == null ? null : breedName.trim();
    }

    public Integer getToxinId() {
        return toxinId;
    }

    public void setToxinId(Integer toxinId) {
        this.toxinId = toxinId;
    }

    public String getToxinName() {
        return toxinName;
    }

    public void setToxinName(String toxinName) {
        this.toxinName = toxinName == null ? null : toxinName.trim();
    }

    public Float getPar() {
        return par;
    }

    public void setPar(Float par) {
        this.par = par;
    }
}
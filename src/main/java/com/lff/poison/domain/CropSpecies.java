package com.lff.poison.domain;

public class CropSpecies {
    private Integer id;

    private String cropSpecies;

    private Integer cropCategoryId;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCropSpecies() {
        return cropSpecies;
    }

    public void setCropSpecies(String cropSpecies) {
        this.cropSpecies = cropSpecies == null ? null : cropSpecies.trim();
    }

    public Integer getCropCategoryId() {
        return cropCategoryId;
    }

    public void setCropCategoryId(Integer cropCategoryId) {
        this.cropCategoryId = cropCategoryId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CropSpecies{");
        sb.append("id=").append(id);
        sb.append(", cropSpecies='").append(cropSpecies).append('\'');
        sb.append(", cropCategoryId=").append(cropCategoryId);
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }
}
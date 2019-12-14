package com.lff.poison.domain;

import java.util.Date;
import java.util.List;

public class SampleInfo {
    private Integer id;
    private String sampleId;
    private Integer cropCategoryId;
    private Integer breed;//只能够获取主键id
    private String province;
    private String city;
    private String county;
    private String township;
    private String village;
    private String household;
    private Date harvestTime;
    private Date samplingTime;
    private String samplingPeople;
    private Float pollutionRate;
    private String pollutionRateStr;//真菌污染率字符串
    private Date createTime;
    private Integer isdel;
    private Date inputTime;
    private Integer flag;
    private Integer enterpeople;
    private String varieties;
    private String seasonal;
    private String description;
    //专门用于展示的时间字符串
    private String samplingTimeStr;//取样时间字符串
    private String inputTimeStr;//录入时间字符串
    private String toxinsss;//拼接完成的毒素
    //多对一 多个样品对应一个种类
    private  CropSpecies cropSpecies;//使用实体类类型的变量
    //一对多
    private List<SampleToxin> sampleToxinlist;//一个实体类当中有多个毒素（毒素的id）
    private List<SampleToxinInfo> sampleToxinInfolist;//毒素详细信息表也关联
    private List<BacterialStrainInfo> bacterialStrainInfoList;//菌株集合

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SampleInfo{");
        sb.append("id=").append(id);
        sb.append(", sampleId='").append(sampleId).append('\'');
        sb.append(", cropCategoryId=").append(cropCategoryId);
        sb.append(", breed=").append(breed);
        sb.append(", province='").append(province).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", county='").append(county).append('\'');
        sb.append(", township='").append(township).append('\'');
        sb.append(", village='").append(village).append('\'');
        sb.append(", household='").append(household).append('\'');
        sb.append(", harvestTime=").append(harvestTime);
        sb.append(", samplingTime=").append(samplingTime);
        sb.append(", samplingPeople='").append(samplingPeople).append('\'');
        sb.append(", pollutionRate=").append(pollutionRate);
        sb.append(", createTime=").append(createTime);
        sb.append(", isdel=").append(isdel);
        sb.append(", inputTime=").append(inputTime);
        sb.append(", flag=").append(flag);
        sb.append(", enterpeople=").append(enterpeople);
        sb.append(", varieties='").append(varieties).append('\'');
        sb.append(", seasonal='").append(seasonal).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", samplingTimeStr='").append(samplingTimeStr).append('\'');
        sb.append(", inputTimeStr='").append(inputTimeStr).append('\'');
        sb.append(", toxinsss='").append(toxinsss).append('\'');
        sb.append(", cropSpecies=").append(cropSpecies);
        sb.append(", sampleToxinlist=").append(sampleToxinlist);
        sb.append(", sampleToxinInfolist=").append(sampleToxinInfolist);
        sb.append(", bacterialStrainInfoList=").append(bacterialStrainInfoList);
        sb.append('}');
        return sb.toString();
    }

    public String getPollutionRateStr() {
        return pollutionRateStr;
    }

    public void setPollutionRateStr(String pollutionRateStr) {
        this.pollutionRateStr = pollutionRateStr;
    }
    public String getToxinsss() {
        return toxinsss;
    }

    public void setToxinsss(String toxinsss) {
        this.toxinsss = toxinsss;
    }

    public List<SampleToxin> getSampleToxinlist() {
        return sampleToxinlist;
    }

    public void setSampleToxinlist(List<SampleToxin> sampleToxinlist) {
        this.sampleToxinlist = sampleToxinlist;
    }

    public List<SampleToxinInfo> getSampleToxinInfolist() {
        return sampleToxinInfolist;
    }

    public void setSampleToxinInfolist(List<SampleToxinInfo> sampleToxinInfolist) {
        this.sampleToxinInfolist = sampleToxinInfolist;
    }

    public List<BacterialStrainInfo> getBacterialStrainInfoList() {
        return bacterialStrainInfoList;
    }

    public void setBacterialStrainInfoList(List<BacterialStrainInfo> bacterialStrainInfoList) {
        this.bacterialStrainInfoList = bacterialStrainInfoList;
    }

    public CropSpecies getCropSpecies() {
        return cropSpecies;
    }

    public void setCropSpecies(CropSpecies cropSpecies) {
        this.cropSpecies = cropSpecies;
    }

    public String getSamplingTimeStr() {
        return samplingTimeStr;
    }

    public void setSamplingTimeStr(String samplingTimeStr) {
        this.samplingTimeStr = samplingTimeStr;
    }

    public String getInputTimeStr() {
        return inputTimeStr;
    }

    public void setInputTimeStr(String inputTimeStr) {
        this.inputTimeStr = inputTimeStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId == null ? null : sampleId.trim();
    }

    public Integer getCropCategoryId() {
        return cropCategoryId;
    }

    public void setCropCategoryId(Integer cropCategoryId) {
        this.cropCategoryId = cropCategoryId;
    }

    public Integer getBreed() {
        return breed;
    }

    public void setBreed(Integer breed) {
        this.breed = breed;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township == null ? null : township.trim();
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village == null ? null : village.trim();
    }

    public String getHousehold() {
        return household;
    }

    public void setHousehold(String household) {
        this.household = household == null ? null : household.trim();
    }

    public Date getHarvestTime() {
        return harvestTime;
    }

    public void setHarvestTime(Date harvestTime) {
        this.harvestTime = harvestTime;
    }

    public Date getSamplingTime() {
        return samplingTime;
    }

    public void setSamplingTime(Date samplingTime) {
        this.samplingTime = samplingTime;
    }

    public String getSamplingPeople() {
        return samplingPeople;
    }

    public void setSamplingPeople(String samplingPeople) {
        this.samplingPeople = samplingPeople == null ? null : samplingPeople.trim();
    }

    public Float getPollutionRate() {
        return pollutionRate;
    }

    public void setPollutionRate(Float pollutionRate) {
        this.pollutionRate = pollutionRate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getEnterpeople() {
        return enterpeople;
    }

    public void setEnterpeople(Integer enterpeople) {
        this.enterpeople = enterpeople;
    }

    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties == null ? null : varieties.trim();
    }
    public String getSeasonal() {
        return seasonal;
    }

    public void setSeasonal(String seasonal) {
        this.seasonal = seasonal == null ? null : seasonal.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public SampleInfo(Integer id, String sampleId, Integer cropCategoryId, Integer breed, String province, String city, String county, String township, String village, String household, Date harvestTime, Date samplingTime, String samplingPeople, Float pollutionRate, Date createTime, Integer isdel, Date inputTime, Integer flag, Integer enterpeople, String varieties, String seasonal, String description) {
        this.id = id;
        this.sampleId = sampleId;
        this.cropCategoryId = cropCategoryId;
        this.breed = breed;
        this.province = province;
        this.city = city;
        this.county = county;
        this.township = township;
        this.village = village;
        this.household = household;
        this.harvestTime = harvestTime;
        this.samplingTime = samplingTime;
        this.samplingPeople = samplingPeople;
        this.pollutionRate = pollutionRate;
        this.createTime = createTime;
        this.isdel = isdel;
        this.inputTime = inputTime;
        this.flag = flag;
        this.enterpeople = enterpeople;
        this.varieties = varieties;
        this.seasonal = seasonal;
        this.description = description;
    }


    public SampleInfo() {
    }

}



package com.lff.poison.domain;

import java.util.Date;

public class BacterialStrainInfo {
    private Integer id;

    private Integer sampleInfoId;

    private String sampleNum;

    private String originalNum;

    private String wordAddr;

    private String txtAddr;

    private String pictureAddr;

    private Date createTime;

    private Integer isdel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSampleInfoId() {
        return sampleInfoId;
    }

    public void setSampleInfoId(Integer sampleInfoId) {
        this.sampleInfoId = sampleInfoId;
    }

    public String getSampleNum() {
        return sampleNum;
    }

    public void setSampleNum(String sampleNum) {
        this.sampleNum = sampleNum == null ? null : sampleNum.trim();
    }

    public String getOriginalNum() {
        return originalNum;
    }

    public void setOriginalNum(String originalNum) {
        this.originalNum = originalNum == null ? null : originalNum.trim();
    }

    public String getWordAddr() {
        return wordAddr;
    }

    public void setWordAddr(String wordAddr) {
        this.wordAddr = wordAddr == null ? null : wordAddr.trim();
    }

    public String getTxtAddr() {
        return txtAddr;
    }

    public void setTxtAddr(String txtAddr) {
        this.txtAddr = txtAddr == null ? null : txtAddr.trim();
    }

    public String getPictureAddr() {
        return pictureAddr;
    }

    public void setPictureAddr(String pictureAddr) {
        this.pictureAddr = pictureAddr == null ? null : pictureAddr.trim();
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
}
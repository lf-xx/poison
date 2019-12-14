package com.lff.poison.domain.dto;
/**
 * 查询参数
 * @author
 *
 */
public class SelectDto {

	//前台往后台传递参数的区域
	private String sampleId;//样品编号
	private Integer cropCategoryId;//农产品加工原料类别id(毒素)
	private Integer breed;//品种
	private String province;//省
	private String city;//市
	private String county;//县
	private String pollutionRate;//污染率
	private Integer toxin_id;//毒素id
	private String year;//年
	private String month;//月
	private String day;//日
	//后台当成参数往sql语句里面传递的参数
	private Integer leftNum;//污染率左参数
	private Integer rightNum;//污染率右参数
	//时间统一按照录入时间来查询
	private String inputTime;//
	private String inputTimeStr;//录入时间字符串
	private  String addressStr;//地址字符串

	public String getAddressStr() {
		return addressStr;
	}

	public void setAddressStr(String addressStr) {
		this.addressStr = addressStr;
	}

	public Integer getToxin_id() {
		return toxin_id;
	}

	public void setToxin_id(Integer toxin_id) {
		this.toxin_id = toxin_id;
	}

	public String getInputTimeStr() {
		return inputTimeStr;
	}

	public void setInputTimeStr(String inputTimeStr) {
		this.inputTimeStr = inputTimeStr;
	}

	public String getSampleId() {
		return sampleId;
	}

	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
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
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPollutionRate() {
		return pollutionRate;
	}

	public void setPollutionRate(String pollutionRate) {
		this.pollutionRate = pollutionRate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Integer getLeftNum() {
		return leftNum;
	}

	public void setLeftNum(Integer leftNum) {
		this.leftNum = leftNum;
	}

	public Integer getRightNum() {
		return rightNum;
	}

	public void setRightNum(Integer rightNum) {
		this.rightNum = rightNum;
	}

	public String getInputTime() {
		return inputTime;
	}

	public void setInputTime(String inputTime) {
		this.inputTime = inputTime;
	}

	public SelectDto(String sampleId, Integer cropCategoryId, Integer breed, String province, String city,
					 String county, String pollutionRate, String year, String month, String day, Integer leftNum,
					 Integer rightNum, String inputTime) {
		super();
		this.sampleId = sampleId;
		this.cropCategoryId = cropCategoryId;
		this.breed = breed;
		this.province = province;
		this.city = city;
		this.county = county;
		this.pollutionRate = pollutionRate;
		this.year = year;
		this.month = month;
		this.day = day;
		this.leftNum = leftNum;
		this.rightNum = rightNum;
		this.inputTime = inputTime;
	}

	@Override
	public String toString() {
		return "SelectDto [sampleId=" + sampleId + ", cropCategoryId=" + cropCategoryId + ", breed=" + breed
				+ ", province=" + province + ", city=" + city + ", county=" + county + ", pollutionRate="
				+ pollutionRate + ", year=" + year + ", month=" + month + ", day=" + day + ", leftNum=" + leftNum
				+ ", rightNum=" + rightNum + ", inputTime=" + inputTime + "]";
	}


	public SelectDto() {
		// TODO Auto-generated constructor stub
	}


}

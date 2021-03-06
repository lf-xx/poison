package com.lff.poison.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.lff.poison.domain.*;
import com.lff.poison.domain.dto.SelectDto;
import com.lff.poison.mapper.*;
import com.lff.poison.service.QueryService;
import com.lff.poison.util.DateUtils;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private SampleInfoMapper InfoMapper;
    @Autowired
    private AddressProvinceMapper addressProvinceMapper;
    @Autowired
    private AddressCityMapper cityMapper;
    @Autowired
    private AddressTownMapper townMapper;
    /*    @Autowired
        private ParMapper parMapper;*/
    @Autowired
    private CropSpeciesMapper speciesMapper;

    @Autowired
    private SampleToxinMapper sampleToxinMapper;
    @Autowired
    private BacterialStrainInfoMapper strainInfoMapper;



    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List<SampleInfo> queryAll() {
        List<SampleInfo> sampleInfos = InfoMapper.queryAll();
        // System.err.println(sampleInfos);
        for (int i = 0; i < sampleInfos.size(); i++) {
            sampleInfos.get(i).setSamplingTimeStr(DateUtils.dateFormat(sampleInfos.get(i).getSamplingTime(), "yyyy-MM-dd"));
          sampleInfos.get(i).setCreateTimeStr(DateUtils.dateFormat(sampleInfos.get(i).getCreateTime(),"yyyy-MM-dd"));
          if (sampleInfos.get(i).getHarvestTime()!=null&&!"".equals(sampleInfos.get(i).getHarvestTime())) {
              sampleInfos.get(i).setHarvestTimeStr(DateUtils.dateFormat(sampleInfos.get(i).getHarvestTime(), "yyyy-MM-dd"));
          }
            if (sampleInfos.get(i).getInputTime() != null && !"".equals(sampleInfos.get(i).getInputTime())) {
                sampleInfos.get(i).setInputTimeStr(DateUtils.dateFormat(sampleInfos.get(i).getInputTime(), "yyyy-MM-dd"));
            }
            //获取省的编码
            String province = sampleInfos.get(i).getProvince();
            //根据编码查询对象
            AddressProvince addressProvince = addressProvinceMapper.SelectByProvinceCode(province);
            //重新赋值
            if (StringUtil.isNotEmpty(addressProvince.getName())) {

                sampleInfos.get(i).setProvince(addressProvince.getName());
            }
            //获取市区的编码
            String city = sampleInfos.get(i).getCity();
            //根据城市编码查询对象
            AddressCity addressCity = cityMapper.SelectByAddressCityCode(city);
            //重新赋值
            if (addressCity.getName() != null && !"".equals(addressCity.getName())) {
                sampleInfos.get(i).setCity(addressCity.getName());
            }
            String county = sampleInfos.get(i).getCounty();
            AddressTown addressTown = townMapper.SelectByTownCode(county);
            if (addressTown.getName() != null && !"".equals(addressTown.getName())) {
                sampleInfos.get(i).setCounty(addressTown.getName());
            }

            //
            Float pollutionRate = sampleInfos.get(i).getPollutionRate();

            Float a = pollutionRate;
            //将float转为String
            String b = String.format("%1.1f", a);
            b = b + "%";
            sampleInfos.get(i).setPollutionRateStr(b);
            //System.out.println(sampleInfos);

       /*     List<BacterialStrainInfo> bacterialStrainInfoList = sampleInfos.get(i).getBacterialStrainInfoList();
            for (int j = 0; j <bacterialStrainInfoList.size() ; j++) {
                System.out.println(j);;
            }*/

        }

        return sampleInfos;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public PageInfo<SampleInfo> selectAll(Integer page, Integer pageSize) {
        List<SampleInfo> sampleInfos = InfoMapper.selectAll();

        // System.err.println(sampleInfos);
        for (int i = 0; i < sampleInfos.size(); i++) {
            sampleInfos.get(i).setSamplingTimeStr(DateUtils.dateFormat(sampleInfos.get(i).getSamplingTime(), "yyyy-MM-dd"));
            if (sampleInfos.get(i).getInputTime() != null && !"".equals(sampleInfos.get(i).getInputTime())) {
                sampleInfos.get(i).setInputTimeStr(DateUtils.dateFormat(sampleInfos.get(i).getInputTime(), "yyyy-MM-dd"));
            }
            //获取省的编码
            String province = sampleInfos.get(i).getProvince();
            //根据编码查询对象
            AddressProvince addressProvince = addressProvinceMapper.SelectByProvinceCode(province);
            //重新赋值
            if (StringUtil.isNotEmpty(addressProvince.getName())) {

                sampleInfos.get(i).setProvince(addressProvince.getName());
            }
            //获取市区的编码
            String city = sampleInfos.get(i).getCity();
            //根据城市编码查询对象
            AddressCity addressCity = cityMapper.SelectByAddressCityCode(city);
            //重新赋值
            if (addressCity.getName() != null && !"".equals(addressCity.getName())) {
                sampleInfos.get(i).setCity(addressCity.getName());
            }
            String county = sampleInfos.get(i).getCounty();
            AddressTown addressTown = townMapper.SelectByTownCode(county);
            if (addressTown.getName() != null && !"".equals(addressTown.getName())) {
                sampleInfos.get(i).setCounty(addressTown.getName());
            }
            //
            Float pollutionRate = sampleInfos.get(i).getPollutionRate();

            Float a = pollutionRate;
            //将float转为String
            String b = String.format("%1.1f", a);
            b = b + "%";
            sampleInfos.get(i).setPollutionRateStr(b);
            //System.out.println(sampleInfos);
        }
        PageInfo<SampleInfo> sampleInfoPageInfo = new PageInfo<>(sampleInfos);
        return sampleInfoPageInfo;
    }


/*
    @Override
    public List<SampleInfo> SearchLike(String sampleId, String pollutionRateStr, String samplingTimeStr, String toxinsss, String cropSpecies, String province, String city, String county) {
        return InfoMapper.SearchLike(sampleId, pollutionRateStr, samplingTimeStr, toxinsss, cropSpecies, province, city, county);
    }*/


    @Override
    public List<SampleInfo> selectBySearchBean(Integer page, Integer pageSize,SelectDto selectDto) {
        //第一部分 对参数 进行处理
        Integer breed = selectDto.getBreed();
        String sampleId = selectDto.getSampleId();
        String province1 = selectDto.getProvince();
        String city1 = selectDto.getCity();
        String county1 = selectDto.getCounty();

        //System.out.println("breed"+breed+"samplId"+sampleId);
        String pollutionRate2 = selectDto.getPollutionRate();
        if (pollutionRate2 != null && !"".equals(pollutionRate2)) {
            String[] split = pollutionRate2.split("-");
            selectDto.setLeftNum(Integer.valueOf(split[0]));
            selectDto.setRightNum(Integer.valueOf(split[1]));
        }

        String year = selectDto.getYear();
        String month = selectDto.getMonth();
        String day = selectDto.getDay();
        String inputTime = "";
        if (!"0".equals(day)) {
            inputTime = year + "-" + month + "-" + "0" + day;
        } else {
            if (!"0".equals(month)) {
                inputTime = year + "-" + month;
            } else {
                if (!"0".equals(year)) {
                    inputTime = year;
                }
            }
        }
        selectDto.setInputTime(inputTime);
        String addressStr = "";
        if (!"0".equals(county1)) {
            addressStr = province1 + city1 + county1;
        } else {
            if (!"0".equals(city1)) {
                addressStr = province1 + city1;
            } else {
                if (!"0".equals(province1)) {
                    addressStr = province1;
                }
            }
        }
        selectDto.setAddressStr(addressStr);
        //调用方法
        List<SampleInfo> sampleInfos = InfoMapper.selectBySearchBean(selectDto);
        if (Objects.isNull(sampleInfos)) {
            sampleInfos = Collections.emptyList();
        }
        //对集合进行处理
        for (int i = 0; i < sampleInfos.size(); i++) {
            sampleInfos.get(i).setSamplingTimeStr(DateUtils.dateFormat(sampleInfos.get(i).getSamplingTime(), "yyyy-MM-dd"));
            sampleInfos.get(i).setInputTimeStr(DateUtils.dateFormat(sampleInfos.get(i).getInputTime(), "yyyy-MM-dd"));
            //获取省的编码
            String province = sampleInfos.get(i).getProvince();
            //根据编码查询对象
            AddressProvince addressProvince = addressProvinceMapper.SelectByProvinceCode(province);
            //重新赋值
            sampleInfos.get(i).setProvince(addressProvince.getName());
            //获取市区的编码
            String city = sampleInfos.get(i).getCity();
            //根据城市编码查询对象
            AddressCity addressCity = cityMapper.SelectByAddressCityCode(city);
            //重新赋值
            sampleInfos.get(i).setCity(addressCity.getName());
            String county = sampleInfos.get(i).getCounty();
            AddressTown addressTown = townMapper.SelectByTownCode(county);
            sampleInfos.get(i).setCounty(addressTown.getName());

            //
            Float pollutionRate = sampleInfos.get(i).getPollutionRate();
            Float a = pollutionRate;

            //将float转为String
            String b = String.format("%1.1f", a);
            b = b + "%";
            sampleInfos.get(i).setPollutionRateStr(b);

        }
        return sampleInfos;
    }
    //根据名称查询省
    @Override
    public List<AddressProvince> queryPByName() {
        List<AddressProvince> provinces = addressProvinceMapper.queryPByName();
        return provinces;
    }

    //根据省的名称和市的code查询
    @Override
    public List<AddressCity> queryByNameAndCode() {
        List<AddressCity> addressCities = cityMapper.queryByNameAndCode();
        return addressCities;
    }
    @Override
    public List<AddressTown> queryByNameAndPCCode() {
        List<AddressTown> towns = townMapper.queryByNameAndPCCode();
        return towns;
    }

    //  //修改查询
    @Override
    public SampleInfo editQuery(String id) {
        SampleInfo sampleInfo = InfoMapper.editQuery(id);
        sampleInfo.setSamplingTimeStr(DateUtils.dateFormat(sampleInfo.getSamplingTime(), "yyyy-MM-dd"));
        sampleInfo.setHarvestTimeStr(DateUtils.dateFormat(sampleInfo.getHarvestTime(), "yyyy-MM-dd"));
        return sampleInfo;
    }
    //修改
    @Override
    public void updateSample(SampleInfo sampleInfo,String id) {
        InfoMapper.updateSample(sampleInfo,id);
    }

    @Override
    public void addSampleInfo(SampleInfo sampleInfo) {
        InfoMapper.addSampleInfo(sampleInfo);
    }

    //查询当前编号下的所有菌株
    @Override
    public List<BacterialStrainInfo> selectBySampleId(String sampleNum) {
        List<BacterialStrainInfo> bacterialStrainInfos = strainInfoMapper.selectBySampleId(sampleNum);
        return bacterialStrainInfos;
    }

    @Override
    public void deleteOneBySampleId(String sampleId) {
        InfoMapper.deleteOneBySampleId(sampleId);
    }

    @Override
    public void deleteManyById(List<Integer> id) {
        InfoMapper.deleteManyById(id);
    }

    //添加方法
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertinto(String sampleId, String samplingPeople, String[] toxins, String[] toxinCount, Float pollutionRate, String seasonal, String description, String harvestTime, String samplingTime, Integer cropCategoryId, Integer breed, String province, String city, String county, String[] originalNum, String[] wordAddr, String[] txtAddr, String[] pictureAddr) {
        SampleInfo sampleInfo = new SampleInfo();
        if (sampleId != null && !sampleId.equals("")) {
            sampleInfo.setSampleId(sampleId);//把接收到的参数付给对象
        }
        if (samplingPeople != null && !samplingPeople.equals("")) {
            sampleInfo.setSamplingPeople(samplingPeople);
        }
        if (pollutionRate != null && !pollutionRate.equals("")) {
            sampleInfo.setPollutionRate(pollutionRate);
        }

        /*sampleInfo.setSamplingTime(samplingTime);
        InfoMapper.insertinto(sampleInfo);*/
        sampleInfo.setSeasonal(seasonal);
        sampleInfo.setDescription(description);
        sampleInfo.setSamplingTime(DateUtils.dateParse(samplingTime, "yyyy-MM-dd"));
        sampleInfo.setHarvestTime(DateUtils.dateParse(harvestTime, "yyyy-MM-dd"));
        sampleInfo.setCropCategoryId(cropCategoryId);
        sampleInfo.setBreed(breed);
        sampleInfo.setProvince(province);
        sampleInfo.setCity(city);
        sampleInfo.setCounty(county);

        //上面的都是對添加參數的封裝
        InfoMapper.insertinto(sampleInfo);

        //因为数组的长度是相同的
        for (int i = 0; i < toxins.length; i++) {
            SampleToxin sampleToxin = new SampleToxin();
            //获取当前样品id的主键
            sampleToxin.setSampleInfoId(sampleInfo.getId());
            sampleToxin.setToxinCount(Float.valueOf(toxinCount[i]));
            sampleToxin.setToxinId(Integer.valueOf(toxins[i]));
            //调用添加毒素的方法
            sampleToxinMapper.inserinto(sampleToxin);
        }

       // strainInfo.setOriginalNum(originalNum);

        for (int i = 0; i < originalNum.length; i++) {
            BacterialStrainInfo strainInfo = new BacterialStrainInfo();
            strainInfo.setSampleNum(sampleInfo.getSampleId());
            strainInfo.setSampleInfoId(sampleInfo.getId());
            strainInfo.setOriginalNum(originalNum[i]);
            strainInfo.setWordAddr(wordAddr[i]);
            strainInfo.setTxtAddr(txtAddr[i]);
            strainInfo.setPictureAddr(pictureAddr[i]);
            strainInfoMapper.inserinto(strainInfo);
        }
    }



}




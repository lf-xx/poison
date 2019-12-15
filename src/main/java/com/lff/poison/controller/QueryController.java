package com.lff.poison.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lff.poison.domain.*;
import com.lff.poison.domain.dto.SelectDto;
import com.lff.poison.mapper.*;
import com.lff.poison.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class QueryController {

    @Autowired
    private QueryService queryService;

    @Autowired
    private SampleToxinInfoMapper sampleToxinInfoMapper;
    @Autowired
    private CropCategoryMapper categoryMapper;
    @Autowired
    private AddressProvinceMapper provinceMapper;
    @Autowired
    private AddressCityMapper cityMapper;
    @Autowired
    private AddressTownMapper townMapper;
    @Autowired
    private CropSpeciesMapper speciesMapper;

    /*    @RequestMapping("/selectAll")
        public String queryAll(ModelMap map) {
            List<SampleInfo> list = queryService.selectAll();
            map.put("list", list);
            return "IM";
        }*/
    @RequestMapping("/selectAll")
    public ModelAndView queryAll(@RequestParam(value="pageNum",required = false, defaultValue = "1")Integer page,
                           @RequestParam(value="pageSize",required = false,defaultValue="2")Integer pageSize,
                           ModelAndView modelAndView) {
        PageHelper.startPage(page,pageSize);
        PageInfo<SampleInfo> pageInfo=queryService.selectAll(page,pageSize);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("IM");

        return modelAndView;
    }
/*
    @RequestMapping("/searchLike")
    public String SearchLike(ModelMap map){
        List<SampleInfo> sampleInfos = queryService.SearchLike("sampleId", "pollutionRateStr", "samplingTimeStr", "toxinsss", "cropSpecies", "province", "city", "county");
        map.put("sampleInfos",sampleInfos);
        return "IM";
    }*/

    @RequestMapping("/findBySearchBean")
    public String findBySearchBean(ModelMap map, SelectDto selectDto) {
        List<SampleInfo> list = queryService.selectBySearchBean(selectDto);
        map.put("list", list);
        return "IM";
    }

    @ResponseBody
    @RequestMapping("/findProvince")
    public List<AddressProvince> findProvince() {
        List<AddressProvince> addressProvinces = provinceMapper.selecteAll();
        return addressProvinces;
        //List<AddressProvince> addressProvinces = provinceMapper.selecteAll();
       /* AddressProvince addressProvince = provinceMapper.SelectByProvinceCode(shen);
        System.out.println(addressProvince);*/
        //return null;
    }


    @RequestMapping("findCity")
    @ResponseBody
    public List<AddressCity> findCity(String shi) {
        //根據省的code查詢市
        List<AddressCity> addressCities = cityMapper.selecteAll(shi);
        return addressCities;
    }

    @RequestMapping("findTown")
    @ResponseBody
    public List<AddressTown> findTown(String xian) {
       /* List<AddressTown> addressProvinces = new ArrayList<>();

        for (int i = 0; i <10;i ++){
            AddressTown addressProvince = new AddressTown();
            addressProvince.setCode("30120");
            addressProvince.setName("海淀区");
            addressProvinces.add(addressProvince);
        }
*/
        List<AddressTown> addressTowns = townMapper.selecteAll(xian);
        return addressTowns;
    }

    @RequestMapping("/findCropCategory")
    @ResponseBody
    public List<CropCategory> findCropCategory() {
        List<CropCategory> cropCategories = categoryMapper.queryAll();
        return cropCategories;
    }

    @RequestMapping("findCropSpecies")
    @ResponseBody
    public List<CropSpecies> findCropSpecies(String cptypess) {
        List<CropSpecies> cropSpecies = speciesMapper.SelectByCropId(cptypess);
        return cropSpecies;
    }

    //删除单条
    @RequestMapping("/deleteOneBySampleId")
    public String deleteOneBySampleId(String sampleId) {
        // System.out.println(sampleId);
        queryService.deleteOneBySampleId(sampleId);
        return "redirect:selectAll";
    }

    //删除多条
    @RequestMapping("/deleteManyById")
    public String deleteManyById(String id) {
        List<Integer> a = new ArrayList<>();
        // System.out.println(sampleId);
        String[] str = id.split(",");
        for (int i = 0; i < str.length; i++) {
            a.add(Integer.parseInt(str[i]));
        }
        queryService.deleteManyById(a);
        //System.out.println(Arrays.toString(str));

        return "redirect:selectAll";
    }


    //添加方法
    @ResponseBody
    @RequestMapping("/saveSampleinfo")
    public String saveSampleinfo(@RequestParam("sampleId") String sampleId,
                                 @RequestParam("samplingPeople") String samplingPeople,
                                 @RequestParam("toxins") String[] toxins,
                                 @RequestParam("toxinCount") String[] toxinCount,
                                 @RequestParam("pollutionRate") Float pollutionRate,
                                 @RequestParam("seasonal") String seasonal,
                                 @RequestParam("description") String description,
                                 @RequestParam("harvestTime") String harvestTime,
                                 @RequestParam("samplingTime") String samplingTime,
                                 @RequestParam("cropCategoryId") Integer cropCategoryId,
                                 @RequestParam("breed") Integer breed,
                                 @RequestParam("province") String province,
                                 @RequestParam("city") String city,
                                 @RequestParam("county") String county,
                                 @RequestParam("originalNum") String originalNum,
                                 @RequestParam("wordAddr") String[] wordAddr,
                                 @RequestParam("txtAddr") String[] txtAddr,
                                 @RequestParam("pictureAddr") String[] pictureAddr


    ) {
        // System.out.println("111进入");
        String message = "ERROR";
        try {
            queryService.insertinto(sampleId, samplingPeople, toxins, toxinCount, pollutionRate, seasonal, description, harvestTime, samplingTime, cropCategoryId, breed, province, city, county, originalNum, wordAddr, txtAddr, pictureAddr);
            message = "SUCCESS";
            return message;
        } catch (Exception e) {
            return message;
        }
    }

    //查询所有的毒素
    @ResponseBody
    @RequestMapping("/findtoxins")
    public List<SampleToxinInfo> findtoxins() {
        List<SampleToxinInfo> sampleToxinInfos = sampleToxinInfoMapper.selectAll();
        return sampleToxinInfos;
    }

    //
    @ResponseBody
    @RequestMapping("/findCrop")
    public List<CropCategory> findCrop() {
        List<CropCategory> cropCategories = categoryMapper.queryAll();
        return cropCategories;
    }

    //跳转到新增页面
    @RequestMapping("/intoadd")
    public String intoadd() {

        return "editIM-add";
    }

    //跳转到信息管理页面
    @RequestMapping("/intoIm")
    public String intoIm() {
        return "IM";
    }

    //进入index页面
    @RequestMapping("/intoIndex")
    public String intoIndex() {
        return "index";
    }

}

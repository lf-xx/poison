package com.lff.poison.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lff.poison.domain.*;
import com.lff.poison.domain.dto.SelectDto;
import com.lff.poison.mapper.*;
import com.lff.poison.service.QueryService;
import com.lff.poison.util.DateUtils;
import com.lff.poison.util.ExcelUtil;
import com.lff.poison.util.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
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
    @Autowired
    private SampleToxinMapper sampleToxinMapper;

    /*    @RequestMapping("/selectAll")
        public String queryAll(ModelMap map) {
            List<SampleInfo> list = queryService.selectAll();
            map.put("list", list);
            return "IM";
        }*/
    @RequestMapping("/selectAll")
    public ModelAndView queryAll(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "3") Integer pageSize,
                                 ModelAndView modelAndView) {
        PageHelper.startPage(page, pageSize);
        PageInfo<SampleInfo> pageInfo = queryService.selectAll(page, pageSize);
        modelAndView.addObject("pageInfo", pageInfo);
        //System.err.println(pageInfo);
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

    /*    @RequestMapping("/findBySearchBean")
        public String findBySearchBean(ModelMap map, SelectDto selectDto) {
            List<SampleInfo> list = queryService.selectBySearchBean(selectDto);
            map.put("list", list);
            return "IM";
        }*/
    @RequestMapping("/findBySearchBean")
    public ModelAndView findBySearchBean(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer page,
                                         @RequestParam(value = "pageSize", required = false, defaultValue = "3") Integer pageSize,
                                         ModelAndView modelAndView, SelectDto selectDto) {

        PageHelper.startPage(page, pageSize);
        List<SampleInfo> list = queryService.selectBySearchBean(page, pageSize, selectDto);
        PageInfo<SampleInfo> pageInfo = new PageInfo<>(list);
        /*PageInfo<SampleInfo> pageInfo=queryService.selectAll(page,pageSize)*/
        ;
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("IM");
        return modelAndView;
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

    //修改查询
    @RequestMapping("/findAllEdit")
    public String findAllEdit(Model model, String id) {
        SampleInfo sampleInfo = queryService.editQuery(id);
        // System.out.println(sampleInfo);
       /* SampleInfo aaa = new SampleInfo();
        aaa.setSampleId("asdassa");
        model.addAttribute("ccc",aaa);*/
        model.addAttribute("sampleInfo", sampleInfo);
        // System.err.println(model);
        return "editIM";
    }

    //修改
    @RequestMapping("/update")
    public void update(SampleInfo sampleInfo, String id) {
        System.err.println(sampleInfo);
        queryService.updateSample(sampleInfo, id);
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
                                 @RequestParam("originalNum") String[] originalNum,
                                 @RequestParam("wordAddr") String[] wordAddr,
                                 @RequestParam("txtAddr") String[] txtAddr,
                                 @RequestParam("pictureAddr") String[] pictureAddr
    ) {

     /*   for (int i = 0; i < originalNum.length; i++) {
            System.out.println(originalNum[i]);
        }*/
        //System.out.println("111进入");
        String message = "ERROR";
        try {
            queryService.insertinto(sampleId, samplingPeople, toxins, toxinCount, pollutionRate, seasonal, description, harvestTime, samplingTime, cropCategoryId, breed, province, city, county, originalNum, wordAddr, txtAddr, pictureAddr);
            message = "SUCCESS";
            return message;
        } catch (Exception e) {
            e.printStackTrace();
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

    /**
     * 导出信息
     *
     * @param response
     */
    @ResponseBody
    @RequestMapping("/poiOut")
    public void poiOut(HttpServletResponse response) {
        String message = "";
        //获取数据
        List<SampleInfo> list = queryService.queryAll();
        //excel标题
        String[] title = {"采样信息主键", "样品编号", "原料类别id", "品种", "省", "市", "县", "收获时间", "取样时间", "取样人", "真菌污染率", "创建时间", "录入时间", "是否删除"};
        //excel文件名
        String fileName = "SampleInfo" + System.currentTimeMillis() + ".xls";
        //sheet名
        String sheetName = "样品信息表";
        String[][] content = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            SampleInfo sampleInfo = list.get(i);
            content[i][0] = sampleInfo.getId() + "";
            content[i][1] = sampleInfo.getSampleId() + "";
            content[i][2] = sampleInfo.getCropCategoryStr() + "";
            content[i][3] = sampleInfo.getCropSpeciesStr() + "";
            content[i][4] = sampleInfo.getProvince() + "";
            content[i][5] = sampleInfo.getCity() + "";
            content[i][6] = sampleInfo.getCounty() + "";
            content[i][7] = sampleInfo.getHarvestTimeStr() + "";
            content[i][8] = sampleInfo.getSamplingTimeStr() + "";
            content[i][9] = sampleInfo.getSamplingPeople() + "";
            content[i][10] = sampleInfo.getPollutionRateStr() + "";
            content[i][11] = sampleInfo.getCreateTimeStr() + "";
            content[i][12] = sampleInfo.getInputTimeStr() + "";
            content[i][13] = sampleInfo.getIsdel() + "";
        }
        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
            message = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            message = "ERROR";
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //导入
    @ResponseBody
    @RequestMapping("/poiInto")
    public void poiInto(@RequestParam("file") MultipartFile file) throws Exception {
        List<List<Object>> list1 = null;
        // List<SampleInfo> sampleInfoList = new ArrayList<SampleInfo>();
        try {
            list1 = ExcelUtils.getExcelList(file.getInputStream(), file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list1.size(); i++) {
            List<Object> li = list1.get(i);
            SampleInfo sampleInfo = new SampleInfo();
            sampleInfo.setId(Integer.valueOf(li.get(0).toString()));
            sampleInfo.setSampleId(li.get(1).toString());
            //sampleInfo.setCropCategoryId(Integer.valueOf(li.get(2).toString()));
            String s = li.get(2).toString();
            if (s.equals("水果类")) {
                sampleInfo.setCropCategoryId(1);
            } else if (s.equals("谷物类")) {
                sampleInfo.setCropCategoryId(2);
            } else if (s.equals("油料类")) {
                sampleInfo.setCropCategoryId(3);
            } else if (s.equals("坚果类")) {
                sampleInfo.setCropCategoryId(4);
            } else if (s.equals("香辛类")) {
                sampleInfo.setCropCategoryId(5);
            } else if (s.equals("饲料类")) {
                sampleInfo.setCropCategoryId(6);
            }
            // sampleInfo.setBreed(Integer.valueOf(li.get(3).toString()));
            String m = li.get(3).toString();
            if (m.equals("小麦")) {
                sampleInfo.setBreed(1);
            } else if (m.equals("玉米")) {
                sampleInfo.setBreed(2);
            } else if (m.equals("水稻")) {
                sampleInfo.setBreed(3);
            } else if (m.equals("花生油")) {
                sampleInfo.setBreed(4);
            } else if (m.equals("苹果")) {
                sampleInfo.setBreed(6);
            } else if (m.equals("梨")) {
                sampleInfo.setBreed(7);
            } else if (m.equals("葡萄")) {
                sampleInfo.setBreed(8);
            } else if (m.equals("杏仁")) {
                sampleInfo.setBreed(9);
            } else if (m.equals("葵花籽")) {
                sampleInfo.setBreed(10);
            } else if (m.equals("榛子")) {
                sampleInfo.setBreed(11);
            } else if (m.equals("核桃")) {
                sampleInfo.setBreed(12);
            } else if (m.equals("花椒")) {
                sampleInfo.setBreed(13);
            } else if (m.equals("八角")) {
                sampleInfo.setBreed(14);
            } else if (m.equals("肉桂")) {
                sampleInfo.setBreed(15);
            } else if (m.equals("辣椒")) {
                sampleInfo.setBreed(16);
            } else if (m.equals("草果")) {
                sampleInfo.setBreed(17);
            } else if (m.equals("豆粕")) {
                sampleInfo.setBreed(18);
            } else if (m.equals("棉籽粕")) {
                sampleInfo.setBreed(19);
            } else if (m.equals("麸皮")) {
                sampleInfo.setBreed(20);
            } else if (m.equals("饲用玉米")) {
                sampleInfo.setBreed(21);
            } else if (m.equals("饲用小麦")) {
                sampleInfo.setBreed(22);
            }
            String p = li.get(4).toString();
            List<AddressProvince> provinces = queryService.queryPByName();
            for (AddressProvince province : provinces) {
                if (p.equals(province.getName())) {
                    sampleInfo.setProvince(province.getCode());
                    // System.out.println(province);
                }

            }
            String c = li.get(5).toString();
            List<AddressCity> cities = queryService.queryByNameAndCode();
            for (AddressCity city : cities) {
                if (c.equals(city.getName())) {
                    sampleInfo.setCity(city.getCode());
                }
            }
            String t = li.get(6).toString();
            List<AddressTown> towns = queryService.queryByNameAndPCCode();
            for (AddressTown town : towns) {
                if (t.equals(town.getName())) {
                    sampleInfo.setCounty(town.getCode());
                }
            }
            //sampleInfo.setProvince(li.get(4).toString());
            // sampleInfo.setCity(li.get(5).toString());
            // sampleInfo.setCounty(li.get(6).toString());
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            // sampleInfo.setHarvestTime(DateUtils.dateParse(String.valueOf(li.get(7)), "yyyy-MM-dd"));
            String s1 = li.get(7).toString();
            Date htime = format.parse(s1);
            sampleInfo.setHarvestTime(htime);
            // sampleInfo.setSamplingTime(DateUtils.dateParse(String.valueOf(li.get(8)), "yyyy-MM-dd"));
            String s2 = li.get(8).toString();
            Date stime = format.parse(s2);
            sampleInfo.setSamplingTime(stime);

            sampleInfo.setSamplingPeople(li.get(9).toString());
            sampleInfo.setPollutionRate(Float.valueOf(li.get(10).toString()));
            // sampleInfo.setCreateTime(DateUtils.dateParse(String.valueOf(li.get(11)), "yyyy-MM-dd"));
            //sampleInfo.setInputTime(DateUtils.dateParse(String.valueOf(li.get(12)), "yyyy-MM-dd"));
            String s3 = li.get(11).toString();
            Date ctime = format.parse(s3);
            sampleInfo.setCreateTime(ctime);
            String s4 = li.get(12).toString();
            Date itime = format.parse(s4);
            sampleInfo.setInputTime(itime);
            sampleInfo.setIsdel(Integer.valueOf(li.get(13).toString()));
            queryService.addSampleInfo(sampleInfo);
        }
    }


    /**
     * 下载模板
     *
     * @param response
     */
    @ResponseBody
    @RequestMapping("/poiDownLoad")
    public void poiDownLoad(HttpServletResponse response) {
        String message = "";
        //获取数据
        List<SampleInfo> list = queryService.queryAll();
        //excel标题
        String[] title = {"采样信息主键", "样品编号", "原料类别id", "品种", "省", "市", "县", "收获时间", "取样时间", "取样人", "真菌污染率", "创建时间", "录入时间", "是否删除"};
        //excel文件名
        String fileName = "SampleInfo" + System.currentTimeMillis() + ".xls";
        //sheet名
        String sheetName = "样品信息表";
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbooks(sheetName, title, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
            message = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            message = "ERROR";
        }
    }

    //根据样品id查询下面所有的毒素
    @ResponseBody
    @RequestMapping("/findbyid")
    public List<SampleToxin> findbyid(String id) {
        List<SampleToxin> sampleToxins = sampleToxinMapper.selectToxinBySampleId(id);
        return sampleToxins;
    }

    //根据样品bainhao查询下面所有的菌株
    @ResponseBody
    @RequestMapping("/selectById")
    public List<BacterialStrainInfo> selectById(String sampleNum) {
        List<BacterialStrainInfo> bacterialStrainInfos = queryService.selectBySampleId(sampleNum);
        return bacterialStrainInfos;
    }

}



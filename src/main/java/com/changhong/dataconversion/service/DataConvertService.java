package com.changhong.dataconversion.service;

import com.changhong.dataconversion.entity.DataConvert;
import com.changhong.dataconversion.mapper.DataConvertMapper;
import com.changhong.exceptionhandle.RestResult;
import com.changhong.exceptionhandle.RestResultGenerator;
import com.changhong.semanticmanage.entity.PageBean;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/9.
 */
@Service
public class DataConvertService {

    @Autowired
    DataConvertMapper dataConvertMapper;

    public PageBean<DataConvert> getDataConvertPage(DataConvert dataConvert){
        PageBean<DataConvert> pageBean = new PageBean<DataConvert>();
        int page = dataConvert.getPageNo();
        pageBean.setPage(page);
        int limit = 30;
        pageBean.setLimit(limit);
        int totalCount = 0;
        totalCount = dataConvertMapper.getDataConvertCount(dataConvert);
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if(totalCount % limit ==0){
            totalPage=totalCount/limit;
        }else {
            totalPage= totalCount/limit +1;
        }
        pageBean.setTotalPage(totalPage);
        int begin = (page-1)*limit;
        dataConvert.setBegin(begin);
        dataConvert.setLimit(limit);
        List<DataConvert> list = dataConvertMapper.getDataConvertPage(dataConvert);
        pageBean.setList(list);
        return pageBean;
    }


    public void delete(int i){
        dataConvertMapper.delete(i);
    }

    public void insert(DataConvert dataConvert){
        dataConvertMapper.insert(dataConvert);
    }

    public void update(DataConvert dataConvert){
        dataConvertMapper.update(dataConvert);
    }

    public RestResult upload(MultipartFile file) throws IOException {
        boolean b = false;
        InputStream in = null;
        XSSFWorkbook workbook = null;
        in = file.getInputStream();
        workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = null;
        XSSFCell cell = null;
        int rowNum = sheet.getLastRowNum();
        List<DataConvert> list = new ArrayList<DataConvert>();
        for(int i = 1;i<=rowNum;i++) {
            row = sheet.getRow(i);
            if(row!=null){
                Cell type = row.getCell(0);
                Cell semantic = row.getCell(1);
                Cell paltform = row.getCell(2);
                if(type!=null&&semantic!=null&&paltform!=null) {
                    String ntype = type.getStringCellValue();
                    String nsemantic = semantic.getStringCellValue();
                    String npaltform = paltform.getStringCellValue();
                    DataConvert dataConvert = new DataConvert();
                    dataConvert.setType(ntype);
                    dataConvert.setSemantic(nsemantic);
                    dataConvert.setPaltform(npaltform);
                    list.add(dataConvert);
                }else{
                    b = true;
                    break;
                }
            }else {
                b = true;
                break;
            }
        }
        if(b==false){
            for(DataConvert li:list){
                dataConvertMapper.insert(li);
            }
            return RestResultGenerator.genSuccessResult();
        }else{
            return RestResultGenerator.genErrorResult("问法和回答不能为空");
        }
    }
}

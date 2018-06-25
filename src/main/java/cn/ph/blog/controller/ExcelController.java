package cn.ph.blog.controller;

import cn.ph.blog.core.constant.ExcelConstant;
import cn.ph.blog.core.ret.RetResponse;
import cn.ph.blog.core.ret.RetResult;
import cn.ph.blog.core.utils.ExcelUtils;
import cn.ph.blog.model.ExcelData;
import cn.ph.blog.model.UserInfo;
import cn.ph.blog.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("excel")
public class ExcelController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/test")
    public RetResult<Integer> test(){
        int rowIndex = 0;
        List<UserInfo> list = userInfoService.selectAll();
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList<>();
        titles.add("ID");
        titles.add("userName");
        titles.add("password");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList<>();
        for(int i = 0, length = list.size();i<length;i++){
            UserInfo userInfo = list.get(i);
            List<Object> row = new ArrayList<>();
            row.add(userInfo.getId());
            row.add(userInfo.getUserName());
            row.add(userInfo.getPassword());
            rows.add(row);
        }
        data.setRows(rows);
        try{
            rowIndex = ExcelUtils.generateExcel(data, ExcelConstant.FILE_PATH + ExcelConstant.FILE_NAME);
        }catch (Exception e){
            e.printStackTrace();
        }
        return RetResponse.makeOKRsp(Integer.valueOf(rowIndex));
    }

    @GetMapping("/test2")
    public void test2(HttpServletResponse response){
        int rowIndex = 0;
        List<UserInfo> list = userInfoService.selectAll();
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList<>();
        titles.add("ID");
        titles.add("userName");
        titles.add("password");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList<>();
        for(int i = 0, length = list.size();i<length;i++){
            UserInfo userInfo = list.get(i);
            List<Object> row = new ArrayList<Object>();
            row.add(userInfo.getId());
            row.add(userInfo.getUserName());
            row.add(userInfo.getPassword());
            rows.add(row);
        }
        data.setRows(rows);
        try{
            ExcelUtils.exportExcel(response,"test2",data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

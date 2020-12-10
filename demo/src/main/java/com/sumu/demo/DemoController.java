package com.sumu.demo;

import com.sumu.form.bean.domin.info.BriefTableStyleDo;
import com.sumu.form.bean.domin.info.TableInfoDo;
import com.sumu.form.service.FormInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-10 15:10
 */
@RestController
@RequestMapping("demo/")
@CrossOrigin
public class DemoController {


    @Autowired
    private FormInfoService formInfoService;

    @RequestMapping("tables")
    @ResponseBody
    public List<TableInfoDo> getTableInfo() {
        return formInfoService.getTableInfo();
    }

    @RequestMapping("styles")
    @ResponseBody
    public List<BriefTableStyleDo> getTableStyleInfo(@RequestParam("tableName") String tableName) {
        return formInfoService.getBriefTableStyle(tableName);
    }

    @RequestMapping("style/detail")
    @ResponseBody
    public String getTableStyleInfo(@RequestParam("id") int id) {
        return formInfoService.getTableStyleHtml(id);
    }


}

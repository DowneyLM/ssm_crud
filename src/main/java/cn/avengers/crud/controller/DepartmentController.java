package cn.avengers.crud.controller;


import cn.avengers.crud.bean.Department;
import cn.avengers.crud.bean.Msg;
import cn.avengers.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 返回所有的部门的信息
     */
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        //查出的所有部门信息
        List<Department> depts = departmentService.getDepts();
        return Msg.success().add("depts",depts);
    }


}

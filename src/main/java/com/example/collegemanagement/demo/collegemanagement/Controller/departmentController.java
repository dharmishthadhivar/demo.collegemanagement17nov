package com.example.collegemanagement.demo.collegemanagement.Controller;

import com.example.collegemanagement.demo.collegemanagement.Dao.DepartmentDao;
import com.example.collegemanagement.demo.collegemanagement.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@RestController
public class departmentController {
    @Autowired
    DepartmentServices service;
    @Autowired
    DepartmentServices service1;
    @Autowired
    DepartmentServices service2;

    @RequestMapping(value = "/getdepartment", method = RequestMethod.GET)
    @ResponseBody
    public List getUsers() {

        List<String> listdepartment;
        //DepartmentDao department=new DepartmentDao();
        DepartmentServices deptservice = new DepartmentServices();
        List<DepartmentDao> Listifa = new ArrayList<>();
        Listifa = deptservice.getDepartment();
        listdepartment = service.getDepartment();
        return listdepartment;
    }

   @RequestMapping(path = "/insertDepartment", method = RequestMethod.GET)
   @ResponseBody
    public int setDepartment()
    {
        int deptId = 4;
        String deptname = "Stuructural eng";
        String deptHead = "zankhana shah";
        String teachersall ="teachers shah";
        int count = service1.Insert(deptId,deptname,deptHead,teachersall);
        return count;

    }

    @RequestMapping(path = "/updateDepartment", method = RequestMethod.GET)
    @ResponseBody
    public int deleteDepartment()
    {
        int deptId = 4;
        String deptname = "production eng";
        String deptHead = "ravin shah";
        String teachersall ="ravin shah";
        int count = service2.update(deptId,deptname,deptHead,teachersall);
        return count;

    }

}

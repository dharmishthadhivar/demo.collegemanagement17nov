package com.example.collegemanagement.demo.collegemanagement.Controller;

import com.example.collegemanagement.demo.collegemanagement.Dao.DepartmentDao;
import com.example.collegemanagement.demo.collegemanagement.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@RestController
//@EnableSwagger2
@RequestMapping("/api/department")
public class departmentController {
    @Autowired
    DepartmentServices service;
    @Autowired
    DepartmentServices service1;
    @Autowired
    DepartmentServices service2;
   @RequestMapping(path = "/getDepartmentCount", method = RequestMethod.GET)
    @ResponseBody
    public int getdepartmentcount()
    {
       int totaldepartment= service.totaldepartments();
       return totaldepartment;
    }


    @RequestMapping(path = "/getDepartment", method = RequestMethod.GET)
    @ResponseBody

    public String getdepartmentgson() {

        List<String> listdepartment;
        DepartmentServices deptservice = new DepartmentServices();
        List<DepartmentDao> Listifa = new ArrayList<>();

        listdepartment = service.getDepartment();
        String gsonlistDepartment=service.convertListtoJson(listdepartment);
        return gsonlistDepartment;

    }



   @RequestMapping(path = "/insertDepartment", method = RequestMethod.POST)
   @ResponseBody
   public int DepartmentInsert(@RequestParam int deptId,@RequestParam String deptname,@RequestParam String deptHead,@RequestParam String teachersall) throws IOException {
       //Declaration
       int deptIdd=deptId;
       String deptnamestring = deptname;
       String deptHeadstring = deptHead;
       String teachersallstring =teachersall;
       int count = service2.Insert(deptname,deptHead,teachersall);
       return count;
   }





    @RequestMapping(path = "/updateDepartment", method = RequestMethod.PUT)
    @ResponseBody
    public int updateDepartment(@RequestParam int deptId,@RequestParam String deptname,@RequestParam String deptHead,@RequestParam String teachersall) throws IOException
    {
        int deptIdstring = deptId;
        String deptnamestring = deptname;
        String deptHeadstring = deptHead;
        String teachersallstring = teachersall;
        int count = service2.update(deptId,deptname,deptHead,teachersall);
        return count;

    }
    @RequestMapping(path = "/deleteDepartment", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteDepartment(@RequestParam("deptId") int deptId )throws IOException
    {
        int deptIdstring = deptId;
        int count = service2.delete(deptId);
        return count;
    }


}

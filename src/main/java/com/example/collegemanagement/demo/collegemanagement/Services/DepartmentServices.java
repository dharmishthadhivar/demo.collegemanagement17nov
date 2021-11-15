package com.example.collegemanagement.demo.collegemanagement.Services;

import com.example.collegemanagement.demo.collegemanagement.Dao.DepartmentDao;
import com.example.collegemanagement.demo.collegemanagement.QueryConstant;
import com.example.collegemanagement.demo.collegemanagement.connectionHelper;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class DepartmentServices {
    PreparedStatement ps;
    public List getDepartment() {


        List<DepartmentDao> Listifa = new ArrayList<>();
        Connection connection = connectionHelper.getconnection();

        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(QueryConstant.selectQuery);
            ResultSetMetaData rsmd=rs.getMetaData();
            int i=rsmd.getColumnCount();
            DepartmentDao[] department=new DepartmentDao[i];
            for(int i1=0;i1<i;i1++)
                while (rs.next()) {
                    //System.out.println(rs.getString("person_id") +" " +rs.getString("name"));
                    department[i1] = new DepartmentDao(rs.getInt("departmentId"),rs.getString("departmentName"),rs.getString("departmentHead"),rs.getString(("teachersAll")));
                    Listifa.add(department[i1]);
                }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Listifa;
        //  return null;
    }
    public int Insert(int deptid,String deptname,String deptHead,String teachersAll)
    {
        int count=0;
        // int length=0;
        try {
            Connection con = connectionHelper.getconnection();


            Statement stmt = con.createStatement();
            ps = con.prepareStatement(QueryConstant.insertQueryDepartment);
            ps.setInt(1,deptid);
            ps.setString(2,deptname);
            ps.setString(3,deptHead);
            ps.setString(4,teachersAll);
            count = ps.executeUpdate ();


            con.close();
        }
        catch (Exception e)
        {
            System.out.println("Error..."+e);
        }
        return count;
    }


    public int update(int deptid,String deptname, String deptHead, String teachersall)
    {
        int count=0;
        // int length=0;
        try {
            Connection con = connectionHelper.getconnection();


            Statement stmt = con.createStatement();
            ps = con.prepareStatement(QueryConstant.updateQueryDepartment);

            ps.setString(1,deptname);
            ps.setString(2,deptHead);
            ps.setString(3,teachersall);
            ps.setInt(4,deptid);
            count = ps.executeUpdate ();


            con.close();
        }
        catch (Exception e)
        {
            System.out.println("Error..."+e);
        }
        return count;
    }
}

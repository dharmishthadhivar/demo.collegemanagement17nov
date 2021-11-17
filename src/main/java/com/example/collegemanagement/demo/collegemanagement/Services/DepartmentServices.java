package com.example.collegemanagement.demo.collegemanagement.Services;

import com.example.collegemanagement.demo.collegemanagement.Dao.DepartmentDao;
import com.example.collegemanagement.demo.collegemanagement.QueryConstant;
import com.example.collegemanagement.demo.collegemanagement.connectionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@Component
public class DepartmentServices {
    PreparedStatement ps;
   // @Autowired
    private JdbcTemplate jdbcTemplate;
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
    public int Insert(String deptname,String deptHead,String teachersAll)
    {
        int count=0;
        // int length=0;
        try {
            Connection con = connectionHelper.getconnection();
            Statement stmt = con.createStatement();
            ps = con.prepareStatement(QueryConstant.insertQueryDepartment);
            ps.setString(1,deptname);
            ps.setString(2,deptHead);
            ps.setString(3,teachersAll);
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

    public int delete(int deptid)
    {
        int count=0;
        // int length=0;
        try {
            Connection con = connectionHelper.getconnection();
            Statement stmt = con.createStatement();
            ps = con.prepareStatement(QueryConstant.deleteQueryDepartment);
            ps.setInt(1,deptid);
            count = ps.executeUpdate ();
            con.close();
        }
        catch (Exception e)
        {
            System.out.println("Error..."+e);
        }
        return count;
    }

    public String convertListtoJson(List list)
    {
        Gson gsdepartment=new Gson();
        String St_ObjTojson11 =gsdepartment.toJson(list);
        return  St_ObjTojson11;
    }
    public int totaldepartments() {
        Connection connection = connectionHelper.getconnection();
        int i=0;
        try {
            ResultSet rs;
            Statement stmt = connection.createStatement();
                rs = stmt.executeQuery(QueryConstant.totalcountdepartment);
            if(rs.next()){
                i = rs.getInt("total");
            }
            return i;

            }
         catch (SQLException ex) {
            ex.printStackTrace();

        }
        return i;
    }

    public void insertMultipledepartment(List<DepartmentDao> department) {
        jdbcTemplate.batchUpdate(QueryConstant.insertQueryDepartment, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement pStmt, int j) throws SQLException {
                DepartmentDao student = department.get(j);
                pStmt.setString(1, student.getDepartmentName());
                pStmt.setString(2, student.getDepartmentHead());
                pStmt.setString(3, student.getTeachersAll());
            }
            @Override
            public int getBatchSize() {
                return department.size();
            }

        });
    }

}

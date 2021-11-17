package com.example.collegemanagement.demo.collegemanagement.Services;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.collegemanagement.demo.collegemanagement.Dao.DepartmentDao;
import com.example.collegemanagement.demo.collegemanagement.Dao.LoginDao;
import com.example.collegemanagement.demo.collegemanagement.QueryConstant;
import com.example.collegemanagement.demo.collegemanagement.connectionHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

@Component

public class LoginServices {
    PreparedStatement ps = null;
    public List getLogin() {
        List<LoginDao> Listifa = new ArrayList<>();
        Connection connection = connectionHelper.getconnection();

        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(QueryConstant.selectQueryLogin);
            ResultSetMetaData rsmd=rs.getMetaData();
            int i=rsmd.getColumnCount();
            LoginDao[] login=new LoginDao[i];
            for(int i1=0;i1<i;i1++)
                while (rs.next()) {
                    //System.out.println(rs.getString("person_id") +" " +rs.getString("name"));
                    login[i1] = new LoginDao(rs.getInt("userId"),rs.getString("userName"),rs.getString("password"));
                    Listifa.add(login[i1]);
                }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Listifa;
        //  return null;
    }
    public int Insert(String userName,String email,String password)
    {
        int count=0;
        try {
            Connection con = connectionHelper.getconnection();
            Statement stmt = con.createStatement();
            ps = con.prepareStatement(QueryConstant.insertQueryRegister);

            ps.setString(1,userName);
            ps.setString(3,email);
            ps.setString(2,password);
            count = ps.executeUpdate ();
            con.close();
        }
        catch (Exception e)
        {
            System.out.println("Error..."+e);
        }
        return count;
    }


    public int update(int userId,String userName, String password)
    {
        int count=0;
        try {
            Connection con = connectionHelper.getconnection();
            Statement stmt = con.createStatement();
            ps = con.prepareStatement(QueryConstant.updateQueryLogin);
            ps.setString(1,userName);
            ps.setString(2,password);
            ps.setInt(3,userId);
            count = ps.executeUpdate ();
            con.close();
        }
        catch (Exception e)
        {
            System.out.println("Error..."+e);
        }
        return count;
    }

    public int delete(int userId)
    {
        int count=0;
        // int length=0;
        try {
            Connection con = connectionHelper.getconnection();
            Statement stmt = con.createStatement();
            ps = con.prepareStatement(QueryConstant.deleteQueryLogin);
            ps.setInt(1,userId);
            count= ps.executeUpdate();
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
    public int totallogin() {
        Connection connection = connectionHelper.getconnection();
        int i=0;
        try {
            ResultSet rs;
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(QueryConstant.totalcountLogin);
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

    public String finduser(String email, String password)
    {
        Connection connection = connectionHelper.getconnection();
        String user="";

        try {
            ResultSet rs;
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(QueryConstant.findRegisterUser);
            ps.setString(1,email);
            ps.setString(2,password);
            rs= ps.executeQuery();
            if(rs.next())
                user="user found";
            else
              user="user not found";
        }
        catch (SQLException ex) {
            ex.printStackTrace();

        }
        return user;
    }

}

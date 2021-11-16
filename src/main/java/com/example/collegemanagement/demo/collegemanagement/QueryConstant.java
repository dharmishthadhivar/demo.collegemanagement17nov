package com.example.collegemanagement.demo.collegemanagement;

public class QueryConstant {
        public static final String url = "jdbc:mysql://localhost:3306/phpmyadmin";
        public static final String username = "phpmyadmin";
        public static final String password = "root";
        public static final String selectQuery="select * from department";
        public static final String updateQueryDepartment="update department set departmentName =?,departmentHead=?,teachersAll=? where departmentId=?";
        public static final String insertQueryDepartment= "INSERT INTO department VALUES ((?),(?),(?),(?))";
        public static final String deleteQueryDepartment="delete from department where departmentId=?";
        public static final String totalcountdepartment="select count(*) as total from department";

        public static final String selectQueryLogin="select * from login";
        public static final String updateQueryLogin="update login set userName =?,password=? where userId=?";
        public static final String insertQueryLogin= "INSERT INTO login(userName,password) VALUES ((?),(?))";
        public static final String deleteQueryLogin="delete from login where userId=?";
        public static final String totalcountLogin="select count(*) as total from login";
    }



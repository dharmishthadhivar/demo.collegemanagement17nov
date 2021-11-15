package com.example.collegemanagement.demo.collegemanagement;

public class QueryConstant {
        public static final String url = "jdbc:mysql://localhost:3306/phpmyadmin";
        public static final String username = "phpmyadmin";
        public static final String password = "root";
        public static final String selectQuery="select * from department";
        public static final String updateQueryDepartment="update department set departmentName =?,departmentHead=?,teachersAll=? where departmentId=?";
        public static final String insertQueryDepartment= "INSERT INTO department VALUES ((?),(?),(?),(?))";
        public static final String deleteQuery="delete from customer where Customer_Id=?";
    }



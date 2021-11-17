package com.example.collegemanagement.demo.collegemanagement;

public class QueryConstant {
        public static final String url = "jdbc:mysql://localhost:3306/phpmyadmin";
        public static final String username = "phpmyadmin";
        public static final String password = "root";
        public static final String selectQuery="select * from department";
        public static final String updateQueryDepartment="update department set departmentName =?,departmentHead=?,teachersAll=? where departmentId=?";
        public static final String insertQueryDepartment= "INSERT INTO department(departmentName,departmentHead,teachersAll) VALUES ((?),(?),(?))";
        public static final String deleteQueryDepartment="delete from department where departmentId=?";
        public static final String totalcountdepartment="select count(*) as total from department";

        public static final String selectQueryLogin="select * from register";
        public static final String updateQueryLogin="update register set userName =?,password=? where userId=?";
        public static final String insertQueryRegister= "INSERT INTO register(userName,email,password) VALUES ((?),(?),(?))";
        public static final String deleteQueryLogin="delete from register where userId=?";
        public static final String totalcountLogin="select count(*) as total from register";
        public static final String findRegisterUser="select email,password from register where email=?,password=?";

    }



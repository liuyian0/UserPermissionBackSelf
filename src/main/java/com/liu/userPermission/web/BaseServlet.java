package com.liu.userPermission.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/*
将公共部分（反射获取所用方法）整理到基础模块BaseServlet中
 */
public class BaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求路径(http://localhost:8080/user/find)
        String requestURI = request.getRequestURI();//  /user/find
        //2.获取最后一个/出现的索引(5)
        int i = requestURI.lastIndexOf("/");
        //3.截取
        String methodName = requestURI.substring(i + 1);
        try {
            //4.采用反射技术解决根据截取的方法名判断是用什么方法
            //4.1创建Class对象
            //this指UserServlet类的对象
            Class<?> clazz = this.getClass();
            //4.2 获取要执行的方法
            Method m = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //4.3 暴力反射
            m.setAccessible(true);
            //4.4 执行方法
            m.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}


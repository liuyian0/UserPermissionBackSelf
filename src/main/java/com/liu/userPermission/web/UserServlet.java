package com.liu.userPermission.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*1.浏览器客户端的请求服务器路径
http://localhost:8080/user/find
http://localhost:8080/user/fingById
http://localhost:8080/user/update
http://localhost:8080/user/add
http://localhost:8080/user/delete
 */

//UserServlet继承基础模块BaseServlet
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

        private void find (HttpServletRequest request, HttpServletResponse response){
            System.out.println("find");
        }

        private void update (HttpServletRequest request, HttpServletResponse response){
            System.out.println("update");
        }

        private void add (HttpServletRequest request, HttpServletResponse response){
            System.out.println("add");
        }

        private void delete (HttpServletRequest request, HttpServletResponse response){
            System.out.println("delete");
        }
}


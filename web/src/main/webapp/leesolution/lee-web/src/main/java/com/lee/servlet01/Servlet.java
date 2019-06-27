package com.lee.servlet01;

import lee.bean;
import lee.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Provider;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "Servlet",urlPatterns = "/servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service service = new service();
        int totalusername = 0;
        int totalPage = 0;
        int pageSize =0;
        if (request.getParameter("pageSize")!=null){
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        }
        int currentPage =1;
        if (request.getParameter("indexPage") != null){
            if (request.getParameter("indexPage")!="请输入您要查看的页码"){
                currentPage= Integer.parseInt(request.getParameter("indexPage"));;
            }

        }
        try {
            totalusername = service.getUserCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //使用UTF-8转码
        response.setCharacterEncoding("UTF-8");

        if(pageSize>0){
            response.getWriter().append("<html><body>");
            response.getWriter().append("<form  name = 'f' action='servlet' method='get'><input type = 'text' " +
                    "name = 'indexPage' placeholder = '请输入您要查看的页码'><input type = 'text' name = 'pageSize' " +
                    "placeholder = '请输入单页存储数目'><input type='submit'></form>");
            if (totalusername % pageSize == 0) {
                totalPage = totalusername / pageSize;
            }
            if (totalusername % pageSize != 0) {
                totalPage = (totalusername / pageSize) + 1;
            }
            if (currentPage > totalPage) {
                response.getWriter().append("末页了，别翻了");
            }
            if (currentPage < 1) {
                response.getWriter().append("第一页，别翻了");
            }

            try {
                ArrayList<bean> allUser = service.getAllUser(currentPage, pageSize);
                for (bean bean : allUser) {
                    response.getWriter().append("<br>");
                    response.getWriter().append(bean.getUserkey());
                    response.getWriter().append("==");
                    response.getWriter().append(bean.getUsername());
                    response.getWriter().append("<br>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.getWriter().append("<div><a href='servlet?indexPage=1&pageSize=" + pageSize + "'>首页</a></div>");

            response.getWriter().append("<div><a href='servlet?indexPage=" + (currentPage + 1) + "&pageSize=" + pageSize + "'>下一页</a></div>");

            response.getWriter().append("<div><a href='servlet?indexPage=" + (currentPage - 1) + "&pageSize=" + pageSize + "'>上一页</a><div>");

            response.getWriter().append("<div><a href='servlet?indexPage=" + totalPage + "&pageSize=" + pageSize + "'>尾页</a></div>");

            response.getWriter().append("</body></html>");
        }
else{response.getWriter().append("<html><body>");
            response.getWriter().append("<form  name = 'f' action='servlet' method='get'><input type = 'text' " +
                    "name = 'indexPage' placeholder = '请输入您要查看的页码'><input type = 'text' name = 'pageSize' " +
                    "placeholder = '请输入单页存储数目'><input type='submit'></form>");
            response.getWriter().append("</body></html>");
        }

    }
}

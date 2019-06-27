import com.ass.been.PageBean;
import com.ass.been.Station;
import com.ass.service.StationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindByPageServlet",urlPatterns = "/findByPage")
public class FindByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int currentPage =1;
         if(request.getParameter("currentPage")!=null){
             currentPage=Integer.parseInt(request.getParameter("currentPage"));
         }
       int rows =3;
        StationService service =new StationService();
       PageBean<Station> pageBean= service.findStationBypage(currentPage,rows);
       request.setAttribute("pb",pageBean);
       request.getRequestDispatcher("/StationManagerPages.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}

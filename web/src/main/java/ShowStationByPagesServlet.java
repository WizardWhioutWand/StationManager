import com.ass.been.Station;
import com.ass.service.StationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowStationByPagesServlet",urlPatterns = "/showStation")
public class ShowStationByPagesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取当前页
        response.setContentType("text/html;charset=UTF-8");
        //获取分页数量
        int pageSize =3;
        int totalPage=0;
        int currentPage=1;
        StationService service = new StationService();
        if(request.getParameter("indexPage")!=null){
            currentPage = Integer.parseInt(request.getParameter("indexPage"));
        }

        if(pageSize>0){


            int totalStation = 0;
            try {


                totalStation = service.getStationCount();

            } catch (Exception e) {
                e.printStackTrace();
            }
            if (totalStation%pageSize==0) {
                totalPage = totalStation / pageSize;
            }
            if (totalStation%pageSize!=0){
                totalPage = totalStation / pageSize+1;
            }

            if (currentPage<=0){
                currentPage=1;
                response.getWriter().append("    <script>\n" +
                        "        alert(\"已经是第一页了。\");\n" +
                        "    </script>");

            }else if (currentPage>totalPage){
                currentPage=totalPage;
                response.getWriter().append("<script>\n" +
                        "        alert(\"已经是最后一页了。\");\n" +
                        "    </script>");
            }
            if(currentPage>0&&currentPage<=totalPage) {


                List<Station> stations = service.getStations((currentPage-1)*pageSize,
                        (currentPage-1)*pageSize+pageSize);
                System.out.println(stations.get(0).getStationId());
                request.getSession().setAttribute("stations",stations);
                request.getRequestDispatcher("/stationManagerPages.jsp").forward(request,response);


            }
            }
    }
}

import com.ass.been.Station;
import com.ass.service.StationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindStationServlet" ,urlPatterns = "/FindStationServlet")
public class FindStationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String id =request.getParameter("id");
        StationService service =new StationService();
       Station station= service.getStations(Integer.parseInt(id));
       request.setAttribute("station",station);
       request.getRequestDispatcher("/updateStation.jsp").forward(request,response);

    }
}

import com.ass.been.Station;
import com.ass.service.StationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StationListServlet" ,urlPatterns = "/StationList")
public class StationListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StationService service =new StationService();
        List<Station> stations = service.getStations();
        int stationCount = service.getStationCount();
       request.getSession().setAttribute("stationCount",stationCount);
        request.getSession().setAttribute("stations",stations);
        request.getRequestDispatcher("/stationManagerPages.jsp").forward(request,response);

    }
}

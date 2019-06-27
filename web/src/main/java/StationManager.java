import com.ass.been.Station;
import com.ass.service.StationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StationManager",urlPatterns = "/StationManager")
public class StationManager extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        StationService service =new StationService();
        List<Station> stations= service.getStations();
          response.getWriter().append( "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" class=\"bdataGrid\">"
            +"<thead>"
            +"<tr bgcolor=\"#ccffcc\" style=\"font-size:12px;\">"
                +"<th height=\"35\" style=\"text-align:left;padding-left:20px;\"> 站点创建时间</th>"
               +"<th style=\\\"text-align:left\\\">站点编号</th>"
               +"<th style=\\\"text-align:left\\\"> 站点区域</th>"
                +"<th style=\"text-align:left\">站点名称 </th>"
                  +" <th style=\"text-align:left\">站点描述</th>"
                  +"<th style=\"text-align:left\">站点管理员</th>"
                  +" <th style=\"text-align:left\">站点日处理量</th>"
                  +"<th style=\"text-align:left\">站点通信方式</th>"
                  +" <th style=\"text-align:left\">站点经度</th>"
                    +"<th style=\"text-align:left\">站点纬度</th>"
                  +"<th style=\"text-align:left\">操作</th>"
                  +"</tr>"
                  +" </thead>");
          response.getWriter().append(" <tbody id=\"waterdata\">");
        for (Station station:stations
             ) {
            response.getWriter().append("<tr bgcolor=\"#ccffcc\" style=\"font-size:12px;\">"
                    +"<td height=\"35\" style=\"text-align:left;padding-left:20px;\"><input type=\"checkbox\" name=\"station\" value="+station.getStationId()+"/>"+
                     station.getCreateTime()+"</td>"//创建时间
                    +"<td style=\"text-align:left\">" +
                    station.getStationNum()+"</td>"//编号
                    +"<td style=\"text-align:left\"> " +
                    station.getLocation()+"</td>"//地点
                    +"<td style=\"text-align:left\">" +
                    station.getStationName()+"</td>"//站点名字
                    +" <td style=\"text-align:left\">" +
                    station.getDescribe() +//描述
                    "</td>"
                    +"<td style=\"text-align:left\">" +
                    station.getManager() +//管理员
                    "</td>"
                    +" <td style=\"text-align:left\">" +
                     station.getHandlingCapacityPerDay()+//"站点日处理量" +
                    "</td>"
                    +"<td style=\"text-align:left\">" +
                   station.getCommunicationMode()+// "站点通信方式" +
                    "</td>"
                    +" <td style=\"text-align:left\">" +
                    station.getLongitude()+//"站点经度" +
                    "</td>"
                    +"<td style=\"text-align:left\">" +
                    station.getLatitude()//"站点纬度
                    +" </td>"
                    +"<td style=\"text-align:left\"><a href=\"/index.jsp\">配置设置</a>"
                    + "</td>"
                    +"</tr>");

        }response.getWriter().append(" </tbody>");
          response.getWriter().append("</table>");
    }
}

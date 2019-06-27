import com.ass.been.Station;


import com.ass.service.StationService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet(name = "updateServlet",urlPatterns = "/updateServlet")
public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 2: 告诉浏览器以什么编码进行显示
        response.setContentType("text/html;charset=UTF-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        Station station =new Station();
        try{
            ConvertUtils.register(new Converter() {

                public Object convert(Class type, Object value) {

                    //判断是不是String类型的数据，不是则抛出异常
                    if(!(value instanceof String)){
                        throw new ConversionException("不是String数据类型！");
                    }
                    //是String的话，把Object的value强转成String
                    String strValue = (String) value;
                    //判断是不是一个空字符串
                    if(strValue.trim().equals("")){
                        return null;

                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        return sdf.parse(strValue);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, Date.class);
            BeanUtils.populate(station,parameterMap);

        }catch (Exception e){
            e.printStackTrace();
        }
        StationService service =new StationService();
        if (station.getStationId()==-1){
            if(service.addStation(station)){
                response.sendRedirect("http://localhost:8080/web/findByPage");
                // request.getRequestDispatcher("/stationManager.jsp?data="+new Date()).forward(request,response);
            }

        }else {
            if(service.updateStation(station)){
                response.sendRedirect("http://localhost:8080/web/findByPage");
                // request.getRequestDispatcher("/stationManager.jsp?data="+new Date()).forward(request,response);
            }
        }


    }
}

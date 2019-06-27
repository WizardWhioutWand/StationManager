package lee;

import java.sql.SQLException;
import java.util.ArrayList;

public class service {

    public ArrayList<bean> getAllUser(int pageIndex, int pageSize) throws SQLException {
        dao userDal = new dao();
        return userDal.getAllUser(pageIndex, pageSize);

    }
    public int getUserCount() throws SQLException{
        return new dao().getUserCount();
    }


}

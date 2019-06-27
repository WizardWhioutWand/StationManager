package lee;

import lee.common.c3p0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class dao {
    public int getUserCount() throws SQLException {
        Connection conn = c3p0Util.getConnection();
        String sql = "select count(*) from user_tb";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int re = rs.getInt(1);
            c3p0Util.release(conn, stmt, rs);
            return re;
        }

        c3p0Util.release(conn, stmt, rs);
        return 0;
    }
    public ArrayList<bean> getAllUser(int currentPage, int pageSize) throws SQLException {
        Connection conn = c3p0Util.getConnection();
        ArrayList<bean> users = new ArrayList<>();
        String sql = "select*from user_tb limit ?,?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, (currentPage - 1) * pageSize);
        stmt.setInt(2, pageSize);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            bean user = new bean();
            user = new bean(rs.getString(1), rs.getString(2));
            users.add(user);
        }

        c3p0Util.release(conn, stmt, rs);
        return users;
    }
}

package org.java.bin.jdbc;

import java.io.Closeable;
import java.sql.*;

/**
 * Created by wangbin on 17/1/6.
 */
public class TestJdbc {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("parameter error! ");
            System.exit(-1);
        }

        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/mi?user=root&password=root";
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            /*for (String str : args) {
                String sql = "SELECT * FROM user;";
                System.out.println(sql);
                stmt.execute(sql);
            }*/
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }finally {
            AutoCloseable[] closeables = {rs, stmt, conn};
            closeResources(rs, stmt, conn);
        }
    }

    private static void closeResources(AutoCloseable... closeables) {
        for (AutoCloseable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                    c = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package datahelper.datahelperimpl;

import java.sql.*;

/**
 * Created by huihantao on 2016/11/28.
 */
public class runner {
    private String url = "jdbc:mysql://localhost:3306/hht?useUnicode=true&characterEncoding=utf8&useSSL=true";
    private String user = "root";
    private String password = "123";

//    数据库连接
    private Connection getcon() {
        Connection conn= null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

//    数据库读操作
    String read (String sql){
        Connection conn = this.getcon();
        String result="";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int i=rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int j=1;j<=i;j++) {
                    result = result+rs.getString(j)+",";

                }
                result=result+".";

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

//    数据库写操作
    int write (String sql){
        Connection conn = this.getcon();
        int i=0;
        try {
            Statement stmt = conn.createStatement();
            i=stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  i;
    }


}




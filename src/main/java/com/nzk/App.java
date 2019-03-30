package com.nzk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


/**
 * lambda -> rds sample
 */
public class App implements RequestHandler<Request, Response> {
    @Override
    public Response handleRequest(Request input, Context context) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        // 環境変数から取得
        String url = System.getenv("jdbc_url");
        String user = System.getenv("user");
        String password = System.getenv("pass");

        try {
            // PostgreSQLへ接続
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            // SELECT文の実行
            stmt = conn.createStatement();
            String sql = "SELECT * from test2";
            rset = stmt.executeQuery(sql);
            // SELECT結果の受け取り
            while (rset.next()) {
                String col = rset.getString(1);
                System.out.println(col);
            }
            // INSERT文の実行
            sql = "INSERT INTO test2 VALUES (DEFAULT,8,7,6)";
            stmt.executeUpdate(sql);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null)
                    rset.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new Response("ok");
    }
}
class Request {
    String param;

    /**
     * @return the param
     */
    public String getParam() {
        return param;
    }

    /**
     * @param param the param to set
     */
    public void setParam(String param) {
        this.param = param;
    }
}

class Response {
    String status;

    Response(String status) {
        this.status = status;
    }
}

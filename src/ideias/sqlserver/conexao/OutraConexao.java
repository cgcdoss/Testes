/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.sqlserver.conexao;

import java.sql.*;

/**
 *
 * @author Cássio Gabriel
 */
public class OutraConexao {

    // Declare the JDBC objects.
    static Connection con = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    public static String getCol(String coluna, String SQL) {
        String result = "";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                result = result + rs.getString(coluna) + "\n";
            }
        } catch (Exception e) {

        }
        return result;
    }

    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=conquista;";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl, "sa", "redeinf123");

            System.out.println(getCol("nome", "select * from aluno"));
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }
    }
}

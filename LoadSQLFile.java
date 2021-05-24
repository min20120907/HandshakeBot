import javax.swing.*;
import java.sql.*;
import java.io.*;

public class LoadSQLFile {
    public static void main(String args[]) {

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/HandshakeBot", "root", "password");
                    Statement stmt = conn.createStatement();
                    //FileReader fr = new FileReader("MilkTea.sql");
                    //BufferedReader br = new BufferedReader(fr);
                    //stmt.execute(br.readLine());
                    stmt.execute("SELECT * FROM MilkTea");
                    //System.out.println(stmt.getResultSet());
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }
}

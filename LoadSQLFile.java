import javax.swing.*;
import java.sql.*;
import java.io.*;

public class LoadSQLFile {
    public static void main(String args[]) {

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/HandshakeBot", "java","password");
                    Statement stmt = conn.createStatement();
                    //FileReader fr = new FileReader("MilkTea.sql");
                    //BufferedReader br = new BufferedReader(fr);
                    //stmt.execute(br.readLine());
                    stmt.execute("SELECT * FROM MilkTea");
                    while(stmt.getResultSet().next()){
                        System.out.print(stmt.getResultSet().getString("name")+"\t");
                        System.out.print(stmt.getResultSet().getString("class")+"\t");
                        System.out.print(stmt.getResultSet().getInt("price")+"\t");
                        System.out.println(stmt.getResultSet().getString("brand"));
                    }
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }
}

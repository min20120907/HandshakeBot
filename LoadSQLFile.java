import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadSQLFile {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please input your query: ");
        String item = s.next();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:HandshakeBot.db");
            Statement stmt = conn.createStatement();
            // FileReader fr = new FileReader("MilkTea.sql");
            // BufferedReader br = new BufferedReader(fr);
            // stmt.execute(br.readLine());
            stmt.execute("SELECT * FROM MilkTea");
            List<Drink> drinks = new ArrayList<>();
            while (stmt.getResultSet().next()) {
                String n = stmt.getResultSet().getString("name");
                String c = stmt.getResultSet().getString("category");
                int p = stmt.getResultSet().getInt("price");
                String b = stmt.getResultSet().getString("brand");
                drinks.add(new Drink(n,c,p,b));
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

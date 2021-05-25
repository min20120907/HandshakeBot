package min20120907;
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
        	Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:HandshakeBot.db");
            Statement stmt = conn.createStatement();
            // FileReader fr = new FileReader("MilkTea.sql");
            // BufferedReader br = new BufferedReader(fr);
            // stmt.execute(br.readLine());
            ResultSet rs = stmt.executeQuery( "SELECT * FROM MilkTea WHERE INSTR(name, '"+item+"');" );
            List<Drink> drinks = new ArrayList<>();
            while (rs.next()) {
                String n = rs.getString("name");
                String c = rs.getString("category");
                int p = rs.getInt("price");
                String b = rs.getString("brand");
                drinks.add(new Drink(n,c,p,b));
            }
            for(Drink a : drinks) {
            	System.out.println(a.getName());
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

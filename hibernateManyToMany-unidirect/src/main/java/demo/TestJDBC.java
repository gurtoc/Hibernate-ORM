package demo;

import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://www.db4free.net:3306/hibernate";
        String user = "gurtoc";
        String password = "tomasson1";
        try{
            System.out.println("Lacze sie do bazy danych " +jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl,user,password);
            System.out.println("Połączone do bazy danych");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

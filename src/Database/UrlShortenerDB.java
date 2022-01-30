package Database;
import java.sql.*;

public class UrlShortenerDB {

    public static void main ( String args[] ) {
        Connection c = null;
        Statement stmt = null;

        try{
            Class.forName("org.sqlite.UrlShortenerDB");
            c = DriverManager.getConnection("UrlShortener:sqlite:test.db");
            System.out.println("Opened Database successfully");

            stmt = c.createStatement();
        }
    }
}

package Application.shop_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class shop {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:shop.db";

    private Connection conn;
    private Statement stat;

    public shop() {
        try {
            Class.forName(shop.DRIVER);
            
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }

        createTables();
    }

    public boolean createTables()  {
        String createUsers = "CREATE TABLE IF NOT EXISTS User (\"id_user\" INTEGER PRIMARY KEY AUTOINCREMENT, "
        		+ "\"imie\" varchar(255), \"nazwisko\" varchar(255), \"pesel\" varchar(11), \"status\" "
        		+ "varchar(255), \"password\" varchar(255))";
        String createOffers = "CREATE TABLE IF NOT EXISTS Offer (\"id_offer\" INTEGER PRIMARY KEY AUTOINCREMENT, "
        		+ "\"name\" varchar(255), \"price\" integer(25), \"company\" varchar(255))";
        try {
            stat.execute(createUsers);
            stat.execute(createOffers);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    


    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}

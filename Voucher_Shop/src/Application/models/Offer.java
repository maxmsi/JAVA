package  Application.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import java.util.Date;

public class Offer {
    // Connection with database
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:shop.db";

    private Connection conn;
    private Statement stat;

    private int id;
    private String name;
    private String company;
    private Date event_date;
    private int price;

    //Constructors
    public Offer(int id, String name, String company, int price) {
        super();
        this.id = id;
        this.name = name;
        this.company = company;
        this.price=price;
    }
    public Offer() {
        try {
            Class.forName(Offer.DRIVER);
            
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
    }

    // Getter and Setters
    public int getId() {
        return id;
    }
     public int getPrice(){

        return price;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    

    //Models
    public boolean insertOffer(String name, String company, Integer price) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Offer (name, price, company) values (?, ?, ?);");
            prepStmt.setString(1, name);
            prepStmt.setInt(2, price);
            prepStmt.setString(3, company);
         
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu uzytkownika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deleteOffer(int id_offer){


        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "delete from Offer where id_offer = (?);");
            prepStmt.setInt(1, id_offer);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu uzytkownika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public List<Offer> selectOffers() {
        List<Offer> Offerts = new LinkedList<Offer>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM  Offer");
            int id,price;
            String name, company;
            while(result.next()) {
                id = result.getInt("id_offer");
                price = result.getInt("price");
                company = result.getString("company");
                name = result.getString("name");
                Offerts.add(new Offer(id,name, company, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return Offerts;
    }


}

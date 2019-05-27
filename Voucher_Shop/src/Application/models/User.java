package Application.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class User {
    // Connection with database
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:shop.db";

    private Connection conn;
    private Statement stat;

    private int id;
    private String name;
    private String surname;
    private String status;
    private String pesel;
    private String password;


    //Constructor
    public User(int id, String state, String password,String name, String surname,String pesel) {
        super();
        this.id = id;
        this.status = state;
        this.pesel = pesel;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.pesel =  pesel;
    }
    public User(int id,String password) {
        super();
        this.id = id;
        this.password=password;
    }
    public User() {
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


    //Getter and Setters
    public int getId() {
        return id;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Models
    public boolean insertUser(String imie, String nazwisko, String pesel,String status,String Password) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into User (imie, nazwisko, pesel, status, password)  values ( ?, ?, ?, ?, ? );");
            prepStmt.setString(1, imie);
            prepStmt.setString(2, nazwisko);
            prepStmt.setString(3, pesel);
            prepStmt.setString(4, status);
            prepStmt.setString(5, Password);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu uzytkownika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deleteUser(int id_user){


        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "delete from User where id_user = (?);");
            prepStmt.setInt(0, id_user);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu uzytkownika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public List<User> selectUserss() {
        List<User> Users = new LinkedList<User>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM  User");
            int id;
            String name,surname,pesel,status,password;
            while(result.next()) {
                id = result.getInt("id_user");
                name = result.getString("imie");
                surname = result.getString("nazwisko");
                pesel = result.getString("pesel");
                status = result.getString("status");
                password = result.getString("password");
                Users.add(new User(id,status,password,name,surname,pesel));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return Users;
    }


}

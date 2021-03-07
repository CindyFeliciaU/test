package fr.cabmed.gestionnaire.structs;

import fr.cabmed.gestionnaire.common.Strings;

import java.sql.ResultSet;
import java.sql.SQLException;


public class User {

    private String name;
    private String email;
    private String id;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "User{" +
                 ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(ResultSet res) {
        try {
            this.password = res.getString(Strings.USER_PASSWORD);
            this.name = res.getString(Strings.USER_NAME);
            this.email = res.getString(Strings.USER_EMAIL);
            this.id = res.getString(Strings.USER_ID);
        } catch (SQLException e) {
            e.printStackTrace();
            this.name = "";
            this.id = "";
        }
    }

    public User(String id, String email,String name, String password) {
        this.email=email;
        this.password=password;
        this.name = name;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

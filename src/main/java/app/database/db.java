package app.database;

import java.sql.SQLException;
import app.entities.User;

public class db {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        User user;
        user = new User();
        conn.Conn();
        conn.CreateDB();
        conn.WriteDB(user);
        conn.ReadDB();
        conn.CloseDB();
    }
}

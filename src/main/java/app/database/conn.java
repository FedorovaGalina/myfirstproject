package app.database;

import app.entities.User;

import java.sql.*;

public class conn {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\TESTDB");

        System.out.println("База подключена.");
    }

    // --------Создание таблицы--------
   public static void CreateDB() throws SQLException
    {
/*        statmt = conn.createStatement();
        statmt.execute(
                /*"CREATE TABLE if not exists 'TestTable' (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Name varchar(10), JNDIname varchar(10), " +
                        "Description varchar(50), Category integer, " +
                        "URL varchar(50), Alias varchar(10), userID integer, " +
                        "Password varchar(10), TimeOut integer, " +
                        "MaxConnections integer, MinConnections integer");

                "CREATE TABLE if not exists 'TestTable' (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Name varchar(10), password varchar(10)");
        System.out.println("Таблица создана или уже существует.");
*/
    }

    // --------Заполнение таблицы--------
    public static void WriteDB(User user) throws ClassNotFoundException, SQLException
    {
        try {
            Conn();
          //  statmt = conn.createStatement();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO TestTable (name, password) VALUES ('" +user.getName()+"','"+user.getPassword()+"');");
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        /*finally {
            statmt.close();
            CloseDB();
        }
        */

/*            String s = "INSERT INTO TestTable (name, password) VALUES ('"+user.getName()+"','"+user.getPassword()+"');";
            System.out.println(s);
            boolean execute = statmt.execute(s);
            statmt.close();
            System.out.println("Строка записана");
*/
    }

    // -------- Вывод таблицы--------
    public static void ReadDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM TestTable");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  name = resSet.getString("name");
            String  password = resSet.getString("password");
            System.out.println( "ID = " + id );
            System.out.println( "name = " + name );
            System.out.println( "password = " + password );
            System.out.println();
        }

        System.out.println("Таблица выведена");
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        resSet.close();

        System.out.println("Соединения закрыты");
    }

}

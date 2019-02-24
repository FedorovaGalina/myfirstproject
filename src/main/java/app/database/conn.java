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
        //conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\TESTDB");//

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
            Conn();//
            //statmt = conn.createStatement();
            //PreparedStatement statement = conn.prepareStatement("INSERT INTO TestTable (name, password) VALUES ('" +user.getName()+"','"+user.getPassword()+"');");
            String tmpStatement = "INSERT INTO TestTable (name, password, JNDIname, Description, Category, URL, Alias, userID, TimeOut, MaxConnections, MinConnections) VALUES ('";
            tmpStatement += user.getName() + "','" + user.getPassword() + "','" + user.getJNDIname() + "','" + user.getDescription() + "','" + user.getCategory() + "','";
            tmpStatement += user.getURL() + "','" + user.getAlias() + "'," + user.getuserID() + "," + user.getTimeOut() + "," + user.getMaxConnections() + "," + user.getMinConnections() + ");";
            System.out.println(tmpStatement);

            PreparedStatement statement = conn.prepareStatement(tmpStatement);
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
    public static void ReadDB(User user) throws ClassNotFoundException, SQLException
    {
        String tmpStatement = "SELECT * FROM TestTable ";
        String tmpCondition;
        if (user.getName() != null) tmpCondition = "name like '"+user.getName()+"' AND";
        if (user.getPassword() != null) tmpCondition += "name like '"+user.getPassword()+"' AND";
        if (user.getJNDIname() != null) tmpCondition += "name like '"+user.getJNDIname()+"' AND";
        if (user.getDescription() != null) tmpCondition += "name like '"+user.getDescription()+"' AND";
        if (user.getCategory() != null) tmpCondition += "name like '"+user.getCategory()+"' AND";
        if (user.getURL() != null) tmpCondition += "name like '"+user.getURL()+"' AND";
        if (user.getAlias() != null) tmpCondition += "name like '"+user.getAlias()+"' AND";
        if (user.getuserID() != null) tmpCondition += "name like '"+user.getuserID()+"' AND";
        if (user.getTimeOut() != null) tmpCondition += "name like '"+user.getTimeOut()+"' AND";
        if (user.getMaxConnections() != null) tmpCondition += "name like '"+user.getMaxConnections()+"' AND";
        if (user.getMinConnections() != null) tmpCondition += "name like '"+user.getMinConnections()+"' AND";

        resSet = statmt.executeQuery(tmpStatement);

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

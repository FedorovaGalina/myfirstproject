package app.servlets;

import app.database.conn;
import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        String JNDIname = req.getParameter("JNDIname");
        String Description = req.getParameter("Description");
        String Category = req.getParameter("Category");
        String URL = req.getParameter("URL");
        String Alias = req.getParameter("Alias");
        int userID = req.getParameter("userID");
        int TimeOut = req.getParameter("TimeOut");
        int MaxConnections = req.getParameter("MaxConnections");
        int MinConnections = req.getParameter("MinConnections");

        User user = new User(name, password, JNDIname, Description, Category, URL, Alias, userID, TimeOut, MaxConnections,MinConnections);
        // Model model = Model.getInstance();
       // model.add(user);
        try {
            conn.WriteDB(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        req.setAttribute("userName", name);
        doGet(req, resp);
    }
}
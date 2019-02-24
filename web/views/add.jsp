<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10.02.2019
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>

<body>
<div>
    <h1>Application</h1>
</div>

<div>
    <%
        if (request.getAttribute("userName") != null) {
            out.println("<p>User '" + request.getAttribute("userName") + "' added.</p>");
        }
    %>
    <div>
        <div>
            <h2>Add user</h2>
        </div>

        <form method="post">
            <label>Name:
                <input type="text" name="name"><br />
            </label>
            <label>Password:
                <input type="password" name="pass"><br />
            </label>
            <label>JNDIname:
                <input type="text" name="JNDIname"><br />
            </label>
            <label>Desciption:
                <input type="text" name="Desciption"><br />
            </label>
            <label>Category:
                <input type="number" name="Category"><br />
            </label>
            <label>URL:
                <input type="text" name="URL"><br />
            </label>
            <label>Alias:
                <input type="text" name="Alias"><br />
            </label>
            <label>userID:
                <input type="number" name="userID"><br />
            </label>
            <label>TimeOut:
                <input type="number" name="TimeOut"><br />
            </label>
            <label>MaxConnections:
                <input type="number" name="MaxConnections"><br />
            </label>
            <label>MinConnections:
                <input type="number" name="MinConnections"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>

package app.entities;

public class User {
    private String u_name;
    private String u_password;
    private String u_JNDIname;
    private String u_Description;
    private String u_URL;
    private String u_Alias;
    private int u_userID;
    private int u_TimeOut;
    private String u_Category;
    private int u_MinConnections;
    private int u_MaxConnections;

    //JNDIname, Description, Category, URL, Alias, userID, TimeOut, MaxConnections,	MinConnections

    public User() {
    }

    public User(String name, String password, String JNDIname, String Description, String Category, String URL, String Alias, int userID, int TimeOut, int MaxConnections,	int MinConnections) {
        this.u_name = name;
        this.u_password = password;
        this.u_JNDIname = JNDIname;
        this.u_Description = Description;
        this.u_Category = Category;
        this.u_URL = URL;
        this.u_Alias = Alias;
        this.u_userID = userID;
        this.u_TimeOut = TimeOut;
        this.u_MaxConnections = MaxConnections;
        this.u_MinConnections = MinConnections;

    }
//name
    public String getName() {
        return u_name;
    }

    public void setName(String name) {
        this.u_name = name;
    }

//password
    public String getPassword() {
        return u_password;
    }

    public void setPassword(String password) {
        this.u_password = password;
    }

//JNDIname
    public String getJNDIname() {
    return u_JNDIname;
}

    public void setJNDIname(String JNDIname) {
        this.u_JNDIname = JNDIname;
    }

//Description
    public String getDescription() {
    return u_Description;
}

    public void setDescription(String Description) {
        this.u_password = Description;
    }

//Category
    public String getCategory() {
    return u_Category;
}

    public void setCategory(String Category) {
        this.u_Category = Category;
    }

//URL
    public String getURL() {
    return u_URL;
}

    public void setURL(String URL) {
        this.u_URL = URL;
    }

//Alias
    public String getAlias() {
    return u_Alias;
}

    public void setAlias(String Alias) {
        this.u_Alias = Alias;
    }

//userID
    public int getuserID() {
    return u_userID;
}

    public void setuserID(int userID) {
        this.u_userID = userID;
    }

//TimeOut
    public int getTimeOut() {
    return u_TimeOut;
}

    public void setTimeOut(int TimeOut) {
        this.u_TimeOut = TimeOut;
    }

//MaxConnections
    public int getMaxConnections() {
    return u_MaxConnections;
}

    public void setMaxConnections(int MaxConnections) {
        this.u_MaxConnections = MaxConnections;
    }

//MinConnections
    public int getMinConnections() {
        return u_MinConnections;
    }

    public void setMinConnections(int MinConnections) {
        this.u_MinConnections = MinConnections;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + u_name + '\'' +
                ", password='" + u_password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (u_name != null ? !u_name.equals(user.u_name) : user.u_name != null) return false;
        return u_password != null ? u_password.equals(user.u_password) : user.u_password == null;

    }

    @Override
    public int hashCode() {
        int result = u_name != null ? u_name.hashCode() : 0;
        result = 31 * result + (u_password != null ? u_password.hashCode() : 0);
        return result;
    }
}

package structural.proxy;

interface DatabaseAccess {
    void getAccess(User user);
}

class DatabaseAccessImpl implements DatabaseAccess {
    private String dbName;
    
    public DatabaseAccessImpl(String dbName) {
        this.dbName = dbName;
        System.out.println("Database called " + dbName + " is created");
    }
    
    @Override
    public void getAccess(User user) {
        System.out.println("User " + user.getUsername() + " granted access to the database called " + dbName);
    }
    
    public String getDbName() {
        return dbName;
    }
}

class DatabaseAccessProxy implements DatabaseAccess {
    private DatabaseAccessImpl databaseAccess;
    private User user;
    
    public DatabaseAccessProxy(String dbName, User user) {
        this.databaseAccess = new DatabaseAccessImpl(dbName);
        this.user = user;
    }
    
    @Override
    public void getAccess(User user) {
        if (user.getRole().equals("admin") || this.user.getUsername().equals(user.getUsername())) {
            databaseAccess.getAccess(user);
        } else {
            System.out.println("Denied access." +  user.getUsername() + " doesn't have right to access the database " + databaseAccess.getDbName());
        }
    }
}

class User {
    private String username;
    private String role;
    
    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getRole() {
        return role;
    }
}

class Client {
    public static void main(String[] args) {
        User admin = new User("admin", "admin");
        User user1 = new User("user1", "user");
        User user2 = new User("user2", "user");
        
        DatabaseAccess databaseAccess = new DatabaseAccessProxy("customers", user1);
        databaseAccess.getAccess(admin);
        databaseAccess.getAccess(user1);
        databaseAccess.getAccess(user2); 
    }
}

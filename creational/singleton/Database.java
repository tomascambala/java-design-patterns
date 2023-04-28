package creational.singleton;

public class Database {
    private static Database instance;
    private String dbName;

    private Database(String dbName) {
        this.dbName = dbName;
        System.out.println(dbName + " is created");
    }

    public static synchronized Database getInstance(String dbName) {
        if (instance == null) {
            instance = new Database(dbName);
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("Executing '" + query + "' on database " + dbName);
    }

    public void close() {
        System.out.println("Closing db " + dbName);
        instance = null;
    }
}

class Client {
    public static void main(String[] args) {
        Database db1 = Database.getInstance("db1");
        Database db2 = Database.getInstance("db2");

        System.out.println(db1 == db2); 

        db1.executeQuery("SELECT * FROM users");
        db1.executeQuery("UPDATE users SET name = 'Tomas' WHERE id = 2");

        db1.close();
        db2.executeQuery("SELECT * FROM users");
        db2.close();
    }
}

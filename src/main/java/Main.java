import manager.DatabaseManager;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        DatabaseManager dm = new DatabaseManager();
        dm.connect();

    }
}

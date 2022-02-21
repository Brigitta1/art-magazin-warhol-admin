package manager;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.SQLException;

public class DatabaseManager {

    public PGSimpleDataSource connect() throws SQLException {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setDatabaseName(System.getenv().get("DATABASE_NAME"));
        ds.setUser(System.getenv().get("PSQL_USERNAME"));
        ds.setPassword(System.getenv().get("PSQL_PASSWORD"));
        ds.getConnection().close();
        return ds;
    }
}

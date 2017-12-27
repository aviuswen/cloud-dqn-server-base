package cloud.dqn.config;

import cloud.dqn.models.DataResponse;
import cloud.dqn.models.ExceptionResponse;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Datasource {
    private HikariConfig hikariConfig;
    private HikariDataSource hikariDataSource;

    public Datasource(
            HikariConfig hikariConfig
    ) {
        this.hikariConfig = hikariConfig;
        this.hikariDataSource = new HikariDataSource(hikariConfig);
    }

    public ExceptionResponse testConnection(
    ) {
        ExceptionResponse response = new ExceptionResponse();
        if (hikariDataSource == null) {
            response.setError("Datasource is null");
        } else {
            Connection connection = null;
            Statement statement = null;
            try {
                connection = hikariDataSource.getConnection();
                if (connection == null) {
                    response.setError("data source get connection return null");
                } else {
                    statement = connection.createStatement();
                    if (statement == null) {
                        response.setError("data source connection create statement was null");
                    } else {
                        statement.executeQuery("SELECT 1");
                    }
                }
            } catch (SQLException e) {
                response.setException(e);
            } catch (Exception e) {
                response.setException("Unknown exception: " + e.toString(), e);
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Exception e) { /* empty block */ }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception e) { /* empty block*/ }
                }
            }

        }
        return response;
    }

    // TODO VALIDATIONS FOR PARAMETERS
    public static DataResponse<HikariConfig> configFactory(
            String poolName,
            String serverName,
            String portNumber,
            String databaseName,
            String user,
            String password
    ) {
        DataResponse<HikariConfig> response = new DataResponse<>(new HikariConfig());
        response.data.setPoolName(poolName);
        response.data.addDataSourceProperty("serverName", serverName);
        response.data.addDataSourceProperty("portNumber", portNumber);
        response.data.addDataSourceProperty("databaseName", databaseName);
        response.data.addDataSourceProperty("user", user);
        response.data.addDataSourceProperty("password", password);
        return response;
    }
}

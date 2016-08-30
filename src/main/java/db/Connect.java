package db;

import java.sql.*;
import java.util.Locale;


/**
 * Создает подключение к базе данных Oracle
 */
public class Connect {
    final private String driverName = "oracle.jdbc.driver.OracleDriver";
    private String url;
    final private String server = "localhost";
    final private int port = StaticConfiguration.port;
    final private String sid = "orcl";
    final private String username = "c##enet";
    final private String password = "enet";
    private Connection connection;
    private Statement statement = null;

    public Connect() {
        try {
            url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
            System.out.println(url);
            Class.forName(driverName);
            Locale.setDefault(Locale.ENGLISH);
            connection = DriverManager.getConnection(url, username, password);

            if (getConnectStatus()){
                statement = connection.createStatement();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        } catch (SQLException e) {
            System.out.println("SQLException" + e.getMessage());
        }

    }

    /**
     * @return Статус подключения
     */
    public boolean getConnectStatus() {
        return connection != null;
    }

    public Statement getStatement() {
        return statement;
    }

    /**
     * Закрывает connect,statement,resultSet
     * @param resultSet
     */
    public void closeConnect(ResultSet resultSet) {
        try {
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connect close");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Закрывает connect,statement
     */
    public void closeConnect() {
        try {
            statement.close();
            connection.close();
            System.out.println("Connect close");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
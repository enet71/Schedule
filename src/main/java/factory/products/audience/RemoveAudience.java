package factory.products.audience;

import db.Connect;
import factory.abstractProducts.Remove;

import java.sql.SQLException;
import java.sql.Statement;

public class RemoveAudience extends Remove{
    @Override
    public void deleteTable(String id) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();

        try {
            statement.executeUpdate("DELETE FROM AUDIENCE WHERE ID = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();

        }
    }
}

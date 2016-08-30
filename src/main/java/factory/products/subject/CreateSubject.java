package factory.products.subject;

import db.Connect;
import factory.abstractProducts.Create;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateSubject extends Create{
    /**
     * Добавляет новый предмет
     *
     * @param args Список параметров для создания.
     */
    @Override
    public void insert(String... args) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();
        try {
            statement.executeUpdate("INSERT INTO SUBJECT VALUES (null,'" + args[0] + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();
        }
    }
}

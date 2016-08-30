package factory.products.faculty;

import db.Connect;
import factory.abstractProducts.Create;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateFaculty extends Create{

    /**
     * Добавляет новый факультет
     *
     * @param args Список параметров для создания.
     */
    @Override
    public void insert(String... args) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();
        try {
            statement.executeUpdate("INSERT INTO FACULTY VALUES (null,'" + args[0] + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connect.closeConnect();
        }
    }
}

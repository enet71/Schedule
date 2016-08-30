package factory.products.teacher;

import db.Connect;
import factory.abstractProducts.Create;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateTeacher extends Create {
    /**
     * Добавляет нового преподавателя
     *
     * @param args Список параметров для создания.
     */
    @Override
    public void insert(String... args) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();
        try {
            statement.executeUpdate("INSERT INTO TEACHER VALUES (null,'" + args[0] + "','" + args[1] + "','" + args[2] + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();
        }

    }
}

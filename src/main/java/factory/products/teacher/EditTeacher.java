package factory.products.teacher;

import db.Connect;
import factory.abstractProducts.Edit;

import java.sql.SQLException;
import java.sql.Statement;

public class EditTeacher extends Edit{
    /**
     * Редактирует преподавателя
     *
     * @param args Список параметров для редактирования.
     */
    @Override
    public void updateTable(String... args) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();

        try {
            statement.executeUpdate("UPDATE TEACHER SET NAME='" + args[1] + "', SURNAME='" + args[2] + "', MIDDLENAME='" + args[3] + "' WHERE TEACHER.ID=" + args[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();
        }

    }
}

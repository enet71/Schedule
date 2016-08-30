package factory.products.subject;

import db.Connect;
import factory.abstractProducts.Edit;

import java.sql.SQLException;
import java.sql.Statement;

public class EditSubject extends Edit {
    /**
     * Редактирует предмет
     *
     * @param args Список параметров для редактирования.
     */
    @Override
    public void updateTable(String... args) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();

        try {
            statement.executeUpdate("UPDATE SUBJECT SET NAME='" + args[1] + "' WHERE SUBJECT.ID=" + args[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();
        }
    }
}

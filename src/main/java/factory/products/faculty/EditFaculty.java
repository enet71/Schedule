package factory.products.faculty;

import db.Connect;
import factory.abstractProducts.Edit;

import java.sql.SQLException;
import java.sql.Statement;

public class EditFaculty extends Edit{

    /**
     * Редактирует факультет
     * @param args Список параметров для редактирования.
     */
    @Override
    public void updateTable(String... args) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();

        try {
            statement.executeUpdate("UPDATE Faculty SET NAME='" + args[1] + "' WHERE ID=" + args[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();

        }
    }
}

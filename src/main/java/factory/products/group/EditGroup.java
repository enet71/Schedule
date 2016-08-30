package factory.products.group;

import db.Connect;
import factory.abstractProducts.Edit;

import java.sql.SQLException;
import java.sql.Statement;


public class EditGroup extends Edit {
    /**
     * Редактирует группу
     *
     * @param args Список параметров для редактирования.
     */
    @Override
    public void updateTable(String... args) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();

        try {
            statement.executeUpdate("UPDATE GRP SET NAME='" + args[1] + "', COURSE=" + args[2] + ", IDFACULTY=" + args[3] + " WHERE GRP.ID=" + args[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();

        }
    }
}

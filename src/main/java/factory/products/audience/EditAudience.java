package factory.products.audience;

import db.Connect;
import factory.abstractProducts.Edit;

import java.sql.SQLException;
import java.sql.Statement;

public class EditAudience extends Edit {
    /**
     * Редактирует аудиторию
     * @param args Список параметров для редактирования.
     */
    @Override
    public void updateTable(String... args) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();

        try {
            statement.executeUpdate("UPDATE AUDIENCE SET BUILDING='" + args[1] + "', NMB='" + args[2] + "' WHERE AUDIENCE.ID=" + args[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();

        }
    }
}

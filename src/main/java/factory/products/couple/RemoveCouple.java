package factory.products.couple;


import db.Connect;
import factory.abstractProducts.Remove;

import java.sql.SQLException;
import java.sql.Statement;

public class RemoveCouple extends Remove{
    /**
     * @param id Идентификационный номер пары которую нужно удалить
     */
    @Override
    public void deleteTable(String id) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();

        try {
            statement.executeUpdate("DELETE FROM COUPLE WHERE ID = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();

        }
    }
}

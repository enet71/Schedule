package factory.products.couple;

import db.Connect;
import factory.abstractProducts.Create;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateCouple extends Create{
    /**
     * Добавляет новую пару
     *
     * @param args Список параметров для создания.
     */
    @Override
    public void insert(String... args) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();
        try {
            System.out.println(args[1]);
            statement.executeUpdate("INSERT INTO COUPLE VALUES (null," + args[0] + "," + args[1] + ",'" + args[2] + "'," + args[3] + ",to_date('" + args[4] + "', 'dd.mm.yyyy'),to_date('" + args[5] + "', 'dd.mm.yyyy')," + args[6] + ",'" + args[7] + "'," + args[8] + ",'" + args[9] + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connect.closeConnect();
        }
    }
}

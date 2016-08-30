package factory.products.audience;

import db.Connect;
import factory.abstractProducts.Create;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateAudience extends Create{
    /**
     * ��������� ����� ���������
     *
     * @param args ������ ���������� ��� ��������.
     */
    @Override
    public void insert(String... args) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();
        try {
            statement.executeUpdate("INSERT INTO AUDIENCE VALUES (null,'" + args[0] + "','" + args[1] + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connect.closeConnect();
        }
    }
}

package factory.products.audience;

import db.Connect;
import factory.abstractProducts.Select;
import table.Audience;
import table.Group;
import table.Teacher;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SelectAudience extends Select {
    /**
     * ������� ����������� � ���� �����
     * �������� �� ���� ������ ���������� � ���������� � ��������� �� � ���������.
     * ��������� ����������� � ����.
     *
     * @return ���������� ArrayList � ������� � ����������
     */
    @Override
    public ArrayList<Audience> getList() {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();
        list = new ArrayList<Audience>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM AUDIENCE");
            while (resultSet.next()) {
                list.add(new Audience(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2), (resultSet.getString(3))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();
        }
        return list;
    }

    /**
     * ������� ����������� � ���� ������
     * �������� �� ���� ������ ���������� � ���������� � ��������� �� � Map.
     * ��������� ����������� � ����.
     *
     * @return ���������� Map � ������� � ����������
     */
    @Override
    public Map getMap() {
        Connect connect = new Connect();
        Statement st = connect.getStatement();
        map = new HashMap<String, Audience>();
        try {
            resultSet = st.executeQuery("SELECT * FROM AUDIENCE");
            while (resultSet.next()) {
                map.put(resultSet.getString(1), new Audience(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2), (resultSet.getString(3))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();
        }

        return map;
    }
}

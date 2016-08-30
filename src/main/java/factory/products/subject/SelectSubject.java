package factory.products.subject;

import db.Connect;
import factory.abstractProducts.Select;
import table.Group;
import table.Subject;
import table.Teacher;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SelectSubject extends Select {

    /**
     * ������� ����������� � ���� ������
     * �������� �� ���� ������ ���������� � ��������� � ��������� �� � ���������
     * ��������� ����������� � ����.
     *
     * @return ���������� ��������� � ������� � ���������
     */
    @Override
    public ArrayList getList() {
        Connect connect = new Connect();
        Statement st = connect.getStatement();
        list = new ArrayList<Group>();
        try {
            resultSet = st.executeQuery("SELECT * FROM SUBJECT");
            while (resultSet.next()) {
                list.add(new Subject(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2)));
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
     * �������� �� ���� ������ ���������� � ��������� � ��������� �� � Map
     * ��������� ����������� � ����.
     *
     * @return ���������� Map � ������� � ���������
     */
    @Override
    public Map getMap() {
        Connect connect = new Connect();
        Statement st = connect.getStatement();
        map = new HashMap<String, Subject>();
        try {
            resultSet = st.executeQuery("SELECT * FROM SUBJECT");
            while (resultSet.next()) {
                map.put(resultSet.getString(1), new Subject(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();

        }
        return map;
    }
}

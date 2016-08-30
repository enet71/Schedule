package factory.products.faculty;

import db.Connect;
import factory.abstractProducts.Select;
import table.Faculty;
import table.Group;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class SelectFaculty extends Select{
    /**
     * ������� ����������� � ���� ������
     * �������� �� ���� ������ ���������� � ����������� � ��������� �� � ���������
     * ��������� ����������� � ����.
     *
     * @return ���������� ��������� � ������� � �����������
     */
    @Override
    public ArrayList getList() {
        Connect connect = new Connect();
        Statement st = connect.getStatement();
        list = new ArrayList<Group>();
        try {
            resultSet = st.executeQuery("SELECT * FROM FACULTY");
            while (resultSet.next()){
                list.add(new Faculty(Integer.parseInt(resultSet.getString(1)),resultSet.getString(2)));
            }
            connect.closeConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Map getMap() {
        return null;
    }
}

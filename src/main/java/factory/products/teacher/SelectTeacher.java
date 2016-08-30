package factory.products.teacher;

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

public class SelectTeacher extends Select {
    @Override
    public ArrayList getList() {
        Connect connect = new Connect();
        Statement st = connect.getStatement();
        list = new ArrayList<Group>();
        try {
            resultSet = st.executeQuery("SELECT * FROM TEACHER");
            while (resultSet.next()) {
                list.add(new Teacher(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2), (resultSet.getString(3)), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();
        }

        return list;
    }

    /**
     * Создает подключение к базе данных
     * Получает из базы данных информацию о преподавателях и добавляет их в Map
     * Закрывает подключение к базе.
     *
     * @return Возвращает Map с данными о преподавателях
     */
    @Override
    public Map getMap() {
        Connect connect = new Connect();
        Statement st = connect.getStatement();
        map = new HashMap<String, Teacher>();
        try {
            resultSet = st.executeQuery("SELECT * FROM TEACHER");
            while (resultSet.next()) {
                map.put(resultSet.getString(1), new Teacher(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2), (resultSet.getString(3)), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();
        }

        return map;
    }
}

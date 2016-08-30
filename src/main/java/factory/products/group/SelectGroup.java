package factory.products.group;

import db.Connect;
import factory.abstractProducts.Select;
import table.Group;
import table.Teacher;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SelectGroup extends Select {
    /**
     * Создает подключение к базе данных
     * Получает из базы данных информацию о группах и добавляет их в коллекцию
     * Закрывает подключение к базе.
     *
     * @return Возвращает коллекцию с данными о группах
     */
    @Override
    public ArrayList<Group> getList() {
        Connect connect = new Connect();
        Statement st = connect.getStatement();
        list = new ArrayList<Group>();
        try {
            resultSet = st.executeQuery("SELECT * FROM grp");
            while (resultSet.next()){
                list.add(new Group(Integer.parseInt(resultSet.getString(1)),resultSet.getString(2),Integer.parseInt(resultSet.getString(3)),resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connect.closeConnect();
        }

        return list;
    }

    /**
     * Создает подключение к базе данных
     * Получает из базы данных информацию о группах и добавляет их в Map
     * Закрывает подключение к базе.
     *
     * @return Возвращает Map с данными о группах
     */
    @Override
    public Map getMap() {
        Connect connect = new Connect();
        Statement st = connect.getStatement();
        map = new HashMap<String,Group>();
        try {
            resultSet = st.executeQuery("SELECT * FROM GRP");
            while (resultSet.next()){
                map.put(resultSet.getString(1), new Group(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2), Integer.parseInt(resultSet.getString(3)), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connect.closeConnect();
        }

        return map;
    }

    @Override
    public ArrayList<Group> getList(String where) {
        Connect connect = new Connect();
        Statement st = connect.getStatement();
        list = new ArrayList<Group>();
        try {
            resultSet = st.executeQuery("SELECT * FROM grp WHERE " + where);
            while (resultSet.next()){
                list.add(new Group(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2), Integer.parseInt(resultSet.getString(3)), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connect.closeConnect();

        }
        return list;
    }
}

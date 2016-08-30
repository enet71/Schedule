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
     * Создает подключение к базе данных
     * Получает из базы данных информацию о факультетах и добавляет их в коллекцию
     * Закрывает подключение к базе.
     *
     * @return Возвращает коллекцию с данными о факультетах
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

package factory.products.couple;

import db.Connect;
import factory.abstractProducts.Select;
import table.Audience;
import table.Couple;
import table.Group;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class SelectCouple extends Select {
    /**
     * Создает подключение к базе даных
     * Получает из базы данных информацию о парах и добавляет их в коллекцию
     * Закрывает подключение к базе.
     *
     * @return Возвращает коллекцию с данными о парах
     */
    @Override
    public ArrayList getList() {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();
        list = new ArrayList<Group>();
        try {
            resultSet = statement.executeQuery("SELECT ID,IDSUBJECT,IDGROUP,NMB,IDAUDIENCE,to_char(BEGINC, 'dd.mm.yyyy'),to_char(ENDC, 'dd.mm.yyyy'),STAR,DAYWEEK,IDTEACHER,TYPE FROM COUPLE");
            while (resultSet.next()) {
                list.add(new Couple(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2), resultSet.getString(3), Integer.parseInt(resultSet.getString(4)), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), Integer.parseInt(resultSet.getString(8)), Integer.parseInt(resultSet.getString(9)), resultSet.getString(10), resultSet.getString(11)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();
        }
        return list;
    }

    @Override
    public Map getMap() {
        return null;
    }

    /**
     * Создает подключение к базе даных
     * Получает из базы данных информацию о парах и добавляет их в коллекцию
     * Закрывает подключение к базе.
     *
     * @param sql Условие вывода данных из базы
     * @return Возвращает коллекцию с данными о парах
     */
    public ArrayList getList(String sql) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();
        list = new ArrayList<Group>();
        try {
            resultSet = statement.executeQuery("SELECT ID,IDSUBJECT,IDGROUP,NMB,IDAUDIENCE,to_char(BEGINC, 'dd.mm.yyyy'),to_char(ENDC, 'dd.mm.yyyy'),STAR,DAYWEEK,IDTEACHER,TYPE FROM COUPLE WHERE " + sql);
            while (resultSet.next()) {
                list.add(new Couple(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2), resultSet.getString(3), Integer.parseInt(resultSet.getString(4)), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), Integer.parseInt(resultSet.getString(8)), Integer.parseInt(resultSet.getString(9)), resultSet.getString(10), resultSet.getString(11)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();
        }
        return list;
    }

    /**
     * Создает подключение к базе даных
     * Получает из базы данных информацию о парах и добавляет их в коллекцию
     * Закрывает подключение к базе.
     *
     * @param where Условие вывода данных из базы
     * @return Коллекцию данных из базы где все id заменены на данные из других таблиц
     */
    @Override
    public ArrayList getFullList(String where) {
        Connect connect = new Connect();
        Statement statement = connect.getStatement();
        list = new ArrayList<Group>();
        try {
            resultSet = statement.executeQuery("SELECT COUPLE.ID,SUBJECT.NAME,GRP.NAME,COUPLE.NMB,AUDIENCE.NMB,to_char(BEGINC, 'dd.mm.yyyy'),to_char(ENDC, 'dd.mm.yyyy'),STAR,DAYWEEK,TEACHER.NAME,TEACHER.SURNAME,TYPE FROM COUPLE,GRP,AUDIENCE,SUBJECT,TEACHER WHERE COUPLE.IDGROUP = GRP.ID AND COUPLE.IDTEACHER = TEACHER.ID AND COUPLE.IDAUDIENCE = AUDIENCE.ID AND COUPLE.IDSUBJECT = SUBJECT.ID and " + where);
            while (resultSet.next()) {
                list.add(new Couple(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2), resultSet.getString(3), Integer.parseInt(resultSet.getString(4)), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), Integer.parseInt(resultSet.getString(8)), Integer.parseInt(resultSet.getString(9)), resultSet.getString(10) + " " + resultSet.getString(11), resultSet.getString(12)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnect();
        }
        return list;
    }

    @Override
    public ArrayList getFullList(String where,Connect connect) {
        Statement statement = connect.getStatement();
        list = new ArrayList<Group>();
        try {
            resultSet = statement.executeQuery("SELECT COUPLE.ID,SUBJECT.NAME,GRP.NAME,COUPLE.NMB,AUDIENCE.NMB,to_char(BEGINC, 'dd.mm.yyyy'),to_char(ENDC, 'dd.mm.yyyy'),STAR,DAYWEEK,TEACHER.NAME,TEACHER.SURNAME,TYPE FROM COUPLE,GRP,AUDIENCE,SUBJECT,TEACHER WHERE COUPLE.IDGROUP = GRP.ID AND COUPLE.IDTEACHER = TEACHER.ID AND COUPLE.IDAUDIENCE = AUDIENCE.ID AND COUPLE.IDSUBJECT = SUBJECT.ID and " + where);
            while (resultSet.next()) {
                list.add(new Couple(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2), resultSet.getString(3), Integer.parseInt(resultSet.getString(4)), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), Integer.parseInt(resultSet.getString(8)), Integer.parseInt(resultSet.getString(9)), resultSet.getString(10) + " " + resultSet.getString(11), resultSet.getString(12)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

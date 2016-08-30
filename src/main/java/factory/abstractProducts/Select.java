package factory.abstractProducts;

import db.Connect;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public abstract class Select {
    protected ResultSet resultSet;
    protected ArrayList list;
    protected Map map;

    public abstract ArrayList getList();

    public abstract Map getMap();

    public ArrayList getList(String where) {
        return null;
    }

    public ArrayList getList(String where, Connect connect) {
        return null;
    }

    public ArrayList getFullList(String where) {
        return null;
    }

    public ArrayList getFullList(String where,Connect connect) {
        return null;
    }
}

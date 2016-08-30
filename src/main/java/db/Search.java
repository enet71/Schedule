package db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Создает новый поток для перебора портов.
 */
public class Search extends Thread{
    int x;
    int x1;
    Search(int x, int x1){
        this.x = x;
        this.x1 = x1;
        start();
    }
    public void run(){
        for (int i = x; i < x1; i++) {
            try {
                String url = "jdbc:oracle:thin:@" + "localhost" + ":" + i + ":" + "orcl";
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Locale.setDefault(Locale.ENGLISH);
                if(StaticConfiguration.connection == null) {
                    StaticConfiguration.connection = DriverManager.getConnection(url, "c##enet", "enet");
                    StaticConfiguration.port = i;
                }else {
                    StaticConfiguration.work = false;
                }
            } catch (ClassNotFoundException ignored) {

            } catch (SQLException ignored) {

            } catch (StringIndexOutOfBoundsException ignored){

            }
        }
    }
}

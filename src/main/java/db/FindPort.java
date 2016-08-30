package db;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * ��������� ���� �� �����������
 * ���� ���� �� ������� ���������� ������� ��� ������ �����.
 * �� ������ ����� ������ �������� � 100 ������.
 * ����� ���� ��� ������� �����, ����� ����� ������ ������ ���� �� ���������� ������ ��� �� ������� ��� ����.
 */
public class FindPort {
    public static void start() {
        Connect connect = new Connect();
        if (!connect.getConnectStatus()) {
            if (!StaticConfiguration.work || (Calendar.getInstance().getTimeInMillis() > (StaticConfiguration.calendar.getTimeInMillis()+1800000))) {
                for (int i = 100; i < 1000; i++) {
                    new Search(100 * i, 100 * (i + 1));
                }
                StaticConfiguration.work = true;
                StaticConfiguration.calendar = new GregorianCalendar();
            } else {
                System.out.println("Port searching");
            }

        }else {
            connect.closeConnect();
        }
    }
}

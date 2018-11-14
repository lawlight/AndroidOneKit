package top.onehundred.android.kits.kits;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期与时间工具类
 */
public class DatetimeKit {

    private static String defaultFormat = "yyyy-MM-dd HH:mm:ss";

    private static DatetimeKit datetimeKit;

    public static DatetimeKit getInstance(){
        if(datetimeKit == null){
            synchronized (DatetimeKit.class){
                if(datetimeKit == null){
                    datetimeKit = new DatetimeKit();
                }
            }
        }
        return datetimeKit;
    }

    public String date2Str(Date date, String format){
        return null;
    }

    public Date str2Date(String text, String format) {
        return new Date();
    }

    public String Calendar2Str(Calendar calendar, String format){
        return null;
    }

    public Calendar str2Calendar(String text, String format) {
        return Calendar.getInstance();
    }

    public String formatDatetime(String text, String from, String to) {
        return null;
    }

    public String getTimeDesc(Date date, String format) {
        return null;
    }

}

package top.onehundred.android.kits.kits;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

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

    /**
     * 获取当前时间时间戳
     * @return
     */
    public long getTime(){
        return new Date().getTime();
    }

    /**
     * 获取秒单位时间戳
     * @return
     */
    public long getUnixTime(){
        return new Date().getTime() / 1000L;
    }

    /**
     * 获取GMT格式时间字符串
     * @return
     */
    public String getGMTTime(){
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss 'GMT'", java.util.Locale.US);
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
        return sdf.format(cd.getTime());
    }

    /**
     * Date对象转String
     * @param date 时间，默认为当前时间
     * @param format 格式，默认为yyyy-MM-dd HH:mm:ss
     * @return
     */
    public String date2Str(Date date, String format){
        if (date == null) {
            date = new Date();
        }
        if(format == null){
            format = defaultFormat;
        }
        SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
        return simpleFormat.format(date);
    }

    /**
     *
     * @param text
     * @param format 格式，默认为yyyy-MM-dd HH:mm:ss
     * @return
     */
    public Date str2Date(String text, String format) {
        if(format == null){
            format = defaultFormat;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(text);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     *
     * @param calendar
     * @param format 格式，默认为yyyy-MM-dd HH:mm:ss
     * @return
     */
    public String Calendar2Str(Calendar calendar, String format){
        if(calendar == null){
            calendar = Calendar.getInstance();
        }
        return date2Str(calendar.getTime(), format);
    }

    /**
     * 时间字符串转为Calendar对象
     * @param text
     * @param format 格式，默认为yyyy-MM-dd HH:mm:ss
     * @return
     */
    public Calendar str2Calendar(String text, String format) {
        Date date = str2Date(text, format);
        if(date == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 格式化时间字符串
     * @param text 时间文本
     * @param from 原格式
     * @param to 目标格式
     * @return
     */
    public String formatDatetime(String text, String from, String to) {
        SimpleDateFormat fromSDF = new SimpleDateFormat(from);
        SimpleDateFormat toSDK = new SimpleDateFormat(to);
        try {
            Date date = fromSDF.parse(text);
            return toSDK.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return text;
        }
    }

    /**
     * 获取输入时间的时间段描述：<br/>
     * 1分钟内显示刚刚<br/>
     * 1小时内显示XX分钟前<br/>
     * 1天内显示XX小时前<br/>
     * 超过一天按照format格式显示日期
     * @param date 时间，如果date传null，返回空字符串
     * @param format 格式，默认为yyyy-MM-dd HH:mm:ss
     * @return
     */
    public String getTimeDesc(Date date, String format) {
        if(date == null){
            return "";
        }
        Date nowDate = new Date();
        long diff = (nowDate.getTime() - date.getTime()) / 1000;
        if (diff < 60) {
            return "刚刚";
        }
        if (diff < 3600) {
            return (diff / 60) + "分钟前";
        }
        if (diff < 24 * 3600) {
            return (diff / 3600) + "小时前";
        }
        SimpleDateFormat returnSdf = new SimpleDateFormat(format);
        return returnSdf.format(date);
    }

    /**
     * 显示系统日期选择对话框
     * @param context
     * @param calendar 默认日期
     * @param onDateSetListener 回调监听
     */
    public void showDatePickerDialog(Context context, Calendar calendar,DatePickerDialog.OnDateSetListener onDateSetListener){
        if(calendar == null){
            calendar = Calendar.getInstance();
        }
        DatePickerDialog dialog = new DatePickerDialog(context, onDateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    /**
     * 显示系统时间选择对话框
     * @param context
     * @param calendar 默认时间
     * @param onTimeSetListener 回调监听
     */
    public void showTimePickerDialog(Context context, Calendar calendar, TimePickerDialog.OnTimeSetListener onTimeSetListener){
        if(calendar == null){
            calendar = Calendar.getInstance();
        }
        TimePickerDialog dialog = new TimePickerDialog(context, onTimeSetListener,calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), true);
        dialog.show();
    }

}

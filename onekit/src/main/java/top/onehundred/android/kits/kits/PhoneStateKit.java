package top.onehundred.android.kits.kits;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import top.onehundred.android.kits.ok;

/**
 * 手机状态工具包<br />
 * 需要权限 Manifest.permission.ACCESS_NETWORK_STATE
 */
public class PhoneStateKit {

    private static PhoneStateKit phoneStateKit;
    public static PhoneStateKit getInstance(){
        if(phoneStateKit == null){
            synchronized (PhoneStateKit.class){
                if(phoneStateKit == null){
                    phoneStateKit = new PhoneStateKit();
                }
            }
        }
        return phoneStateKit;
    }

    /**
     * 判断网络是否连接
     *
     * @return
     */
    public boolean isConnected() {

        ConnectivityManager connectivity = (ConnectivityManager) ok.app().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (null != connectivity) {

            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否是wifi连接
     */
    public boolean isWifi() {
        ConnectivityManager cm = (ConnectivityManager) ok.app().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm == null)
            return false;
        return cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;

    }

//    public interface BatteryStateReceiver{
//        void onBatteryStateReceived();
//    }
//
//    public String batteryState(BatteryStateReceiver receiver){
//        IntentFilter iFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
//        Intent intent = ok.app().registerReceiver(null, iFilter);
//        int rawLevel = intent.getIntExtra("level", 0);      //获得当前电量
//        int scale = intent.getIntExtra("scale", 0);         //获得总电量
//        //BatteryManager.BATTERY_STATUS_UNKNOWN
//        int status = intent.getIntExtra("status", 0);       //电池充电状态
//        int health = intent.getIntExtra("voltage", 0);      //电池健康状况
//        int batteryV = intent.getIntExtra("voltage", 0);    //电池电压(mv)
//        int temperature = intent.getIntExtra("temperature", 0); //电池温度(数值)
//        double t = temperature / 10.0;  //电池摄氏温度，默认获取的非摄氏温度值，需做一下运算转换
//        String targetStr = "";
//        int level = -1;
//        if(rawLevel > 0 && scale > 0)
//        {
//            level = (rawLevel * 100) / scale;
//            targetStr = level + "|" + scale + "|" + status;
//        }
//        return targetStr;
//    }

}

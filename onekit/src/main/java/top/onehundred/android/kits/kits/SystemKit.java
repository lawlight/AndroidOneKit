package top.onehundred.android.kits.kits;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;

import java.util.Locale;

import top.onehundred.android.kits.ok;

public class SystemKit {

    public static SystemKit getInstance(){
        return new SystemKit();
    }

    /**
     * get android phone system version
     *
     * @return phone system version
     */
    public String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * get phone model
     *
     * @return phone model
     */
    public String getDeviceModel() {
        return android.os.Build.MODEL;
    }

    /**
     * get phone brand
     *
     * @return phone brand
     */
    public String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * get android id
     * @return
     */
    public String getAndroidId() {
        return Settings.Secure.getString(ok.app().getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * get serial
     * @return
     */
    public String getSerial(){
        return android.os.Build.SERIAL;
    }

    /**
     * get system language code
     * @return
     */
    public String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * get local country code
     * @return
     */
    public String getCountry(){
        Resources res = ok.app().getResources();
        Configuration config = res.getConfiguration();
        return config.locale.getCountry();
    }
}

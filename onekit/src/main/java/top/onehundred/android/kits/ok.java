package top.onehundred.android.kits;

import android.app.Application;
import android.content.Context;

import top.onehundred.android.kits.kits.AppKit;
import top.onehundred.android.kits.kits.DialogKit;
import top.onehundred.android.kits.kits.IntentKit;
import top.onehundred.android.kits.kits.StringKit;
import top.onehundred.android.kits.kits.SystemKit;

public class ok {

    private static Application mApplication;

    /**
     * 初始化，使用前必须调用
     * @param application
     */
    public static void init(Application application){
        mApplication = application;
    }

    /**
     * 获取当前Application
     * @return
     */
    public static Application app(){
        return mApplication;
    }

    /**
     * 字符串工具包
     * @return
     */
    public static StringKit stringKit(){
        return StringKit.getInstance();
    }

    /**
     * 对话框工具包
     * @param context
     * @return
     */
    public static DialogKit dialogKit(Context context) {
        return DialogKit.getInstance(context);
    }

    /**
     * App信息工具包
     * @return
     */
    public static AppKit appKit() {
        return AppKit.getInstance();
    }

    /**
     * 系统信息工具包
     * @return
     */
    public static SystemKit systemKit() {
        return SystemKit.getInstance();
    }

    /**
     * 系统应用工具包
     * @param context
     * @return
     */
    public static IntentKit intentKit(Context context){
        return IntentKit.getInstance(context);
    }


}

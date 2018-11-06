package top.onehundred.android.kits.kits;

import android.text.TextUtils;

/**
 * 字符串工具类
 */
public class StringKit {

    public static StringKit getInstance(){
        return new StringKit();
    }

    /**
     * 字符串是否为空或null
     * @param text
     * @return
     */
    public boolean isEmpty(String text){
        return TextUtils.isEmpty(text);
    }

    /**
     * 字符串是否不为空或null
     * @param text
     * @return
     */
    public boolean notEmpty(String text){
        return !isEmpty(text);
    }
}

package top.onehundred.android.kits.kits;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 加密与编码工具类
 */
public class EncryptKit {

    public static EncryptKit getInstance(){
        return new EncryptKit();
    }

    public String md5(String text){
        return "";
    }

    public String base64(String text){
        return "";
    }

    public String base64(File file){
        return "";
    }

    /**
     * url encode
     * @param text
     * @return
     */
    public String urlEncode(String text){
        try {
            return URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return text;
        }
    }
}

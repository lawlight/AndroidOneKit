package top.onehundred.android.kits.kits;

import android.content.Context;
import android.util.TypedValue;

import top.onehundred.android.kits.ok;

public class DensityKit {

    public static DensityKit getInstance(){
        return new DensityKit();
    }

    /**
     * dp转px
     *
     * @param dpVal dp值
     * @return px值
     */
    public int dp2px(float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, ok.app().getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     *
     * @param spVal sp值
     * @return px值
     */
    public int sp2px(float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, ok.app().getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     *
     * @param pxVal px值
     * @return dp值
     */
    public float px2dp(float pxVal) {
        final float scale = ok.app().getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     *
     * @param pxVal px值
     * @return sp值
     */
    public float px2sp(float pxVal) {
        return (pxVal / ok.app().getResources().getDisplayMetrics().scaledDensity);
    }
}

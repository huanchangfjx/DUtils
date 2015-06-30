package com.brcorner.commonlib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by dong on 2015/6/29.
 */
public class CommonUtils {

    private CommonUtils()
    {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 生成随机数字
     * @return
     */
    public static String generateNum()
    {
        return "" + System.currentTimeMillis() + "_" + (int) (Math.random() * 10000);
    }

    /**
     * 获取屏幕宽度
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources()
                .getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    /**
     * 获取屏幕高度
     * @param context
     * @return
     */
    public int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources()
                .getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

    /**
     * 获取状态栏的高度
     * @param activity
     * @return
     */
    public int getStatusBarHeight(Activity activity) {
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        return statusBarHeight;
    }

    /**
     * 获取versionCode
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        int version = 0;
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名�代表是获取版本信�
        PackageInfo packInfo;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(),
                    0);
            version = packInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    /**
     * 格式化时间
     * @param date
     * @return
     */
    public static String dateFormate(String date)
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String sd = sdf.format(new Date(Long.parseLong(date)));

        return sd;
    }

    /**
     * 截取url的最后面一部分
     * @param url
     * @return
     */
    public static String getUrlLastPart(String url)
    {
        int i = url.lastIndexOf("/");
        return url.substring(i+1, url.length());
    }

    /**
     * 判断手机连接
     * @param context
     * @return
     */
    public static boolean isConnect(Context context) {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                // 获取网络连接管理的对象
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null && info.isConnected()) {
                    // 判断当前网络是否已经连接
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            Log.v("error", e.toString());
        }
        return false;
    }

    /**
     * 获取设备的语言环境
     * @param context
     * @return
     */
    public static String getDeviceLanguage(Context context)
    {
        String languageStr;
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getCountry();
        switch (language){
            //中文简体
            case "CN":
                languageStr = "CN";
                break;
            //中文繁体
            case "TW":
                languageStr = "TW";
                break;
            //日本语
            case "JP":
                languageStr = "JP";
                break;
            //美国
            case "US":
                languageStr = "US";
                break;
            //加拿大
            case "CA":
                languageStr = "CA";
                break;
            //澳大利亚
            case "AU":
                languageStr = "AU";
                break;
            //英国
            case "GB":
                languageStr = "GB";
                break;

            default:
                languageStr = language;
                break;
        }
        return languageStr;
    }
}

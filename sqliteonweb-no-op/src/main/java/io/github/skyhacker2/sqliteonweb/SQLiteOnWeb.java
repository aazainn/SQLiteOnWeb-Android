package io.github.skyhacker2.sqliteonweb;

import android.content.Context;
import android.net.wifi.WifiManager;

/**
 * Created by eleven on 16/4/3.
 */
public class SQLiteOnWeb {
    private final Context mContext;
    private final int mPort;
    private static SQLiteOnWeb mSQLiteOnWeb;

    public static SQLiteOnWeb init(Context context) {
        if (mSQLiteOnWeb == null){
            mSQLiteOnWeb = new SQLiteOnWeb(context);
        }
        return mSQLiteOnWeb;
    }

    public static SQLiteOnWeb init(Context context, int port) {
        if (mSQLiteOnWeb == null){
            mSQLiteOnWeb = new SQLiteOnWeb(context, port);
        }
        return mSQLiteOnWeb;
    }

    private SQLiteOnWeb(Context context) {
        this(context, 9000);
    }

    private SQLiteOnWeb(Context context, int port) {
        mContext = context;
        mPort = port;
    }

    public void start() {

    }

    public String getIpAccess() {
        WifiManager wifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
        final String formatedIpAddress = String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff), (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));
        return "http://" + formatedIpAddress + ":" + mPort;
    }
}

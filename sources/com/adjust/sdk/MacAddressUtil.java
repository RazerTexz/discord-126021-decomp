package com.adjust.sdk;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class MacAddressUtil {
    public static String getMacAddress(Context context) {
        String rawMacAddress = getRawMacAddress(context);
        if (rawMacAddress == null) {
            return null;
        }
        return removeSpaceString(rawMacAddress.toUpperCase(Locale.US));
    }

    private static String getRawMacAddress(Context context) {
        String strLoadAddress = loadAddress("wlan0");
        if (strLoadAddress != null) {
            return strLoadAddress;
        }
        String strLoadAddress2 = loadAddress("eth0");
        if (strLoadAddress2 != null) {
            return strLoadAddress2;
        }
        try {
            String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (macAddress != null) {
                return macAddress;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String loadAddress(String str) {
        try {
            StringBuilder sb = new StringBuilder(1000);
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/sys/class/net/" + str + "/address"), 1024);
            char[] cArr = new char[1024];
            while (true) {
                int i = bufferedReader.read(cArr);
                if (i == -1) {
                    bufferedReader.close();
                    return sb.toString();
                }
                sb.append(String.valueOf(cArr, 0, i));
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private static String removeSpaceString(String str) {
        if (str == null) {
            return null;
        }
        String strReplaceAll = str.replaceAll("\\s", "");
        if (TextUtils.isEmpty(strReplaceAll)) {
            return null;
        }
        return strReplaceAll;
    }
}

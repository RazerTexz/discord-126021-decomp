package org.webrtc;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiInfo;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkMonitorAutoDetect$WifiManagerDelegate {

    @Nullable
    private final Context context;

    public NetworkMonitorAutoDetect$WifiManagerDelegate(Context context) {
        this.context = context;
    }

    public String getWifiSSID() {
        WifiInfo wifiInfo;
        String ssid;
        Intent intentRegisterReceiver = this.context.registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        return (intentRegisterReceiver == null || (wifiInfo = (WifiInfo) intentRegisterReceiver.getParcelableExtra("wifiInfo")) == null || (ssid = wifiInfo.getSSID()) == null) ? "" : ssid;
    }

    public NetworkMonitorAutoDetect$WifiManagerDelegate() {
        this.context = null;
    }
}

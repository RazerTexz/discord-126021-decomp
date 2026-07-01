package com.adjust.sdk;

import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class UtilNetworking$ConnectionOptions implements UtilNetworking$IConnectionOptions {
    @Override // com.adjust.sdk.UtilNetworking$IConnectionOptions
    public void applyConnectionOptions(HttpsURLConnection httpsURLConnection, String str) {
        httpsURLConnection.setRequestProperty("Client-SDK", str);
        httpsURLConnection.setConnectTimeout(60000);
        httpsURLConnection.setReadTimeout(60000);
        if (UtilNetworking.access$000() != null) {
            httpsURLConnection.setRequestProperty("User-Agent", UtilNetworking.access$000());
        }
    }
}

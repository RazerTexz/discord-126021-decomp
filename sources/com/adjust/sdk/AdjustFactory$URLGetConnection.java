package com.adjust.sdk;

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class AdjustFactory$URLGetConnection {
    public HttpsURLConnection httpsURLConnection;
    public URL url;

    public AdjustFactory$URLGetConnection(HttpsURLConnection httpsURLConnection, URL url) {
        this.httpsURLConnection = httpsURLConnection;
        this.url = url;
    }
}

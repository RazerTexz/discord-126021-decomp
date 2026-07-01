package com.adjust.sdk;

import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class AdjustFactory$1 implements UtilNetworking$IConnectionOptions {
    @Override // com.adjust.sdk.UtilNetworking$IConnectionOptions
    public void applyConnectionOptions(HttpsURLConnection httpsURLConnection, String str) {
        new UtilNetworking$ConnectionOptions().applyConnectionOptions(httpsURLConnection, str);
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new AdjustFactory$1$1(this)}, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(new AdjustFactory$1$2(this));
        } catch (Exception e) {
            AdjustFactory.getLogger().error("testingMode error %s", e.getMessage());
        }
    }
}

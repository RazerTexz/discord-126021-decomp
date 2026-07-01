package com.adjust.sdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class AdjustFactory$1$1 implements X509TrustManager {
    public final /* synthetic */ AdjustFactory$1 this$0;

    public AdjustFactory$1$1(AdjustFactory$1 adjustFactory$1) {
        this.this$0 = adjustFactory$1;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        AdjustFactory.getLogger().verbose("checkClientTrusted ", new Object[0]);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        AdjustFactory.getLogger().verbose("checkServerTrusted ", new Object[0]);
        try {
            if (AdjustFactory.access$000(MessageDigest.getInstance("SHA1").digest(x509CertificateArr[0].getEncoded())).equalsIgnoreCase("7BCFF44099A35BC093BB48C5A6B9A516CDFDA0D1")) {
            } else {
                throw new CertificateException();
            }
        } catch (NoSuchAlgorithmException e) {
            AdjustFactory.getLogger().error("testingMode error %s", e.getMessage());
        } catch (CertificateEncodingException e2) {
            AdjustFactory.getLogger().error("testingMode error %s", e2.getMessage());
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        AdjustFactory.getLogger().verbose("getAcceptedIssuers", new Object[0]);
        return null;
    }
}

package com.adjust.sdk;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public class AdjustFactory$1$2 implements HostnameVerifier {
    public final /* synthetic */ AdjustFactory$1 this$0;

    public AdjustFactory$1$2(AdjustFactory$1 adjustFactory$1) {
        this.this$0 = adjustFactory$1;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        AdjustFactory.getLogger().verbose("verify hostname ", new Object[0]);
        return true;
    }
}

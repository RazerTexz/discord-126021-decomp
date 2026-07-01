package com.discord.restapi;

import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$RemoteAuthInitialize {
    private final String fingerprint;

    public RestAPIParams$RemoteAuthInitialize(String str) {
        m.checkNotNullParameter(str, "fingerprint");
        this.fingerprint = str;
    }
}

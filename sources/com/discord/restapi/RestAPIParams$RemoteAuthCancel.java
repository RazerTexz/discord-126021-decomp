package com.discord.restapi;

import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$RemoteAuthCancel {
    private final String handshakeToken;

    public RestAPIParams$RemoteAuthCancel(String str) {
        m.checkNotNullParameter(str, "handshakeToken");
        this.handshakeToken = str;
    }
}

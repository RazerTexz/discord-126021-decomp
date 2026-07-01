package com.discord.p000native.engine;


/* JADX INFO: compiled from: NativeConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public interface NativeConnection$OnPingTimeoutCallback {
    void onPingTimeout(String server, int port, int seq, int timeout);
}

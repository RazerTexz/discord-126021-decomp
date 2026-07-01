package com.hammerandchisel.libdiscord;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class Discord$ConnectionInfo {
    public boolean isConnected;

    @NonNull
    public String localAddress;
    public int localPort;

    @NonNull
    public String protocol;

    public Discord$ConnectionInfo(boolean z2, @NonNull String str, @NonNull String str2, int i) {
        this.isConnected = z2;
        this.protocol = str;
        this.localAddress = str2;
        this.localPort = i;
    }
}

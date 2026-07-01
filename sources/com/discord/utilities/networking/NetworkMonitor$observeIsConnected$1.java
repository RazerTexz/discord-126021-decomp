package com.discord.utilities.networking;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: NetworkMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkMonitor$observeIsConnected$1<T, R> implements b<NetworkMonitor$State, Boolean> {
    public static final NetworkMonitor$observeIsConnected$1 INSTANCE = new NetworkMonitor$observeIsConnected$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(NetworkMonitor$State networkMonitor$State) {
        return call2(networkMonitor$State);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(NetworkMonitor$State networkMonitor$State) {
        return Boolean.valueOf(networkMonitor$State == NetworkMonitor$State.ONLINE);
    }
}

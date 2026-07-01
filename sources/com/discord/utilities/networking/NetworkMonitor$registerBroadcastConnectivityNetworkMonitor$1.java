package com.discord.utilities.networking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;

/* JADX INFO: compiled from: NetworkMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkMonitor$registerBroadcastConnectivityNetworkMonitor$1 extends BroadcastReceiver {
    public final /* synthetic */ NetworkMonitor this$0;

    public NetworkMonitor$registerBroadcastConnectivityNetworkMonitor$1(NetworkMonitor networkMonitor) {
        this.this$0 = networkMonitor;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(intent, "intent");
        Logger.i$default(NetworkMonitor.access$getLogger$p(this.this$0), "[NetworkMonitor]", "Got connectivity action broadcast intent.", null, 4, null);
        NetworkMonitor.access$updateNetworkState(this.this$0, context, intent);
    }
}

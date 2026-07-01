package com.discord.utilities.networking;

import android.net.ConnectivityManager;
import android.net.NetworkRequest$Builder;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: NetworkMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkMonitor$registerConnectivityNetworkMonitor$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ConnectivityManager $connectivityManager;
    public final /* synthetic */ NetworkMonitor$registerConnectivityNetworkMonitor$networkCallback$1 $networkCallback;
    public final /* synthetic */ NetworkMonitor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkMonitor$registerConnectivityNetworkMonitor$1(NetworkMonitor networkMonitor, ConnectivityManager connectivityManager, NetworkMonitor$registerConnectivityNetworkMonitor$networkCallback$1 networkMonitor$registerConnectivityNetworkMonitor$networkCallback$1) {
        super(0);
        this.this$0 = networkMonitor;
        this.$connectivityManager = connectivityManager;
        this.$networkCallback = networkMonitor$registerConnectivityNetworkMonitor$networkCallback$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        try {
            this.$connectivityManager.registerNetworkCallback(new NetworkRequest$Builder().build(), this.$networkCallback);
        } catch (Exception e) {
            NetworkMonitor.access$getLogger$p(this.this$0).i("[NetworkMonitor]", "Unable to register network callback.", e);
        }
    }
}

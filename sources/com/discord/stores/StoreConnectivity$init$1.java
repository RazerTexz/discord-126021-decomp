package com.discord.stores;

import com.discord.utilities.networking.NetworkMonitor$State;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreConnectivity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreConnectivity$init$1 extends k implements Function1<NetworkMonitor$State, Unit> {
    public StoreConnectivity$init$1(StoreConnectivity storeConnectivity) {
        super(1, storeConnectivity, StoreConnectivity.class, "handleDeviceNetworkStateUpdated", "handleDeviceNetworkStateUpdated(Lcom/discord/utilities/networking/NetworkMonitor$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NetworkMonitor$State networkMonitor$State) {
        invoke2(networkMonitor$State);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(NetworkMonitor$State networkMonitor$State) {
        m.checkNotNullParameter(networkMonitor$State, "p1");
        StoreConnectivity.access$handleDeviceNetworkStateUpdated((StoreConnectivity) this.receiver, networkMonitor$State);
    }
}

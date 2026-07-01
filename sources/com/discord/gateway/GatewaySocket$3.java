package com.discord.gateway;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$3<T> implements Action1<Boolean> {
    public final /* synthetic */ GatewaySocket this$0;

    public GatewaySocket$3(GatewaySocket gatewaySocket) {
        this.this$0 = gatewaySocket;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        GatewaySocket gatewaySocket = this.this$0;
        m.checkNotNullExpressionValue(bool, "isConnected");
        GatewaySocket.access$handleDeviceConnectivityChange(gatewaySocket, bool.booleanValue());
    }
}

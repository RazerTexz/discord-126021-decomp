package com.discord.stores;

import com.discord.gateway.GatewaySocket;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$voiceServerPing$1 extends o implements Function1<GatewaySocket, Unit> {
    public static final StoreGatewayConnection$voiceServerPing$1 INSTANCE = new StoreGatewayConnection$voiceServerPing$1();

    public StoreGatewayConnection$voiceServerPing$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
        invoke2(gatewaySocket);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "it");
        gatewaySocket.voiceServerPing();
    }
}

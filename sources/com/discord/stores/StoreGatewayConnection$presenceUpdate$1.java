package com.discord.stores;

import com.discord.api.presence.ClientStatus;
import com.discord.gateway.GatewaySocket;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$presenceUpdate$1 extends o implements Function1<GatewaySocket, Unit> {
    public final /* synthetic */ List $activities;
    public final /* synthetic */ Boolean $afk;
    public final /* synthetic */ Long $since;
    public final /* synthetic */ ClientStatus $status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGatewayConnection$presenceUpdate$1(ClientStatus clientStatus, Long l, List list, Boolean bool) {
        super(1);
        this.$status = clientStatus;
        this.$since = l;
        this.$activities = list;
        this.$afk = bool;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
        invoke2(gatewaySocket);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "it");
        gatewaySocket.presenceUpdate(this.$status, this.$since, this.$activities, this.$afk);
    }
}

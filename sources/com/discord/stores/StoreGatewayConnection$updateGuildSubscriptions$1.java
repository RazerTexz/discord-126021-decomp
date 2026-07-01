package com.discord.stores;

import com.discord.gateway.GatewaySocket;
import com.discord.gateway.io.OutgoingPayload$GuildSubscriptions;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$updateGuildSubscriptions$1 extends o implements Function1<GatewaySocket, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ OutgoingPayload$GuildSubscriptions $payload;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGatewayConnection$updateGuildSubscriptions$1(long j, OutgoingPayload$GuildSubscriptions outgoingPayload$GuildSubscriptions) {
        super(1);
        this.$guildId = j;
        this.$payload = outgoingPayload$GuildSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
        invoke2(gatewaySocket);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "it");
        gatewaySocket.updateGuildSubscriptions(this.$guildId, this.$payload);
    }
}

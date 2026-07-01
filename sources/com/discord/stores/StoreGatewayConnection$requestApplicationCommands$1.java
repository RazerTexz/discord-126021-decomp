package com.discord.stores;

import com.discord.gateway.GatewaySocket;
import com.discord.gateway.io.OutgoingPayload$ApplicationCommandRequest;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$requestApplicationCommands$1 extends o implements Function1<GatewaySocket, Unit> {
    public final /* synthetic */ boolean $applications;
    public final /* synthetic */ List $commandIds;
    public final /* synthetic */ int $commandLimit;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ String $nonce;
    public final /* synthetic */ Integer $offset;
    public final /* synthetic */ String $query;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGatewayConnection$requestApplicationCommands$1(long j, String str, boolean z2, Integer num, String str2, int i, List list) {
        super(1);
        this.$guildId = j;
        this.$nonce = str;
        this.$applications = z2;
        this.$offset = num;
        this.$query = str2;
        this.$commandLimit = i;
        this.$commandIds = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
        invoke2(gatewaySocket);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "it");
        long j = this.$guildId;
        String str = this.$nonce;
        boolean z2 = this.$applications;
        gatewaySocket.requestApplicationCommands(new OutgoingPayload$ApplicationCommandRequest(j, this.$query, this.$offset, Integer.valueOf(this.$commandLimit), z2, str, this.$commandIds));
    }
}

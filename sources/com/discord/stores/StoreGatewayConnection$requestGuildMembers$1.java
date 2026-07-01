package com.discord.stores;

import com.discord.gateway.GatewaySocket;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$requestGuildMembers$1 extends o implements Function1<GatewaySocket, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Integer $limit;
    public final /* synthetic */ String $query;
    public final /* synthetic */ List $userIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGatewayConnection$requestGuildMembers$1(long j, String str, List list, Integer num) {
        super(1);
        this.$guildId = j;
        this.$query = str;
        this.$userIds = list;
        this.$limit = num;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
        invoke2(gatewaySocket);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "it");
        gatewaySocket.requestGuildMembers(d0.t.m.listOf(Long.valueOf(this.$guildId)), this.$query, this.$userIds, this.$limit);
    }
}

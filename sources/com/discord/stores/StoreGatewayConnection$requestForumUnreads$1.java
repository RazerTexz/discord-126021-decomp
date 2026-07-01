package com.discord.stores;

import com.discord.gateway.GatewaySocket;
import com.discord.gateway.io.OutgoingPayload$ForumUnreadsRequest;
import com.discord.gateway.io.OutgoingPayload$ForumUnreadsRequestThread;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$requestForumUnreads$1 extends o implements Function1<GatewaySocket, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ List $threadMessagePairs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGatewayConnection$requestForumUnreads$1(long j, long j2, List list) {
        super(1);
        this.$guildId = j;
        this.$channelId = j2;
        this.$threadMessagePairs = list;
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
        long j2 = this.$channelId;
        List<Pair> list = this.$threadMessagePairs;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        for (Pair pair : list) {
            arrayList.add(new OutgoingPayload$ForumUnreadsRequestThread(((Number) pair.component1()).longValue(), ((Number) pair.component2()).longValue()));
        }
        gatewaySocket.requestForumUnreads(new OutgoingPayload$ForumUnreadsRequest(j, j2, arrayList));
    }
}

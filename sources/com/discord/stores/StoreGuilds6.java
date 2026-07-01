package com.discord.stores;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreGuilds$Actions$requestRoleMembers$1, reason: use source file name */
/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds6 extends Lambda implements Function1<List<? extends Long>, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGatewayConnection $storeGatewayConnection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuilds6(StoreGatewayConnection storeGatewayConnection, long j) {
        super(1);
        this.$storeGatewayConnection = storeGatewayConnection;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Long> list) {
        invoke2((List<Long>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Long> list) {
        Intrinsics3.checkNotNullParameter(list, "userIds");
        StoreGatewayConnection.requestGuildMembers$default(this.$storeGatewayConnection, this.$guildId, null, list, null, 10, null);
    }
}

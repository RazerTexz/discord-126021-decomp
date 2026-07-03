package com.discord.stores;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$Actions$requestRoleMembers$1 extends AbstractC12240o implements Function1<List<? extends Long>, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGatewayConnection $storeGatewayConnection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuilds$Actions$requestRoleMembers$1(StoreGatewayConnection storeGatewayConnection, long j) {
        super(1);
        this.$storeGatewayConnection = storeGatewayConnection;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Long> list) {
        invoke2((List<Long>) list);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Long> list) {
        C12238m.checkNotNullParameter(list, "userIds");
        StoreGatewayConnection.requestGuildMembers$default(this.$storeGatewayConnection, this.$guildId, null, list, null, 10, null);
    }
}

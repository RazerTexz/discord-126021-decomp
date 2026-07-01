package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildRoleMemberCounts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1 extends o implements Function1<Map<Long, ? extends Integer>, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildRoleMemberCounts this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts, long j) {
        super(1);
        this.this$0 = storeGuildRoleMemberCounts;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Integer> map) {
        invoke2((Map<Long, Integer>) map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<Long, Integer> map) {
        if (map != null) {
            StoreGuildRoleMemberCounts.access$getDispatcher$p(this.this$0).schedule(new StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1$$special$$inlined$let$lambda$1(map, this));
        }
    }
}

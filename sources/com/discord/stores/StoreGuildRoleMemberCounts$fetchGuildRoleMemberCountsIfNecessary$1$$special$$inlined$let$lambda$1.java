package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildRoleMemberCounts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1$$special$$inlined$let$lambda$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Map $it;
    public final /* synthetic */ StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1$$special$$inlined$let$lambda$1(Map map, StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1 storeGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1) {
        super(0);
        this.$it = map;
        this.this$0 = storeGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildRoleMemberCounts.access$getGuildRoleMemberCounts$p(this.this$0.this$0).put(Long.valueOf(this.this$0.$guildId), this.$it);
        this.this$0.this$0.markChanged();
    }
}

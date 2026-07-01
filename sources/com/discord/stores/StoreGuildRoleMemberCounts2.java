package com.discord.stores;

import com.discord.stores.StoreGuildRoleMemberCounts;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1$$special$$inlined$let$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: StoreGuildRoleMemberCounts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleMemberCounts2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Map $it;
    public final /* synthetic */ StoreGuildRoleMemberCounts.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleMemberCounts2(Map map, StoreGuildRoleMemberCounts.AnonymousClass1 anonymousClass1) {
        super(0);
        this.$it = map;
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildRoleMemberCounts.this.guildRoleMemberCounts.put(Long.valueOf(this.this$0.$guildId), this.$it);
        StoreGuildRoleMemberCounts.this.markChanged();
    }
}

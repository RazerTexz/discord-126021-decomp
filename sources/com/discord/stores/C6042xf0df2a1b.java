package com.discord.stores;

import com.discord.stores.StoreGuildRoleMemberCounts;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1$$special$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: StoreGuildRoleMemberCounts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6042xf0df2a1b extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ Map $it;
    public final /* synthetic */ StoreGuildRoleMemberCounts.C60411 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6042xf0df2a1b(Map map, StoreGuildRoleMemberCounts.C60411 c60411) {
        super(0);
        this.$it = map;
        this.this$0 = c60411;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildRoleMemberCounts.this.guildRoleMemberCounts.put(Long.valueOf(this.this$0.$guildId), this.$it);
        StoreGuildRoleMemberCounts.this.markChanged();
    }
}

package com.discord.stores;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildRoleMemberCounts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildRoleMemberCounts this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$2(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts, long j) {
        super(1);
        this.this$0 = storeGuildRoleMemberCounts;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        StoreGuildRoleMemberCounts.access$getDispatcher$p(this.this$0).schedule(new StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$2$1(this));
    }
}

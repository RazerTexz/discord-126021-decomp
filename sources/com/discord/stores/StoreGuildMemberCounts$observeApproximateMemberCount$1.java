package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildMemberCounts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildMemberCounts$observeApproximateMemberCount$1 extends o implements Function0<Integer> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildMemberCounts this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildMemberCounts$observeApproximateMemberCount$1(StoreGuildMemberCounts storeGuildMemberCounts, long j) {
        super(0);
        this.this$0 = storeGuildMemberCounts;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        Integer num = (Integer) StoreGuildMemberCounts.access$getGuildMemberCountsSnapshot$p(this.this$0).get(Long.valueOf(this.$guildId));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}

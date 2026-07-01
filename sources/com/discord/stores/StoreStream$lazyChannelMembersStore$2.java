package com.discord.stores;

import d0.z.d.k;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$lazyChannelMembersStore$2 extends k implements Function1<Long, Integer> {
    public StoreStream$lazyChannelMembersStore$2(StoreGuildMemberCounts storeGuildMemberCounts) {
        super(1, storeGuildMemberCounts, StoreGuildMemberCounts.class, "getApproximateMemberCount", "getApproximateMemberCount(J)I", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Long l) {
        return Integer.valueOf(invoke(l.longValue()));
    }

    public final int invoke(long j) {
        return ((StoreGuildMemberCounts) this.receiver).getApproximateMemberCount(j);
    }
}

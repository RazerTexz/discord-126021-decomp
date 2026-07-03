package com.discord.stores;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$lazyChannelMembersStore$2 extends C12236k implements Function1<Long, Integer> {
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

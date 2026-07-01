package com.discord.stores;

import d0.z.d.k;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreGuildMemberRequester.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGuildMemberRequester$requestManager$1 extends k implements Function2<Long, Long, Boolean> {
    public StoreGuildMemberRequester$requestManager$1(StoreGuildMemberRequester storeGuildMemberRequester) {
        super(2, storeGuildMemberRequester, StoreGuildMemberRequester.class, "guildMemberExists", "guildMemberExists(JJ)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Long l, Long l2) {
        return Boolean.valueOf(invoke(l.longValue(), l2.longValue()));
    }

    public final boolean invoke(long j, long j2) {
        return StoreGuildMemberRequester.access$guildMemberExists((StoreGuildMemberRequester) this.receiver, j, j2);
    }
}

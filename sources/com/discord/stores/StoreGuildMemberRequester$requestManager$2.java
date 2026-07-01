package com.discord.stores;

import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreGuildMemberRequester.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGuildMemberRequester$requestManager$2 extends k implements Function2<Long, List<? extends Long>, Unit> {
    public StoreGuildMemberRequester$requestManager$2(StoreGuildMemberRequester storeGuildMemberRequester) {
        super(2, storeGuildMemberRequester, StoreGuildMemberRequester.class, "sendRequests", "sendRequests(JLjava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
        invoke(l.longValue(), (List<Long>) list);
        return Unit.a;
    }

    public final void invoke(long j, List<Long> list) {
        m.checkNotNullParameter(list, "p2");
        StoreGuildMemberRequester.access$sendRequests((StoreGuildMemberRequester) this.receiver, j, list);
    }
}

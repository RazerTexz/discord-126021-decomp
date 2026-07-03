package com.discord.stores;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreGuildMemberRequester.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGuildMemberRequester$requestManager$2 extends C12236k implements Function2<Long, List<? extends Long>, Unit> {
    public StoreGuildMemberRequester$requestManager$2(StoreGuildMemberRequester storeGuildMemberRequester) {
        super(2, storeGuildMemberRequester, StoreGuildMemberRequester.class, "sendRequests", "sendRequests(JLjava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
        invoke(l.longValue(), (List<Long>) list);
        return Unit.f27425a;
    }

    public final void invoke(long j, List<Long> list) {
        C12238m.checkNotNullParameter(list, "p2");
        ((StoreGuildMemberRequester) this.receiver).sendRequests(j, list);
    }
}

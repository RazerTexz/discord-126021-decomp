package com.discord.stores;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.stores.StoreGuildMemberRequester$requestManager$2, reason: use source file name */
/* JADX INFO: compiled from: StoreGuildMemberRequester.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGuildMemberRequester3 extends FunctionReferenceImpl implements Function2<Long, List<? extends Long>, Unit> {
    public StoreGuildMemberRequester3(StoreGuildMemberRequester storeGuildMemberRequester) {
        super(2, storeGuildMemberRequester, StoreGuildMemberRequester.class, "sendRequests", "sendRequests(JLjava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
        invoke(l.longValue(), (List<Long>) list);
        return Unit.a;
    }

    public final void invoke(long j, List<Long> list) {
        Intrinsics3.checkNotNullParameter(list, "p2");
        ((StoreGuildMemberRequester) this.receiver).sendRequests(j, list);
    }
}

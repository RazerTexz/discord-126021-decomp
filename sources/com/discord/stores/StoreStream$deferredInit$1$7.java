package com.discord.stores;

import d0.z.d.k;
import d0.z.d.m;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$deferredInit$1$7 extends k implements Function1<Set<? extends Long>, Unit> {
    public StoreStream$deferredInit$1$7(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleSpeakingUsers", "handleSpeakingUsers(Ljava/util/Set;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
        invoke2((Set<Long>) set);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Set<Long> set) {
        m.checkNotNullParameter(set, "p1");
        StoreStream.access$handleSpeakingUsers((StoreStream) this.receiver, set);
    }
}

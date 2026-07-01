package com.discord.stores;

import com.discord.api.thread.ThreadMemberUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$25 extends k implements Function1<ThreadMemberUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$25(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleThreadMemberUpdate", "handleThreadMemberUpdate(Lcom/discord/api/thread/ThreadMemberUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ThreadMemberUpdate threadMemberUpdate) {
        invoke2(threadMemberUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ThreadMemberUpdate threadMemberUpdate) {
        m.checkNotNullParameter(threadMemberUpdate, "p1");
        StoreStream.access$handleThreadMemberUpdate((StoreStream) this.receiver, threadMemberUpdate);
    }
}

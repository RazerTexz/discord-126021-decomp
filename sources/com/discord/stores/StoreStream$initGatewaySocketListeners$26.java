package com.discord.stores;

import com.discord.api.thread.ThreadMembersUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$26 extends k implements Function1<ThreadMembersUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$26(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleThreadMembersUpdate", "handleThreadMembersUpdate(Lcom/discord/api/thread/ThreadMembersUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ThreadMembersUpdate threadMembersUpdate) {
        invoke2(threadMembersUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ThreadMembersUpdate threadMembersUpdate) {
        m.checkNotNullParameter(threadMembersUpdate, "p1");
        StoreStream.access$handleThreadMembersUpdate((StoreStream) this.receiver, threadMembersUpdate);
    }
}

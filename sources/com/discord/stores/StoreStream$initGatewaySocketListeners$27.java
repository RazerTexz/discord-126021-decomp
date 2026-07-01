package com.discord.stores;

import com.discord.api.thread.ThreadMemberListUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$27 extends k implements Function1<ThreadMemberListUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$27(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleThreadMemberListUpdate", "handleThreadMemberListUpdate(Lcom/discord/api/thread/ThreadMemberListUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ThreadMemberListUpdate threadMemberListUpdate) {
        invoke2(threadMemberListUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ThreadMemberListUpdate threadMemberListUpdate) {
        m.checkNotNullParameter(threadMemberListUpdate, "p1");
        StoreStream.access$handleThreadMemberListUpdate((StoreStream) this.receiver, threadMemberListUpdate);
    }
}

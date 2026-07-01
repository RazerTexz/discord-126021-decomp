package com.discord.stores;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$deferredInit$1$4 extends k implements Function1<StoreMessagesLoader$ChannelChunk, Unit> {
    public StoreStream$deferredInit$1$4(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleMessagesLoaded", "handleMessagesLoaded(Lcom/discord/stores/StoreMessagesLoader$ChannelChunk;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreMessagesLoader$ChannelChunk storeMessagesLoader$ChannelChunk) {
        invoke2(storeMessagesLoader$ChannelChunk);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreMessagesLoader$ChannelChunk storeMessagesLoader$ChannelChunk) {
        m.checkNotNullParameter(storeMessagesLoader$ChannelChunk, "p1");
        StoreStream.access$handleMessagesLoaded((StoreStream) this.receiver, storeMessagesLoader$ChannelChunk);
    }
}

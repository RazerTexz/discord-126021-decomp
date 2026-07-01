package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$jumpToMessage$1$1 extends o implements Function1<StoreMessagesLoader$ChannelLoadedState, StoreMessagesLoader$ChannelLoadedState> {
    public static final StoreMessagesLoader$jumpToMessage$1$1 INSTANCE = new StoreMessagesLoader$jumpToMessage$1$1();

    public StoreMessagesLoader$jumpToMessage$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreMessagesLoader$ChannelLoadedState invoke(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState) {
        return invoke2(storeMessagesLoader$ChannelLoadedState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreMessagesLoader$ChannelLoadedState invoke2(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState) {
        m.checkNotNullParameter(storeMessagesLoader$ChannelLoadedState, "it");
        return StoreMessagesLoader$ChannelLoadedState.copy$default(storeMessagesLoader$ChannelLoadedState, false, false, false, false, null, 29, null);
    }
}

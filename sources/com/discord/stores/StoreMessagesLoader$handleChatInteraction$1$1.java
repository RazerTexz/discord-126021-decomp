package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$handleChatInteraction$1$1 extends o implements Function1<StoreMessagesLoader$ChannelLoadedState, StoreMessagesLoader$ChannelLoadedState> {
    public final /* synthetic */ StoreChat$InteractionState $this_apply;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$handleChatInteraction$1$1(StoreChat$InteractionState storeChat$InteractionState) {
        super(1);
        this.$this_apply = storeChat$InteractionState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreMessagesLoader$ChannelLoadedState invoke(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState) {
        return invoke2(storeMessagesLoader$ChannelLoadedState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreMessagesLoader$ChannelLoadedState invoke2(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState) {
        m.checkNotNullParameter(storeMessagesLoader$ChannelLoadedState, "it");
        return StoreMessagesLoader$ChannelLoadedState.copy$default(storeMessagesLoader$ChannelLoadedState, false, false, false, this.$this_apply.isTouchedSinceLastJump(), null, 23, null);
    }
}

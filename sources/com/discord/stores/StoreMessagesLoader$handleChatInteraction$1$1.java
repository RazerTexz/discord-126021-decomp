package com.discord.stores;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$handleChatInteraction$1$1 extends AbstractC12240o implements Function1<StoreMessagesLoader.ChannelLoadedState, StoreMessagesLoader.ChannelLoadedState> {
    public final /* synthetic */ StoreChat.InteractionState $this_apply;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$handleChatInteraction$1$1(StoreChat.InteractionState interactionState) {
        super(1);
        this.$this_apply = interactionState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final StoreMessagesLoader.ChannelLoadedState invoke(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        C12238m.checkNotNullParameter(channelLoadedState, "it");
        return StoreMessagesLoader.ChannelLoadedState.copy$default(channelLoadedState, false, false, false, this.$this_apply.isTouchedSinceLastJump(), null, 23, null);
    }
}

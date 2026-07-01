package com.discord.stores;

import com.discord.stores.StoreChat;
import com.discord.stores.StoreMessagesLoader;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$handleChatInteraction$1$1, reason: use source file name */
/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader2 extends Lambda implements Function1<StoreMessagesLoader.ChannelLoadedState, StoreMessagesLoader.ChannelLoadedState> {
    public final /* synthetic */ StoreChat.InteractionState $this_apply;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader2(StoreChat.InteractionState interactionState) {
        super(1);
        this.$this_apply = interactionState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final StoreMessagesLoader.ChannelLoadedState invoke(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
        return StoreMessagesLoader.ChannelLoadedState.copy$default(channelLoadedState, false, false, false, this.$this_apply.isTouchedSinceLastJump(), null, 23, null);
    }
}

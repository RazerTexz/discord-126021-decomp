package com.discord.stores;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$tryLoadMessages$5$1 extends AbstractC12240o implements Function1<StoreMessagesLoader.ChannelLoadedState, StoreMessagesLoader.ChannelLoadedState> {
    public static final StoreMessagesLoader$tryLoadMessages$5$1 INSTANCE = new StoreMessagesLoader$tryLoadMessages$5$1();

    public StoreMessagesLoader$tryLoadMessages$5$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final StoreMessagesLoader.ChannelLoadedState invoke(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        C12238m.checkNotNullParameter(channelLoadedState, "it");
        return StoreMessagesLoader.ChannelLoadedState.copy$default(channelLoadedState, false, false, true, false, null, 27, null);
    }
}

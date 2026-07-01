package com.discord.stores;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreMessagesLoader$init$1 extends k implements Function1<StoreChat$InteractionState, Unit> {
    public StoreMessagesLoader$init$1(StoreMessagesLoader storeMessagesLoader) {
        super(1, storeMessagesLoader, StoreMessagesLoader.class, "handleChatInteraction", "handleChatInteraction(Lcom/discord/stores/StoreChat$InteractionState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreChat$InteractionState storeChat$InteractionState) {
        invoke2(storeChat$InteractionState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreChat$InteractionState storeChat$InteractionState) {
        m.checkNotNullParameter(storeChat$InteractionState, "p1");
        StoreMessagesLoader.access$handleChatInteraction((StoreMessagesLoader) this.receiver, storeChat$InteractionState);
    }
}

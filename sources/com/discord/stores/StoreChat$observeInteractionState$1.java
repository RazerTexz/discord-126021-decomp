package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChat$observeInteractionState$1 extends o implements Function0<StoreChat$InteractionState> {
    public final /* synthetic */ StoreChat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChat$observeInteractionState$1(StoreChat storeChat) {
        super(0);
        this.this$0 = storeChat;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreChat$InteractionState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreChat$InteractionState invoke() {
        return this.this$0.getInteractionState();
    }
}

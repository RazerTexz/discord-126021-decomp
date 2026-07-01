package com.discord.stores;

import d0.t.o0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessageState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageState$revealSpoiler$1$1 extends o implements Function1<StoreMessageState$State, StoreMessageState$State> {
    public final /* synthetic */ StoreMessageState$revealSpoiler$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageState$revealSpoiler$1$1(StoreMessageState$revealSpoiler$1 storeMessageState$revealSpoiler$1) {
        super(1);
        this.this$0 = storeMessageState$revealSpoiler$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreMessageState$State invoke(StoreMessageState$State storeMessageState$State) {
        return invoke2(storeMessageState$State);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreMessageState$State invoke2(StoreMessageState$State storeMessageState$State) {
        m.checkNotNullParameter(storeMessageState$State, "currentState");
        return StoreMessageState$State.copy$default(storeMessageState$State, o0.plus(storeMessageState$State.getVisibleSpoilerNodeIndices(), Integer.valueOf(this.this$0.$spoilerIndex)), null, 2, null);
    }
}

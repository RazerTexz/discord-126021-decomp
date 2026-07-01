package com.discord.stores;

import d0.t.h0;
import d0.t.n0;
import d0.t.o0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessageState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageState$revealSpoilerEmbedData$1$1 extends o implements Function1<StoreMessageState$State, StoreMessageState$State> {
    public final /* synthetic */ StoreMessageState$revealSpoilerEmbedData$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageState$revealSpoilerEmbedData$1$1(StoreMessageState$revealSpoilerEmbedData$1 storeMessageState$revealSpoilerEmbedData$1) {
        super(1);
        this.this$0 = storeMessageState$revealSpoilerEmbedData$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreMessageState$State invoke(StoreMessageState$State storeMessageState$State) {
        return invoke2(storeMessageState$State);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreMessageState$State invoke2(StoreMessageState$State storeMessageState$State) {
        m.checkNotNullParameter(storeMessageState$State, "currentState");
        Set<String> setEmptySet = storeMessageState$State.getVisibleSpoilerEmbedMap().get(Integer.valueOf(this.this$0.$spoilerEmbedIndex));
        if (setEmptySet == null) {
            setEmptySet = n0.emptySet();
        }
        return StoreMessageState$State.copy$default(storeMessageState$State, null, h0.plus(storeMessageState$State.getVisibleSpoilerEmbedMap(), d0.o.to(Integer.valueOf(this.this$0.$spoilerEmbedIndex), o0.plus(setEmptySet, this.this$0.$key))), 1, null);
    }
}

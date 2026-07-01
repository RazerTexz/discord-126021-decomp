package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessageState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageState$revealSpoiler$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ int $spoilerIndex;
    public final /* synthetic */ StoreMessageState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageState$revealSpoiler$1(StoreMessageState storeMessageState, long j, int i) {
        super(0);
        this.this$0 = storeMessageState;
        this.$messageId = j;
        this.$spoilerIndex = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMessageState.access$updateState(this.this$0, this.$messageId, new StoreMessageState$revealSpoiler$1$1(this));
    }
}

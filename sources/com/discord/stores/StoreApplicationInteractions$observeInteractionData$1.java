package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$observeInteractionData$1 extends o implements Function0<StoreApplicationInteractions$State> {
    public final /* synthetic */ long $interactionId;
    public final /* synthetic */ StoreApplicationInteractions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions$observeInteractionData$1(StoreApplicationInteractions storeApplicationInteractions, long j) {
        super(0);
        this.this$0 = storeApplicationInteractions;
        this.$interactionId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreApplicationInteractions$State invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreApplicationInteractions$State invoke() {
        return this.this$0.getInteractionData(this.$interactionId);
    }
}

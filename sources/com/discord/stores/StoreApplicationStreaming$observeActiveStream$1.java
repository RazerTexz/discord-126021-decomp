package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationStreaming.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreaming$observeActiveStream$1 extends o implements Function0<StoreApplicationStreaming$ActiveApplicationStream> {
    public final /* synthetic */ StoreApplicationStreaming this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationStreaming$observeActiveStream$1(StoreApplicationStreaming storeApplicationStreaming) {
        super(0);
        this.this$0 = storeApplicationStreaming;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreApplicationStreaming$ActiveApplicationStream invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreApplicationStreaming$ActiveApplicationStream invoke() {
        return StoreApplicationStreaming.access$getActiveApplicationStream$p(this.this$0);
    }
}

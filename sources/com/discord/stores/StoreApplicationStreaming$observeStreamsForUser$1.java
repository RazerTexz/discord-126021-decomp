package com.discord.stores;

import com.discord.models.domain.ModelApplicationStream;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationStreaming.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreaming$observeStreamsForUser$1 extends o implements Function0<ModelApplicationStream> {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StoreApplicationStreaming this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationStreaming$observeStreamsForUser$1(StoreApplicationStreaming storeApplicationStreaming, long j) {
        super(0);
        this.this$0 = storeApplicationStreaming;
        this.$userId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ModelApplicationStream invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ModelApplicationStream invoke() {
        return (ModelApplicationStream) StoreApplicationStreaming.access$getStreamsByUserSnapshot$p(this.this$0).get(Long.valueOf(this.$userId));
    }
}

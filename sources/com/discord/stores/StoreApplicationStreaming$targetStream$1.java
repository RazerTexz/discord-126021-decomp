package com.discord.stores;

import com.discord.models.domain.ModelApplicationStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationStreaming.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreaming$targetStream$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $force;
    public final /* synthetic */ String $streamKey;
    public final /* synthetic */ StoreApplicationStreaming this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationStreaming$targetStream$1(StoreApplicationStreaming storeApplicationStreaming, String str, boolean z2) {
        super(0);
        this.this$0 = storeApplicationStreaming;
        this.$streamKey = str;
        this.$force = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationStreaming$ActiveApplicationStream$State state;
        ModelApplicationStream stream;
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p = StoreApplicationStreaming.access$getActiveApplicationStream$p(this.this$0);
        boolean z2 = m.areEqual((storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p == null || (stream = storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p.getStream()) == null) ? null : stream.getEncodedStreamKey(), this.$streamKey) && storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p.getState().isStreamActive();
        if (this.$force || !z2) {
            if (storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p != null && (state = storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p.getState()) != null && state.isStreamActive()) {
                StoreApplicationStreaming.access$stopStreamInternal(this.this$0, storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p.getStream().getEncodedStreamKey());
            }
            StoreApplicationStreaming.access$getStoreStream$p(this.this$0).handleStreamTargeted(this.$streamKey);
        }
    }
}

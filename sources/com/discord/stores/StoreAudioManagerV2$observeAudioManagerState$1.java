package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAudioManagerV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAudioManagerV2$observeAudioManagerState$1 extends o implements Function0<StoreAudioManagerV2$State> {
    public final /* synthetic */ StoreAudioManagerV2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAudioManagerV2$observeAudioManagerState$1(StoreAudioManagerV2 storeAudioManagerV2) {
        super(0);
        this.this$0 = storeAudioManagerV2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreAudioManagerV2$State invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreAudioManagerV2$State invoke() {
        return StoreAudioManagerV2.access$getAudioManagerState(this.this$0);
    }
}

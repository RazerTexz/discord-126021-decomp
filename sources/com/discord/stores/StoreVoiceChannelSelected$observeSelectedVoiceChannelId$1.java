package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreVoiceChannelSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceChannelSelected$observeSelectedVoiceChannelId$1 extends o implements Function0<Long> {
    public final /* synthetic */ StoreVoiceChannelSelected this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreVoiceChannelSelected$observeSelectedVoiceChannelId$1(StoreVoiceChannelSelected storeVoiceChannelSelected) {
        super(0);
        this.this$0 = storeVoiceChannelSelected;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return StoreVoiceChannelSelected.access$getSelectedVoiceChannelId$p(this.this$0);
    }
}

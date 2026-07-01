package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreVoiceChannelSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreVoiceChannelSelected$clear$1 extends k implements Function0<Unit> {
    public StoreVoiceChannelSelected$clear$1(StoreVoiceChannelSelected storeVoiceChannelSelected) {
        super(0, storeVoiceChannelSelected, StoreVoiceChannelSelected.class, "clearInternal", "clearInternal()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreVoiceChannelSelected.access$clearInternal((StoreVoiceChannelSelected) this.receiver);
    }
}

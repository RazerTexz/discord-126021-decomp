package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStreamRtcConnection$observeStreamVolume$1 extends o implements Function0<Float> {
    public final /* synthetic */ StoreStreamRtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStreamRtcConnection$observeStreamVolume$1(StoreStreamRtcConnection storeStreamRtcConnection) {
        super(0);
        this.this$0 = storeStreamRtcConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Float invoke() {
        return Float.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final float invoke2() {
        return this.this$0.getStreamVolume();
    }
}

package com.discord.stores;

import com.discord.rtcconnection.RtcConnection$Quality;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStreamRtcConnection$observeConnectionQuality$1 extends o implements Function0<RtcConnection$Quality> {
    public final /* synthetic */ StoreStreamRtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStreamRtcConnection$observeConnectionQuality$1(StoreStreamRtcConnection storeStreamRtcConnection) {
        super(0);
        this.this$0 = storeStreamRtcConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ RtcConnection$Quality invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RtcConnection$Quality invoke() {
        return this.this$0.getState().getConnectionQuality();
    }
}

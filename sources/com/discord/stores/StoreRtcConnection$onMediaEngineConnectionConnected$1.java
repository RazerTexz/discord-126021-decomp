package com.discord.stores;

import com.discord.rtcconnection.RtcConnection;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcConnection$onMediaEngineConnectionConnected$1 extends o implements Function0<Unit> {
    public final /* synthetic */ RtcConnection $connection;
    public final /* synthetic */ StoreRtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRtcConnection$onMediaEngineConnectionConnected$1(StoreRtcConnection storeRtcConnection, RtcConnection rtcConnection) {
        super(0);
        this.this$0 = storeRtcConnection;
        this.$connection = rtcConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreRtcConnection.applyVoiceConfiguration$default(this.this$0, this.$connection, null, 2, null);
    }
}

package com.discord.stores;

import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStreamRtcConnection;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStreamRtcConnection$RtcConnectionListener$onQualityUpdate$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RtcConnection.Quality $quality;
    public final /* synthetic */ StoreStreamRtcConnection.RtcConnectionListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStreamRtcConnection$RtcConnectionListener$onQualityUpdate$1(StoreStreamRtcConnection.RtcConnectionListener rtcConnectionListener, RtcConnection.Quality quality) {
        super(0);
        this.this$0 = rtcConnectionListener;
        this.$quality = quality;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStreamRtcConnection.this.handleQualityUpdate(this.$quality);
    }
}

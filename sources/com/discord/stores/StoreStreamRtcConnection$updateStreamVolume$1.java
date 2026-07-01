package com.discord.stores;

import com.discord.rtcconnection.RtcConnection;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStreamRtcConnection$updateStreamVolume$1 extends o implements Function0<Unit> {
    public final /* synthetic */ float $volume;
    public final /* synthetic */ StoreStreamRtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStreamRtcConnection$updateStreamVolume$1(StoreStreamRtcConnection storeStreamRtcConnection, float f) {
        super(0);
        this.this$0 = storeStreamRtcConnection;
        this.$volume = f;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStreamRtcConnection.access$setStreamVolume$p(this.this$0, this.$volume);
        Long lAccess$getStreamOwner$p = StoreStreamRtcConnection.access$getStreamOwner$p(this.this$0);
        if (lAccess$getStreamOwner$p != null) {
            long jLongValue = lAccess$getStreamOwner$p.longValue();
            RtcConnection rtcConnectionAccess$getRtcConnection$p = StoreStreamRtcConnection.access$getRtcConnection$p(this.this$0);
            if (rtcConnectionAccess$getRtcConnection$p != null) {
                rtcConnectionAccess$getRtcConnection$p.v(jLongValue, this.$volume);
            }
        }
        this.this$0.markChanged();
    }
}

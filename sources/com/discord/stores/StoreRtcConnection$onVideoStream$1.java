package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcConnection$onVideoStream$1 extends o implements Function0<Unit> {
    public final /* synthetic */ int $audioSsrc;
    public final /* synthetic */ int $rtxSsrc;
    public final /* synthetic */ Integer $streamId;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ int $videoSsrc;
    public final /* synthetic */ StoreRtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRtcConnection$onVideoStream$1(StoreRtcConnection storeRtcConnection, long j, Integer num, int i, int i2, int i3) {
        super(0);
        this.this$0 = storeRtcConnection;
        this.$userId = j;
        this.$streamId = num;
        this.$audioSsrc = i;
        this.$videoSsrc = i2;
        this.$rtxSsrc = i3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreRtcConnection.access$getStream$p(this.this$0).handleVideoStreamUpdate(this.$userId, this.$streamId, this.$audioSsrc, this.$videoSsrc, this.$rtxSsrc);
    }
}

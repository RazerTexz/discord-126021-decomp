package com.discord.stores;

import com.discord.rtcconnection.VideoMetadata;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcConnection$onVideoMetadata$1 extends o implements Function0<Unit> {
    public final /* synthetic */ VideoMetadata $metadata;
    public final /* synthetic */ StoreRtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRtcConnection$onVideoMetadata$1(StoreRtcConnection storeRtcConnection, VideoMetadata videoMetadata) {
        super(0);
        this.this$0 = storeRtcConnection;
        this.$metadata = videoMetadata;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreRtcConnection.access$getStream$p(this.this$0).handleVideoMetadataUpdate(this.$metadata);
    }
}

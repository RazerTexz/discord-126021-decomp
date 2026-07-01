package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStreamRtcConnection$RtcConnectionListener$onAnalyticsEvent$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Map $properties;
    public final /* synthetic */ StoreStreamRtcConnection$RtcConnectionListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStreamRtcConnection$RtcConnectionListener$onAnalyticsEvent$1(StoreStreamRtcConnection$RtcConnectionListener storeStreamRtcConnection$RtcConnectionListener, Map map) {
        super(0);
        this.this$0 = storeStreamRtcConnection$RtcConnectionListener;
        this.$properties = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStreamRtcConnection.access$handleVideoStreamEndedAnalyticsEvent(this.this$0.this$0, this.$properties);
    }
}

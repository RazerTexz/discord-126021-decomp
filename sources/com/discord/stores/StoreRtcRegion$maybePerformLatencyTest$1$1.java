package com.discord.stores;

import com.discord.app.AppLog;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreRtcRegion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcRegion$maybePerformLatencyTest$1$1 extends o implements Function1<List<? extends String>, Unit> {
    public final /* synthetic */ List $newGeoRankedRegions;
    public final /* synthetic */ long $timeNowMs;
    public final /* synthetic */ StoreRtcRegion$maybePerformLatencyTest$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRtcRegion$maybePerformLatencyTest$1$1(StoreRtcRegion$maybePerformLatencyTest$1 storeRtcRegion$maybePerformLatencyTest$1, List list, long j) {
        super(1);
        this.this$0 = storeRtcRegion$maybePerformLatencyTest$1;
        this.$newGeoRankedRegions = list;
        this.$timeNowMs = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
        invoke2((List<String>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<String> list) {
        m.checkNotNullParameter(list, "latencyRankedRegions");
        AppLog.i("RTC region latency test ranking is " + list);
        StoreRtcRegion.access$updateLastTestResult(this.this$0.this$0, new RtcLatencyTestResult(list, this.$newGeoRankedRegions, this.$timeNowMs));
    }
}

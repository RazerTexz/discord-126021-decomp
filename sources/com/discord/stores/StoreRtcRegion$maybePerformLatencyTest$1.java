package com.discord.stores;

import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelRtcLatencyRegion;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreRtcRegion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcRegion$maybePerformLatencyTest$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $regionsWithIps;
    public final /* synthetic */ StoreRtcRegion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRtcRegion$maybePerformLatencyTest$1(StoreRtcRegion storeRtcRegion, List list) {
        super(0);
        this.this$0 = storeRtcRegion;
        this.$regionsWithIps = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List list = this.$regionsWithIps;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ModelRtcLatencyRegion) it.next()).getRegion());
        }
        long jCurrentTimeMillis = StoreRtcRegion.access$getClock$p(this.this$0).currentTimeMillis();
        if (StoreRtcRegion.access$shouldPerformLatencyTest(this.this$0, arrayList, jCurrentTimeMillis)) {
            StoreRtcRegion.access$getStoreMediaEngine$p(this.this$0).getRankedRtcRegions(this.$regionsWithIps, new StoreRtcRegion$maybePerformLatencyTest$1$1(this, arrayList, jCurrentTimeMillis));
            return;
        }
        StringBuilder sbU = a.U("RTC region latency test cached preferred region is ");
        sbU.append(this.this$0.getPreferredRegion());
        AppLog.i(sbU.toString());
    }
}

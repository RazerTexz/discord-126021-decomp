package com.discord.stores;

import com.discord.models.domain.ModelRtcLatencyRegion;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreRtcRegion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcRegion$fetchRtcLatencyTestRegionsIps$1 extends o implements Function1<List<? extends ModelRtcLatencyRegion>, Unit> {
    public final /* synthetic */ StoreRtcRegion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRtcRegion$fetchRtcLatencyTestRegionsIps$1(StoreRtcRegion storeRtcRegion) {
        super(1);
        this.this$0 = storeRtcRegion;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelRtcLatencyRegion> list) {
        invoke2((List<ModelRtcLatencyRegion>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ModelRtcLatencyRegion> list) {
        m.checkNotNullParameter(list, "it");
        StoreRtcRegion.access$maybePerformLatencyTest(this.this$0, list);
    }
}

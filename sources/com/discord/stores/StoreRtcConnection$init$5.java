package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcConnection$init$5 extends o implements Function1<Map<Long, ? extends Float>, Unit> {
    public final /* synthetic */ StoreRtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRtcConnection$init$5(StoreRtcConnection storeRtcConnection) {
        super(1);
        this.this$0 = storeRtcConnection;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Float> map) {
        invoke2((Map<Long, Float>) map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<Long, Float> map) {
        m.checkNotNullParameter(map, "usersVolume");
        StoreRtcConnection.access$getDispatcher$p(this.this$0).schedule(new StoreRtcConnection$init$5$1(this, map));
    }
}

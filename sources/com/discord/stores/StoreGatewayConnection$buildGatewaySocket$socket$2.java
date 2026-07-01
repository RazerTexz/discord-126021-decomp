package com.discord.stores;

import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$buildGatewaySocket$socket$2 extends o implements Function1<Map<String, ? extends Object>, Unit> {
    public static final StoreGatewayConnection$buildGatewaySocket$socket$2 INSTANCE = new StoreGatewayConnection$buildGatewaySocket$socket$2();

    public StoreGatewayConnection$buildGatewaySocket$socket$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Object> map) {
        invoke2(map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, ? extends Object> map) {
        m.checkNotNullParameter(map, "properties");
        AnalyticsTracker.readyPayloadReceived(map);
    }
}

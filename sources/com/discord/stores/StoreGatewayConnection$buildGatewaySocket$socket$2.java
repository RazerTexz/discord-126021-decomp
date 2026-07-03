package com.discord.stores;

import com.discord.utilities.analytics.AnalyticsTracker;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$buildGatewaySocket$socket$2 extends AbstractC12240o implements Function1<Map<String, ? extends Object>, Unit> {
    public static final StoreGatewayConnection$buildGatewaySocket$socket$2 INSTANCE = new StoreGatewayConnection$buildGatewaySocket$socket$2();

    public StoreGatewayConnection$buildGatewaySocket$socket$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Object> map) {
        invoke2(map);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, ? extends Object> map) {
        C12238m.checkNotNullParameter(map, "properties");
        AnalyticsTracker.readyPayloadReceived(map);
    }
}

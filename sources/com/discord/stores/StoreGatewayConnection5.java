package com.discord.stores;

import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$buildGatewaySocket$socket$2, reason: use source file name */
/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection5 extends Lambda implements Function1<Map<String, ? extends Object>, Unit> {
    public static final StoreGatewayConnection5 INSTANCE = new StoreGatewayConnection5();

    public StoreGatewayConnection5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Object> map) {
        invoke2(map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, ? extends Object> map) {
        Intrinsics3.checkNotNullParameter(map, "properties");
        AnalyticsTracker.readyPayloadReceived(map);
    }
}

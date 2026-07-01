package com.discord.widgets.status;

import com.discord.stores.StoreConnectivity$DelayedState;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1 extends k implements Function1<StoreConnectivity$DelayedState, WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState> {
    public static final WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1 INSTANCE = new WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1();

    public WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1() {
        super(1, WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState.class, "<init>", "<init>(Lcom/discord/stores/StoreConnectivity$DelayedState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState invoke(StoreConnectivity$DelayedState storeConnectivity$DelayedState) {
        return invoke2(storeConnectivity$DelayedState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState invoke2(StoreConnectivity$DelayedState storeConnectivity$DelayedState) {
        m.checkNotNullParameter(storeConnectivity$DelayedState, "p1");
        return new WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState(storeConnectivity$DelayedState);
    }
}

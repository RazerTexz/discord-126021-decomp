package com.discord.widgets.status;

import b.d.b.a.a;
import com.discord.stores.StoreConnectivity$DelayedState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState extends WidgetGlobalStatusIndicatorViewModel$StoreState {
    private final StoreConnectivity$DelayedState connectivityState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState(StoreConnectivity$DelayedState storeConnectivity$DelayedState) {
        super(null);
        m.checkNotNullParameter(storeConnectivity$DelayedState, "connectivityState");
        this.connectivityState = storeConnectivity$DelayedState;
    }

    public static /* synthetic */ WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState copy$default(WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState widgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState, StoreConnectivity$DelayedState storeConnectivity$DelayedState, int i, Object obj) {
        if ((i & 1) != 0) {
            storeConnectivity$DelayedState = widgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState.connectivityState;
        }
        return widgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState.copy(storeConnectivity$DelayedState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreConnectivity$DelayedState getConnectivityState() {
        return this.connectivityState;
    }

    public final WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState copy(StoreConnectivity$DelayedState connectivityState) {
        m.checkNotNullParameter(connectivityState, "connectivityState");
        return new WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState(connectivityState);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState) && m.areEqual(this.connectivityState, ((WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState) other).connectivityState);
        }
        return true;
    }

    public final StoreConnectivity$DelayedState getConnectivityState() {
        return this.connectivityState;
    }

    public int hashCode() {
        StoreConnectivity$DelayedState storeConnectivity$DelayedState = this.connectivityState;
        if (storeConnectivity$DelayedState != null) {
            return storeConnectivity$DelayedState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ConnectivityState(connectivityState=");
        sbU.append(this.connectivityState);
        sbU.append(")");
        return sbU.toString();
    }
}

package com.discord.widgets.status;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadStatusViewModel$ViewState {
    private final boolean isLoading;
    private final WidgetThreadStatusViewModel$Status threadStatus;

    public WidgetThreadStatusViewModel$ViewState(WidgetThreadStatusViewModel$Status widgetThreadStatusViewModel$Status, boolean z2) {
        m.checkNotNullParameter(widgetThreadStatusViewModel$Status, "threadStatus");
        this.threadStatus = widgetThreadStatusViewModel$Status;
        this.isLoading = z2;
    }

    public static /* synthetic */ WidgetThreadStatusViewModel$ViewState copy$default(WidgetThreadStatusViewModel$ViewState widgetThreadStatusViewModel$ViewState, WidgetThreadStatusViewModel$Status widgetThreadStatusViewModel$Status, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetThreadStatusViewModel$Status = widgetThreadStatusViewModel$ViewState.threadStatus;
        }
        if ((i & 2) != 0) {
            z2 = widgetThreadStatusViewModel$ViewState.isLoading;
        }
        return widgetThreadStatusViewModel$ViewState.copy(widgetThreadStatusViewModel$Status, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetThreadStatusViewModel$Status getThreadStatus() {
        return this.threadStatus;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public final WidgetThreadStatusViewModel$ViewState copy(WidgetThreadStatusViewModel$Status threadStatus, boolean isLoading) {
        m.checkNotNullParameter(threadStatus, "threadStatus");
        return new WidgetThreadStatusViewModel$ViewState(threadStatus, isLoading);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadStatusViewModel$ViewState)) {
            return false;
        }
        WidgetThreadStatusViewModel$ViewState widgetThreadStatusViewModel$ViewState = (WidgetThreadStatusViewModel$ViewState) other;
        return m.areEqual(this.threadStatus, widgetThreadStatusViewModel$ViewState.threadStatus) && this.isLoading == widgetThreadStatusViewModel$ViewState.isLoading;
    }

    public final WidgetThreadStatusViewModel$Status getThreadStatus() {
        return this.threadStatus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        WidgetThreadStatusViewModel$Status widgetThreadStatusViewModel$Status = this.threadStatus;
        int iHashCode = (widgetThreadStatusViewModel$Status != null ? widgetThreadStatusViewModel$Status.hashCode() : 0) * 31;
        boolean z2 = this.isLoading;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(threadStatus=");
        sbU.append(this.threadStatus);
        sbU.append(", isLoading=");
        return a.O(sbU, this.isLoading, ")");
    }

    public /* synthetic */ WidgetThreadStatusViewModel$ViewState(WidgetThreadStatusViewModel$Status widgetThreadStatusViewModel$Status, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetThreadStatusViewModel$Status, (i & 2) != 0 ? false : z2);
    }
}

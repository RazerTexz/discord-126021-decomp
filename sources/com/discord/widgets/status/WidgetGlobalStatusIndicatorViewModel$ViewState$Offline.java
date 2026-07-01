package com.discord.widgets.status;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGlobalStatusIndicatorViewModel$ViewState$Offline extends WidgetGlobalStatusIndicatorViewModel$ViewState {
    private final boolean airplaneMode;
    private final long delay;

    public WidgetGlobalStatusIndicatorViewModel$ViewState$Offline(long j, boolean z2) {
        super(null);
        this.delay = j;
        this.airplaneMode = z2;
    }

    public static /* synthetic */ WidgetGlobalStatusIndicatorViewModel$ViewState$Offline copy$default(WidgetGlobalStatusIndicatorViewModel$ViewState$Offline widgetGlobalStatusIndicatorViewModel$ViewState$Offline, long j, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetGlobalStatusIndicatorViewModel$ViewState$Offline.delay;
        }
        if ((i & 2) != 0) {
            z2 = widgetGlobalStatusIndicatorViewModel$ViewState$Offline.airplaneMode;
        }
        return widgetGlobalStatusIndicatorViewModel$ViewState$Offline.copy(j, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDelay() {
        return this.delay;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAirplaneMode() {
        return this.airplaneMode;
    }

    public final WidgetGlobalStatusIndicatorViewModel$ViewState$Offline copy(long delay, boolean airplaneMode) {
        return new WidgetGlobalStatusIndicatorViewModel$ViewState$Offline(delay, airplaneMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$Offline)) {
            return false;
        }
        WidgetGlobalStatusIndicatorViewModel$ViewState$Offline widgetGlobalStatusIndicatorViewModel$ViewState$Offline = (WidgetGlobalStatusIndicatorViewModel$ViewState$Offline) other;
        return this.delay == widgetGlobalStatusIndicatorViewModel$ViewState$Offline.delay && this.airplaneMode == widgetGlobalStatusIndicatorViewModel$ViewState$Offline.airplaneMode;
    }

    public final boolean getAirplaneMode() {
        return this.airplaneMode;
    }

    public final long getDelay() {
        return this.delay;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iA = b.a(this.delay) * 31;
        boolean z2 = this.airplaneMode;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iA + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("Offline(delay=");
        sbU.append(this.delay);
        sbU.append(", airplaneMode=");
        return a.O(sbU, this.airplaneMode, ")");
    }
}

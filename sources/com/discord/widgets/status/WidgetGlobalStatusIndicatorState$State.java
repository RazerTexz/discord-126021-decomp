package com.discord.widgets.status;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGlobalStatusIndicatorState$State {
    private final boolean isCustomBackground;
    private final boolean isViewingCall;
    private final boolean isVisible;

    public WidgetGlobalStatusIndicatorState$State(boolean z2, boolean z3, boolean z4) {
        this.isVisible = z2;
        this.isCustomBackground = z3;
        this.isViewingCall = z4;
    }

    public static /* synthetic */ WidgetGlobalStatusIndicatorState$State copy$default(WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetGlobalStatusIndicatorState$State.isVisible;
        }
        if ((i & 2) != 0) {
            z3 = widgetGlobalStatusIndicatorState$State.isCustomBackground;
        }
        if ((i & 4) != 0) {
            z4 = widgetGlobalStatusIndicatorState$State.isViewingCall;
        }
        return widgetGlobalStatusIndicatorState$State.copy(z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsCustomBackground() {
        return this.isCustomBackground;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsViewingCall() {
        return this.isViewingCall;
    }

    public final WidgetGlobalStatusIndicatorState$State copy(boolean isVisible, boolean isCustomBackground, boolean isViewingCall) {
        return new WidgetGlobalStatusIndicatorState$State(isVisible, isCustomBackground, isViewingCall);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalStatusIndicatorState$State)) {
            return false;
        }
        WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State = (WidgetGlobalStatusIndicatorState$State) other;
        return this.isVisible == widgetGlobalStatusIndicatorState$State.isVisible && this.isCustomBackground == widgetGlobalStatusIndicatorState$State.isCustomBackground && this.isViewingCall == widgetGlobalStatusIndicatorState$State.isViewingCall;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z2 = this.isVisible;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isCustomBackground;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.isViewingCall;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isCustomBackground() {
        return this.isCustomBackground;
    }

    public final boolean isViewingCall() {
        return this.isViewingCall;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public String toString() {
        StringBuilder sbU = a.U("State(isVisible=");
        sbU.append(this.isVisible);
        sbU.append(", isCustomBackground=");
        sbU.append(this.isCustomBackground);
        sbU.append(", isViewingCall=");
        return a.O(sbU, this.isViewingCall, ")");
    }
}

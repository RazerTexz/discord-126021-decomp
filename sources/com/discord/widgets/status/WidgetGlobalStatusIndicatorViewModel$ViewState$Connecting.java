package com.discord.widgets.status;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting extends WidgetGlobalStatusIndicatorViewModel$ViewState {
    private final long delay;

    public WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting(long j) {
        super(null);
        this.delay = j;
    }

    public static /* synthetic */ WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting copy$default(WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting widgetGlobalStatusIndicatorViewModel$ViewState$Connecting, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetGlobalStatusIndicatorViewModel$ViewState$Connecting.delay;
        }
        return widgetGlobalStatusIndicatorViewModel$ViewState$Connecting.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDelay() {
        return this.delay;
    }

    public final WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting copy(long delay) {
        return new WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting(delay);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting) && this.delay == ((WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting) other).delay;
        }
        return true;
    }

    public final long getDelay() {
        return this.delay;
    }

    public int hashCode() {
        return b.a(this.delay);
    }

    public String toString() {
        return a.C(a.U("Connecting(delay="), this.delay, ")");
    }
}

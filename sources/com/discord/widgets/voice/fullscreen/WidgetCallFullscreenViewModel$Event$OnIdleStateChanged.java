package com.discord.widgets.voice.fullscreen;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallFullscreenViewModel$Event$OnIdleStateChanged extends WidgetCallFullscreenViewModel$Event {
    private final boolean isIdle;

    public WidgetCallFullscreenViewModel$Event$OnIdleStateChanged(boolean z2) {
        super(null);
        this.isIdle = z2;
    }

    public static /* synthetic */ WidgetCallFullscreenViewModel$Event$OnIdleStateChanged copy$default(WidgetCallFullscreenViewModel$Event$OnIdleStateChanged widgetCallFullscreenViewModel$Event$OnIdleStateChanged, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetCallFullscreenViewModel$Event$OnIdleStateChanged.isIdle;
        }
        return widgetCallFullscreenViewModel$Event$OnIdleStateChanged.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsIdle() {
        return this.isIdle;
    }

    public final WidgetCallFullscreenViewModel$Event$OnIdleStateChanged copy(boolean isIdle) {
        return new WidgetCallFullscreenViewModel$Event$OnIdleStateChanged(isIdle);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetCallFullscreenViewModel$Event$OnIdleStateChanged) && this.isIdle == ((WidgetCallFullscreenViewModel$Event$OnIdleStateChanged) other).isIdle;
        }
        return true;
    }

    public int hashCode() {
        boolean z2 = this.isIdle;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public final boolean isIdle() {
        return this.isIdle;
    }

    public String toString() {
        return a.O(a.U("OnIdleStateChanged(isIdle="), this.isIdle, ")");
    }
}

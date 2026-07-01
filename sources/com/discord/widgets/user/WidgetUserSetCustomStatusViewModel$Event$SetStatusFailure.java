package com.discord.widgets.user;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure extends WidgetUserSetCustomStatusViewModel$Event {
    private final int failureMessageStringRes;

    public WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure(int i) {
        super(null);
        this.failureMessageStringRes = i;
    }

    public static /* synthetic */ WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure copy$default(WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure widgetUserSetCustomStatusViewModel$Event$SetStatusFailure, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetUserSetCustomStatusViewModel$Event$SetStatusFailure.failureMessageStringRes;
        }
        return widgetUserSetCustomStatusViewModel$Event$SetStatusFailure.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFailureMessageStringRes() {
        return this.failureMessageStringRes;
    }

    public final WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure copy(int failureMessageStringRes) {
        return new WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure(failureMessageStringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure) && this.failureMessageStringRes == ((WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure) other).failureMessageStringRes;
        }
        return true;
    }

    public final int getFailureMessageStringRes() {
        return this.failureMessageStringRes;
    }

    public int hashCode() {
        return this.failureMessageStringRes;
    }

    public String toString() {
        return a.B(a.U("SetStatusFailure(failureMessageStringRes="), this.failureMessageStringRes, ")");
    }
}

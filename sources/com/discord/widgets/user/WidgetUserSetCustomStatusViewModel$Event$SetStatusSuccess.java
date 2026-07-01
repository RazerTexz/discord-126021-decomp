package com.discord.widgets.user;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess extends WidgetUserSetCustomStatusViewModel$Event {
    private final int successMessageStringRes;

    public WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess(int i) {
        super(null);
        this.successMessageStringRes = i;
    }

    public static /* synthetic */ WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess copy$default(WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess widgetUserSetCustomStatusViewModel$Event$SetStatusSuccess, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetUserSetCustomStatusViewModel$Event$SetStatusSuccess.successMessageStringRes;
        }
        return widgetUserSetCustomStatusViewModel$Event$SetStatusSuccess.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSuccessMessageStringRes() {
        return this.successMessageStringRes;
    }

    public final WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess copy(int successMessageStringRes) {
        return new WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess(successMessageStringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess) && this.successMessageStringRes == ((WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess) other).successMessageStringRes;
        }
        return true;
    }

    public final int getSuccessMessageStringRes() {
        return this.successMessageStringRes;
    }

    public int hashCode() {
        return this.successMessageStringRes;
    }

    public String toString() {
        return a.B(a.U("SetStatusSuccess(successMessageStringRes="), this.successMessageStringRes, ")");
    }
}

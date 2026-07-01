package com.discord.widgets.user;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetPruneUsersViewModel$ViewState$LoadFailed extends WidgetPruneUsersViewModel$ViewState {
    private final boolean dismiss;

    public WidgetPruneUsersViewModel$ViewState$LoadFailed(boolean z2) {
        super(null);
        this.dismiss = z2;
    }

    public static /* synthetic */ WidgetPruneUsersViewModel$ViewState$LoadFailed copy$default(WidgetPruneUsersViewModel$ViewState$LoadFailed widgetPruneUsersViewModel$ViewState$LoadFailed, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetPruneUsersViewModel$ViewState$LoadFailed.dismiss;
        }
        return widgetPruneUsersViewModel$ViewState$LoadFailed.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getDismiss() {
        return this.dismiss;
    }

    public final WidgetPruneUsersViewModel$ViewState$LoadFailed copy(boolean dismiss) {
        return new WidgetPruneUsersViewModel$ViewState$LoadFailed(dismiss);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetPruneUsersViewModel$ViewState$LoadFailed) && this.dismiss == ((WidgetPruneUsersViewModel$ViewState$LoadFailed) other).dismiss;
        }
        return true;
    }

    public final boolean getDismiss() {
        return this.dismiss;
    }

    public int hashCode() {
        boolean z2 = this.dismiss;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public String toString() {
        return a.O(a.U("LoadFailed(dismiss="), this.dismiss, ")");
    }
}

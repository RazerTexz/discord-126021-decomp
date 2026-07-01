package com.discord.widgets.settings.account;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsBlockedUsersViewModel$Event$ShowToast extends WidgetSettingsBlockedUsersViewModel$Event {
    private final int stringRes;

    public WidgetSettingsBlockedUsersViewModel$Event$ShowToast(int i) {
        super(null);
        this.stringRes = i;
    }

    public static /* synthetic */ WidgetSettingsBlockedUsersViewModel$Event$ShowToast copy$default(WidgetSettingsBlockedUsersViewModel$Event$ShowToast widgetSettingsBlockedUsersViewModel$Event$ShowToast, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetSettingsBlockedUsersViewModel$Event$ShowToast.stringRes;
        }
        return widgetSettingsBlockedUsersViewModel$Event$ShowToast.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStringRes() {
        return this.stringRes;
    }

    public final WidgetSettingsBlockedUsersViewModel$Event$ShowToast copy(int stringRes) {
        return new WidgetSettingsBlockedUsersViewModel$Event$ShowToast(stringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetSettingsBlockedUsersViewModel$Event$ShowToast) && this.stringRes == ((WidgetSettingsBlockedUsersViewModel$Event$ShowToast) other).stringRes;
        }
        return true;
    }

    public final int getStringRes() {
        return this.stringRes;
    }

    public int hashCode() {
        return this.stringRes;
    }

    public String toString() {
        return a.B(a.U("ShowToast(stringRes="), this.stringRes, ")");
    }
}

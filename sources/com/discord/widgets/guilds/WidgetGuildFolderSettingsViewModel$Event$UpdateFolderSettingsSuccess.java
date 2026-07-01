package com.discord.widgets.guilds;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess extends WidgetGuildFolderSettingsViewModel$Event {
    private final int successMessageStringRes;

    public WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess(int i) {
        super(null);
        this.successMessageStringRes = i;
    }

    public static /* synthetic */ WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess copy$default(WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess widgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess.successMessageStringRes;
        }
        return widgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSuccessMessageStringRes() {
        return this.successMessageStringRes;
    }

    public final WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess copy(int successMessageStringRes) {
        return new WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess(successMessageStringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess) && this.successMessageStringRes == ((WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess) other).successMessageStringRes;
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
        return a.B(a.U("UpdateFolderSettingsSuccess(successMessageStringRes="), this.successMessageStringRes, ")");
    }
}

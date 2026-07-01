package com.discord.widgets.guilds;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure extends WidgetGuildFolderSettingsViewModel$Event {
    private final int failureMessageStringRes;

    public WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure(int i) {
        super(null);
        this.failureMessageStringRes = i;
    }

    public static /* synthetic */ WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure copy$default(WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure widgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure.failureMessageStringRes;
        }
        return widgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFailureMessageStringRes() {
        return this.failureMessageStringRes;
    }

    public final WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure copy(int failureMessageStringRes) {
        return new WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure(failureMessageStringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure) && this.failureMessageStringRes == ((WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure) other).failureMessageStringRes;
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
        return a.B(a.U("UpdateFolderSettingsFailure(failureMessageStringRes="), this.failureMessageStringRes, ")");
    }
}

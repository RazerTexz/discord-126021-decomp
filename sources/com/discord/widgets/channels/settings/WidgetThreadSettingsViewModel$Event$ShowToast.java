package com.discord.widgets.channels.settings;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadSettingsViewModel$Event$ShowToast extends WidgetThreadSettingsViewModel$Event {
    private final int messageStringRes;

    public WidgetThreadSettingsViewModel$Event$ShowToast(@StringRes int i) {
        super(null);
        this.messageStringRes = i;
    }

    public static /* synthetic */ WidgetThreadSettingsViewModel$Event$ShowToast copy$default(WidgetThreadSettingsViewModel$Event$ShowToast widgetThreadSettingsViewModel$Event$ShowToast, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetThreadSettingsViewModel$Event$ShowToast.messageStringRes;
        }
        return widgetThreadSettingsViewModel$Event$ShowToast.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMessageStringRes() {
        return this.messageStringRes;
    }

    public final WidgetThreadSettingsViewModel$Event$ShowToast copy(@StringRes int messageStringRes) {
        return new WidgetThreadSettingsViewModel$Event$ShowToast(messageStringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetThreadSettingsViewModel$Event$ShowToast) && this.messageStringRes == ((WidgetThreadSettingsViewModel$Event$ShowToast) other).messageStringRes;
        }
        return true;
    }

    public final int getMessageStringRes() {
        return this.messageStringRes;
    }

    public int hashCode() {
        return this.messageStringRes;
    }

    public String toString() {
        return a.B(a.U("ShowToast(messageStringRes="), this.messageStringRes, ")");
    }
}

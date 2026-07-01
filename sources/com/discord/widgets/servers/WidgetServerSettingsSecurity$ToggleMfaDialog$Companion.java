package com.discord.widgets.servers;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$ToggleMfaDialog$Companion {
    private WidgetServerSettingsSecurity$ToggleMfaDialog$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long guildId, boolean mfaEnabled) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetServerSettingsSecurity$ToggleMfaDialog widgetServerSettingsSecurity$ToggleMfaDialog = new WidgetServerSettingsSecurity$ToggleMfaDialog();
        Bundle bundle = new Bundle();
        bundle.putLong("ARG_GUILD_ID", guildId);
        bundle.putBoolean("ARG_MFA_ENABLED", mfaEnabled);
        widgetServerSettingsSecurity$ToggleMfaDialog.setArguments(bundle);
        widgetServerSettingsSecurity$ToggleMfaDialog.show(fragmentManager, "TAG_TOGGLE_MFA_DIALOG");
    }

    public /* synthetic */ WidgetServerSettingsSecurity$ToggleMfaDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

package com.discord.widgets.settings;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet$Companion {
    private WidgetMuteSettingsSheet$Companion() {
    }

    public final void showForChannel(long channelId, FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetMuteSettingsSheet widgetMuteSettingsSheet = new WidgetMuteSettingsSheet();
        Bundle bundle = new Bundle();
        bundle.putLong("ARG_CHANNEL_ID", channelId);
        widgetMuteSettingsSheet.setArguments(bundle);
        widgetMuteSettingsSheet.show(fragmentManager, WidgetMuteSettingsSheet.class.getName());
    }

    public final void showForGuild(long guildId, FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetMuteSettingsSheet widgetMuteSettingsSheet = new WidgetMuteSettingsSheet();
        Bundle bundle = new Bundle();
        bundle.putLong("ARG_GUILD_ID", guildId);
        widgetMuteSettingsSheet.setArguments(bundle);
        widgetMuteSettingsSheet.show(fragmentManager, WidgetMuteSettingsSheet.class.getName());
    }

    public /* synthetic */ WidgetMuteSettingsSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

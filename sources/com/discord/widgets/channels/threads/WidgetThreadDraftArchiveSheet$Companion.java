package com.discord.widgets.channels.threads;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadDraftArchiveSheet$Companion {
    private WidgetThreadDraftArchiveSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long guildId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet = new WidgetThreadDraftArchiveSheet();
        Bundle bundle = new Bundle();
        bundle.putLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        widgetThreadDraftArchiveSheet.setArguments(bundle);
        widgetThreadDraftArchiveSheet.show(fragmentManager, WidgetThreadDraftArchiveSheet.class.getName());
    }

    public /* synthetic */ WidgetThreadDraftArchiveSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

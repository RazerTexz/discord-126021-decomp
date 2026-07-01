package com.discord.widgets.channels.list;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadArchiveActions$Companion {
    private WidgetThreadArchiveActions$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long channelId, long guildId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetThreadArchiveActions widgetThreadArchiveActions = new WidgetThreadArchiveActions();
        Bundle bundleT = a.T("INTENT_EXTRA_CHANNEL_ID", channelId);
        bundleT.putLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        widgetThreadArchiveActions.setArguments(bundleT);
        widgetThreadArchiveActions.show(fragmentManager, WidgetThreadArchiveActions.class.getName());
    }

    public /* synthetic */ WidgetThreadArchiveActions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

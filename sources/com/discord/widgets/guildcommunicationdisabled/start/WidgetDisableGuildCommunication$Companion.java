package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication$Companion {
    private WidgetDisableGuildCommunication$Companion() {
    }

    public final void launch(long userId, long guildId, Context context) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        intent.putExtra("INTENT_EXTRA_USER_ID", userId);
        j.d(context, WidgetDisableGuildCommunication.class, intent);
        AnalyticsTracker.INSTANCE.viewedDisableCommunicationModal(guildId, userId);
    }

    public /* synthetic */ WidgetDisableGuildCommunication$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

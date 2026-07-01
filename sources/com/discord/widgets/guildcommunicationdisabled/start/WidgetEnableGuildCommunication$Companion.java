package com.discord.widgets.guildcommunicationdisabled.start;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableGuildCommunication$Companion {
    private WidgetEnableGuildCommunication$Companion() {
    }

    public final void launch(long userId, long guildId, FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetEnableGuildCommunication widgetEnableGuildCommunication = new WidgetEnableGuildCommunication();
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_USER_ID", userId);
        bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        widgetEnableGuildCommunication.setArguments(bundleT);
        widgetEnableGuildCommunication.show(fragmentManager, WidgetEnableGuildCommunication.class.getSimpleName());
        AnalyticsTracker.INSTANCE.viewedEnableCommunicationModal(guildId, userId);
    }

    public /* synthetic */ WidgetEnableGuildCommunication$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

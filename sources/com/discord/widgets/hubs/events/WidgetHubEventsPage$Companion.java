package com.discord.widgets.hubs.events;

import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage$Companion {
    private WidgetHubEventsPage$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long guildId, long directoryChannelId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetHubEventsPage widgetHubEventsPage = new WidgetHubEventsPage();
        widgetHubEventsPage.setArguments(d.e2(new HubEventsArgs(guildId, directoryChannelId)));
        widgetHubEventsPage.show(fragmentManager, WidgetHubEventsPage.class.getName());
    }

    public /* synthetic */ WidgetHubEventsPage$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

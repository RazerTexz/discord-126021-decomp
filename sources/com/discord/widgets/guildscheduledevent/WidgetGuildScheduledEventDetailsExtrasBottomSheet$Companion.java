package com.discord.widgets.guildscheduledevent;

import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet$Companion {
    private WidgetGuildScheduledEventDetailsExtrasBottomSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, GuildScheduledEventDetailsArgs args) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(args, "args");
        WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet = new WidgetGuildScheduledEventDetailsExtrasBottomSheet();
        widgetGuildScheduledEventDetailsExtrasBottomSheet.setArguments(d.e2(args));
        widgetGuildScheduledEventDetailsExtrasBottomSheet.show(fragmentManager, WidgetGuildScheduledEventDetailsExtrasBottomSheet.class.getName());
    }

    public /* synthetic */ WidgetGuildScheduledEventDetailsExtrasBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

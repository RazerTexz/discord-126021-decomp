package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.widgets.home.WidgetHome;
import d0.t.m;
import d0.z.d.a0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet$Companion {
    private WidgetGuildScheduledEventDetailsBottomSheet$Companion() {
    }

    public final void enqueue(long guildScheduledEventId) {
        StoreNotices notices = StoreStream.Companion.getNotices();
        String strT = a.t("EVENTDETAILS-", guildScheduledEventId);
        notices.requestToShow(new StoreNotices$Notice(strT, null, 0L, 0, false, m.listOf(a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new WidgetGuildScheduledEventDetailsBottomSheet$Companion$enqueue$guildScheduledEventDetailsNotice$1(guildScheduledEventId, notices, strT), 150, null));
    }

    public final void handleInvalidEvent(Context context) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        b.a.d.m.g(context, 2131892026, 0, null, 12);
    }

    public final void show(FragmentManager fragmentManager, GuildScheduledEventDetailsArgs args) {
        d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
        d0.z.d.m.checkNotNullParameter(args, "args");
        WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet = new WidgetGuildScheduledEventDetailsBottomSheet();
        widgetGuildScheduledEventDetailsBottomSheet.setArguments(d.e2(args));
        widgetGuildScheduledEventDetailsBottomSheet.show(fragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.class.getName());
    }

    public final void showForDirectory(FragmentManager fragmentManager, long guildScheduledEventId, long hubGuildId, long directoryChannelId) {
        d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
        show(fragmentManager, new GuildScheduledEventDetailsArgs(guildScheduledEventId, Long.valueOf(hubGuildId), Long.valueOf(directoryChannelId), GuildScheduledEventDetailsSource.Directory));
    }

    public final void showForGuild(FragmentManager fragmentManager, long guildScheduledEventId) {
        d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
        show(fragmentManager, new GuildScheduledEventDetailsArgs(guildScheduledEventId, null, null, null, 14, null));
    }

    public /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

package com.discord.widgets.guilds.invite;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.home.WidgetHome;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet$Companion {
    private WidgetGuildInviteShareSheet$Companion() {
    }

    public static /* synthetic */ void enqueueNoticeForHomeTab$default(WidgetGuildInviteShareSheet$Companion widgetGuildInviteShareSheet$Companion, Long l, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        widgetGuildInviteShareSheet$Companion.enqueueNoticeForHomeTab(l, j, str);
    }

    private final String getNoticeName() {
        return WidgetGuildInviteShareSheet.class.getSimpleName() + " - " + ClockFactory.get().currentTimeMillis();
    }

    public static /* synthetic */ void show$default(WidgetGuildInviteShareSheet$Companion widgetGuildInviteShareSheet$Companion, FragmentManager fragmentManager, Long l, long j, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        widgetGuildInviteShareSheet$Companion.show(fragmentManager, l, j, str);
    }

    public final void enqueueNoticeForHomeTab(Long channelId, long guildId, String source) {
        m.checkNotNullParameter(source, "source");
        StoreNotices notices = StoreStream.Companion.getNotices();
        notices.requestToShow(new StoreNotices$Notice(getNoticeName(), null, ClockFactory.get().currentTimeMillis(), 0, false, d0.t.m.listOf(a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new WidgetGuildInviteShareSheet$Companion$enqueueNoticeForHomeTab$notice$1(channelId, guildId, source, notices, getNoticeName()), Opcodes.I2C, null));
    }

    public final void show(FragmentManager fragmentManager, Long channelId, long guildId, String source) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(source, "source");
        AnalyticsTracker.INSTANCE.openPopout("Instant Invite", source);
        WidgetGuildInviteShareSheet widgetGuildInviteShareSheet = new WidgetGuildInviteShareSheet();
        Bundle bundle = new Bundle();
        if (channelId != null) {
            bundle.putLong("ARG_CHANNEL_ID", channelId.longValue());
        }
        bundle.putLong("ARG_GUILD_ID", guildId);
        bundle.putString("ARG_ANALYTICS_SOURCE", source);
        widgetGuildInviteShareSheet.setArguments(bundle);
        widgetGuildInviteShareSheet.show(fragmentManager, WidgetGuildInviteShareSheet.class.getName());
    }

    public /* synthetic */ WidgetGuildInviteShareSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

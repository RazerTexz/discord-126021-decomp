package com.discord.widgets.mobile_reports;

import android.content.Context;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMobileReports$Companion {
    private WidgetMobileReports$Companion() {
    }

    public final void launchDirectoryServerReport(Context context, long guildId, long hubId, long channelId) {
        m.checkNotNullParameter(context, "context");
        j.d(context, WidgetMobileReports.class, new MobileReportArgs$DirectoryServer(guildId, hubId, channelId));
    }

    public final void launchGuildScheduledEventReport(Context context, long guildId, long eventId) {
        m.checkNotNullParameter(context, "context");
        j.d(context, WidgetMobileReports.class, new MobileReportArgs$GuildScheduledEvent(guildId, eventId));
    }

    public final void launchMessageReport(Context context, long messageId, long channelId) {
        m.checkNotNullParameter(context, "context");
        j.d(context, WidgetMobileReports.class, new MobileReportArgs$Message(messageId, channelId));
    }

    public final void launchStageChannelReport(Context context, long channelId) {
        m.checkNotNullParameter(context, "context");
        j.d(context, WidgetMobileReports.class, new MobileReportArgs$StageChannel(channelId));
    }

    public /* synthetic */ WidgetMobileReports$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

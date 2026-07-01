package com.discord.widgets.hubs.events;

import com.discord.analytics.generated.events.TrackOpenModal;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage8 extends Lambda implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetHubEventsPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsPage8(WidgetHubEventsPage widgetHubEventsPage) {
        super(0);
        this.this$0 = widgetHubEventsPage;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        RestCallState<List<DirectoryEntryGuild2>> guildScheduledEventsForChannel = StoreStream.INSTANCE.getDirectories().getGuildScheduledEventsForChannel(this.this$0.getArgs().getDirectoryChannelId());
        List<DirectoryEntryGuild2> listInvoke = guildScheduledEventsForChannel != null ? guildScheduledEventsForChannel.invoke() : null;
        if (listInvoke == null) {
            listInvoke = Collections2.emptyList();
        }
        TrackOpenModal trackOpenModal = new TrackOpenModal(null, "Guild Events Modal", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(listInvoke.size()), null, 6291453);
        trackOpenModal.c(new TrackGuild(Long.valueOf(this.this$0.getArgs().getGuildId()), null, null, null, null, null, null, null, null, null, null, null, 4094));
        return trackOpenModal;
    }
}

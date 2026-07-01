package com.discord.widgets.hubs.events;

import androidx.fragment.app.FragmentManager;
import com.discord.analytics.utils.hubs.HubGuildScheduledEventClickType;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities$Companion;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage$listener$1 implements HubEventsEventListener {
    public final /* synthetic */ WidgetHubEventsPage this$0;

    public WidgetHubEventsPage$listener$1(WidgetHubEventsPage widgetHubEventsPage) {
        this.this$0 = widgetHubEventsPage;
    }

    @Override // com.discord.widgets.hubs.events.HubEventsEventListener
    public void dismissHeader() {
        this.this$0.getViewModel().dismissHeader();
    }

    @Override // com.discord.widgets.hubs.events.HubEventsEventListener
    public void fetchGuildScheduledEvents() {
        this.this$0.getViewModel().fetchGuildScheduledEvents();
    }

    @Override // com.discord.widgets.hubs.events.HubEventsEventListener
    public void onCardClicked(HubGuildScheduledEventData eventData) {
        m.checkNotNullParameter(eventData, "eventData");
        DirectoryUtils.INSTANCE.logGuildScheduledEventClickAction(eventData.getEvent().getId(), eventData.getEvent().getGuildId(), this.this$0.getArgs().getGuildId(), HubGuildScheduledEventClickType.JoinServer);
        WidgetGuildScheduledEventDetailsBottomSheet$Companion widgetGuildScheduledEventDetailsBottomSheet$Companion = WidgetGuildScheduledEventDetailsBottomSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetGuildScheduledEventDetailsBottomSheet$Companion.showForDirectory(parentFragmentManager, eventData.getEvent().getId(), this.this$0.getArgs().getGuildId(), this.this$0.getArgs().getDirectoryChannelId());
    }

    @Override // com.discord.widgets.hubs.events.HubEventsEventListener
    public void onPrimaryButtonClicked(HubGuildScheduledEventData eventData) {
        m.checkNotNullParameter(eventData, "eventData");
        DirectoryUtils.INSTANCE.maybeJoinAndGoToGuild(this.this$0, eventData.getEvent(), eventData.isInGuild(), this.this$0.getArgs().getGuildId(), this.this$0.getArgs().getDirectoryChannelId(), !eventData.isRsvped() && GuildScheduledEventUtilitiesKt.canRsvp(eventData.getEvent()), new WidgetHubEventsPage$listener$1$onPrimaryButtonClicked$1(this, eventData));
    }

    @Override // com.discord.widgets.hubs.events.HubEventsEventListener
    public void onSecondaryButtonClicked(HubGuildScheduledEventData eventData) {
        m.checkNotNullParameter(eventData, "eventData");
        this.this$0.getViewModel().toggleRsvp(eventData.getEvent());
    }

    @Override // com.discord.widgets.hubs.events.HubEventsEventListener
    public void onShareClicked(HubGuildScheduledEventData eventData) {
        m.checkNotNullParameter(eventData, "eventData");
        long guildId = eventData.getEvent().getGuildId();
        long id2 = eventData.getEvent().getId();
        Long channelId = eventData.getEvent().getChannelId();
        GuildScheduledEventUtilities$Companion guildScheduledEventUtilities$Companion = GuildScheduledEventUtilities.Companion;
        guildScheduledEventUtilities$Companion.launchInvite(GuildScheduledEventUtilities$Companion.canShareEvent$default(guildScheduledEventUtilities$Companion, channelId, guildId, null, null, null, null, 60, null), this.this$0, guildId, eventData.getChannel(), id2);
    }
}

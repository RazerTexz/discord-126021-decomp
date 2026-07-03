package com.discord.widgets.hubs.events;

import androidx.fragment.app.FragmentManager;
import com.discord.analytics.utils.hubs.HubGuildScheduledEventClickType;
import com.discord.stores.StoreStream;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(eventData, "eventData");
        DirectoryUtils.INSTANCE.logGuildScheduledEventClickAction(eventData.getEvent().getId(), eventData.getEvent().getGuildId(), this.this$0.getArgs().getGuildId(), HubGuildScheduledEventClickType.JoinServer);
        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.showForDirectory(parentFragmentManager, eventData.getEvent().getId(), this.this$0.getArgs().getGuildId(), this.this$0.getArgs().getDirectoryChannelId());
    }

    @Override // com.discord.widgets.hubs.events.HubEventsEventListener
    public void onPrimaryButtonClicked(HubGuildScheduledEventData eventData) {
        C12238m.checkNotNullParameter(eventData, "eventData");
        DirectoryUtils.INSTANCE.maybeJoinAndGoToGuild(this.this$0, eventData.getEvent(), eventData.isInGuild(), this.this$0.getArgs().getGuildId(), this.this$0.getArgs().getDirectoryChannelId(), !eventData.isRsvped() && GuildScheduledEventUtilitiesKt.canRsvp(eventData.getEvent()), new WidgetHubEventsPage$listener$1$onPrimaryButtonClicked$1(this, eventData));
    }

    @Override // com.discord.widgets.hubs.events.HubEventsEventListener
    public void onSecondaryButtonClicked(HubGuildScheduledEventData eventData) {
        C12238m.checkNotNullParameter(eventData, "eventData");
        this.this$0.getViewModel().toggleRsvp(eventData.getEvent());
    }

    @Override // com.discord.widgets.hubs.events.HubEventsEventListener
    public void onShareClicked(HubGuildScheduledEventData eventData) {
        C12238m.checkNotNullParameter(eventData, "eventData");
        long guildId = eventData.getEvent().getGuildId();
        long id2 = eventData.getEvent().getId();
        Long channelId = eventData.getEvent().getChannelId();
        GuildScheduledEventUtilities.Companion companion = GuildScheduledEventUtilities.INSTANCE;
        companion.launchInvite(companion.canShareEvent(channelId, guildId, (60 & 4) != 0 ? StoreStream.INSTANCE.getChannels() : null, (60 & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : null, (60 & 16) != 0 ? StoreStream.INSTANCE.getUsers() : null, (60 & 32) != 0 ? StoreStream.INSTANCE.getPermissions() : null), this.this$0, guildId, eventData.getChannel(), id2);
    }
}

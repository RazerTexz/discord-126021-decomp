package com.discord.widgets.hubs.events;

import androidx.fragment.app.FragmentManager;
import com.discord.analytics.utils.hubs.HubGuildScheduledEventClickType;
import com.discord.stores.StoreStream;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$listener$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage6 implements WidgetHubEventsPage3 {
    public final /* synthetic */ WidgetHubEventsPage this$0;

    public WidgetHubEventsPage6(WidgetHubEventsPage widgetHubEventsPage) {
        this.this$0 = widgetHubEventsPage;
    }

    @Override // com.discord.widgets.hubs.events.WidgetHubEventsPage3
    public void dismissHeader() {
        this.this$0.getViewModel().dismissHeader();
    }

    @Override // com.discord.widgets.hubs.events.WidgetHubEventsPage3
    public void fetchGuildScheduledEvents() {
        this.this$0.getViewModel().fetchGuildScheduledEvents();
    }

    @Override // com.discord.widgets.hubs.events.WidgetHubEventsPage3
    public void onCardClicked(WidgetHubEventsViewModel2 eventData) {
        Intrinsics3.checkNotNullParameter(eventData, "eventData");
        DirectoryUtils.INSTANCE.logGuildScheduledEventClickAction(eventData.getEvent().getId(), eventData.getEvent().getGuildId(), this.this$0.getArgs().getGuildId(), HubGuildScheduledEventClickType.JoinServer);
        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.showForDirectory(parentFragmentManager, eventData.getEvent().getId(), this.this$0.getArgs().getGuildId(), this.this$0.getArgs().getDirectoryChannelId());
    }

    @Override // com.discord.widgets.hubs.events.WidgetHubEventsPage3
    public void onPrimaryButtonClicked(WidgetHubEventsViewModel2 eventData) {
        Intrinsics3.checkNotNullParameter(eventData, "eventData");
        DirectoryUtils.INSTANCE.maybeJoinAndGoToGuild(this.this$0, eventData.getEvent(), eventData.isInGuild(), this.this$0.getArgs().getGuildId(), this.this$0.getArgs().getDirectoryChannelId(), !eventData.isRsvped() && GuildScheduledEventUtilities5.canRsvp(eventData.getEvent()), new WidgetHubEventsPage7(this, eventData));
    }

    @Override // com.discord.widgets.hubs.events.WidgetHubEventsPage3
    public void onSecondaryButtonClicked(WidgetHubEventsViewModel2 eventData) {
        Intrinsics3.checkNotNullParameter(eventData, "eventData");
        this.this$0.getViewModel().toggleRsvp(eventData.getEvent());
    }

    @Override // com.discord.widgets.hubs.events.WidgetHubEventsPage3
    public void onShareClicked(WidgetHubEventsViewModel2 eventData) {
        Intrinsics3.checkNotNullParameter(eventData, "eventData");
        long guildId = eventData.getEvent().getGuildId();
        long id2 = eventData.getEvent().getId();
        Long channelId = eventData.getEvent().getChannelId();
        GuildScheduledEventUtilities.Companion companion = GuildScheduledEventUtilities.INSTANCE;
        companion.launchInvite(companion.canShareEvent(channelId, guildId, (60 & 4) != 0 ? StoreStream.INSTANCE.getChannels() : null, (60 & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : null, (60 & 16) != 0 ? StoreStream.INSTANCE.getUsers() : null, (60 & 32) != 0 ? StoreStream.INSTANCE.getPermissions() : null), this.this$0, guildId, eventData.getChannel(), id2);
    }
}

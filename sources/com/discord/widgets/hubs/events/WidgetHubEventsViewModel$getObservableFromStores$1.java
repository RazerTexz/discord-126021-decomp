package com.discord.widgets.hubs.events;

import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities$Companion;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t.n;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetHubEventsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsViewModel$getObservableFromStores$1 extends o implements Function0<WidgetHubEventsState> {
    public final /* synthetic */ StoreChannels $channelsStore;
    public final /* synthetic */ StoreDirectories $directoriesStore;
    public final /* synthetic */ long $directoryChannelId;
    public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;
    public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;
    public final /* synthetic */ WidgetHubEventsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsViewModel$getObservableFromStores$1(WidgetHubEventsViewModel widgetHubEventsViewModel, StoreDirectories storeDirectories, long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreGuilds storeGuilds) {
        super(0);
        this.this$0 = widgetHubEventsViewModel;
        this.$directoriesStore = storeDirectories;
        this.$directoryChannelId = j;
        this.$channelsStore = storeChannels;
        this.$guildScheduledEventsStore = storeGuildScheduledEvents;
        this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.$permissionsStore = storePermissions;
        this.$guildsStore = storeGuilds;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubEventsState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code duplicated, block: B:27:0x00c7  */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubEventsState invoke() {
        List<HubGuildScheduledEventData> listEmptyList;
        boolean z2;
        RestCallState<List<DirectoryEntryEvent>> guildScheduledEventsForChannel = this.$directoriesStore.getGuildScheduledEventsForChannel(this.$directoryChannelId);
        if (guildScheduledEventsForChannel == null) {
            return WidgetHubEventsViewModel.access$getViewState$p(this.this$0);
        }
        List<DirectoryEntryEvent> listInvoke = guildScheduledEventsForChannel.invoke();
        if (listInvoke != null) {
            listEmptyList = new ArrayList<>(d0.t.o.collectionSizeOrDefault(listInvoke, 10));
            for (DirectoryEntryEvent directoryEntryEvent : listInvoke) {
                long guildId = directoryEntryEvent.getGuildScheduledEvent().getGuildId();
                Long channelId = directoryEntryEvent.getGuildScheduledEvent().getChannelId();
                long j = this.$directoryChannelId;
                GuildScheduledEvent guildScheduledEvent = directoryEntryEvent.getGuildScheduledEvent();
                Channel channel = channelId != null ? this.$channelsStore.getChannel(channelId.longValue()) : null;
                boolean zContains = this.$guildScheduledEventsStore.getMeGuildScheduledEventIds(guildId).contains(Long.valueOf(directoryEntryEvent.getGuildScheduledEvent().getId()));
                GuildScheduledEventUtilities$Companion guildScheduledEventUtilities$Companion = GuildScheduledEventUtilities.Companion;
                boolean zCanStartEvent$default = GuildScheduledEventUtilities$Companion.canStartEvent$default(guildScheduledEventUtilities$Companion, guildId, channelId, null, null, 12, null);
                boolean zCanShareEvent$default = GuildScheduledEventUtilities$Companion.canShareEvent$default(guildScheduledEventUtilities$Companion, channelId, guildId, null, null, null, null, 60, null);
                Long lValueOf = Long.valueOf(this.$voiceChannelSelectedStore.getSelectedVoiceChannelId());
                if (!(lValueOf.longValue() != 0)) {
                    lValueOf = null;
                }
                if (lValueOf != null) {
                    long jLongValue = lValueOf.longValue();
                    if (channelId != null && jLongValue == channelId.longValue()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                listEmptyList.add(new HubGuildScheduledEventData(j, guildScheduledEvent, channel, zContains, zCanShareEvent$default, zCanStartEvent$default, channelId != null ? PermissionUtils.can(Permission.CONNECT, this.$permissionsStore.getPermissionsByChannel().get(Long.valueOf(channelId.longValue()))) : false, z2, this.$guildsStore.getGuild(guildId) != null));
            }
        } else {
            WidgetHubEventsState widgetHubEventsStateAccess$getViewState$p = WidgetHubEventsViewModel.access$getViewState$p(this.this$0);
            List<HubGuildScheduledEventData> eventsData = widgetHubEventsStateAccess$getViewState$p != null ? widgetHubEventsStateAccess$getViewState$p.getEventsData() : null;
            listEmptyList = eventsData != null ? eventsData : n.emptyList();
        }
        return new WidgetHubEventsState(!this.$directoriesStore.getGuildScheduledEventsHeaderDismissed(), listEmptyList, guildScheduledEventsForChannel);
    }
}

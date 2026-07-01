package com.discord.widgets.guildscheduledevent;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelectViewModel$Companion$observeStores$1 extends o implements Function0<WidgetGuildScheduledEventLocationSelectViewModel$StoreState> {
    public final /* synthetic */ StoreChannels $channelsStore;
    public final /* synthetic */ Long $existingGuildScheduledEventId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventLocationSelectViewModel$Companion$observeStores$1(StoreGuilds storeGuilds, long j, StoreChannels storeChannels, StorePermissions storePermissions, Long l, StoreGuildScheduledEvents storeGuildScheduledEvents) {
        super(0);
        this.$guildsStore = storeGuilds;
        this.$guildId = j;
        this.$channelsStore = storeChannels;
        this.$permissionsStore = storePermissions;
        this.$existingGuildScheduledEventId = l;
        this.$guildScheduledEventsStore = storeGuildScheduledEvents;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildScheduledEventLocationSelectViewModel$StoreState invoke() {
        Guild guild = this.$guildsStore.getGuild(this.$guildId);
        Map<Long, Channel> channelsForGuild = this.$channelsStore.getChannelsForGuild(this.$guildId);
        Map<Long, Long> permissionsByChannel = this.$permissionsStore.getPermissionsByChannel();
        Long l = this.$permissionsStore.getGuildPermissions().get(Long.valueOf(this.$guildId));
        Long l2 = this.$existingGuildScheduledEventId;
        return new WidgetGuildScheduledEventLocationSelectViewModel$StoreState(guild, channelsForGuild, permissionsByChannel, l, l2 == null ? null : this.$guildScheduledEventsStore.findEventFromStore(l2.longValue(), Long.valueOf(this.$guildId)));
    }
}

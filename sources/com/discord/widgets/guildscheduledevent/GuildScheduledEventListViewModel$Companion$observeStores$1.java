package com.discord.widgets.guildscheduledevent;

import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventsComparator;
import d0.t.h0;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventListViewModel$Companion$observeStores$1 extends o implements Function0<GuildScheduledEventListViewModel$StoreState> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
    public final /* synthetic */ StoreGuilds $guildStore;
    public final /* synthetic */ StorePermissions $permissionsStore;
    public final /* synthetic */ StoreUser $userStore;
    public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventListViewModel$Companion$observeStores$1(StoreChannels storeChannels, long j, StoreGuildScheduledEvents storeGuildScheduledEvents, Long l, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreVoiceChannelSelected storeVoiceChannelSelected) {
        super(0);
        this.$channelStore = storeChannels;
        this.$guildId = j;
        this.$guildScheduledEventsStore = storeGuildScheduledEvents;
        this.$channelId = l;
        this.$userStore = storeUser;
        this.$guildStore = storeGuilds;
        this.$permissionsStore = storePermissions;
        this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildScheduledEventListViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventListViewModel$StoreState invoke() {
        Map<Long, Channel> channelsForGuild = this.$channelStore.getChannelsForGuild(this.$guildId);
        List guildScheduledEvents$default = StoreGuildScheduledEvents.getGuildScheduledEvents$default(this.$guildScheduledEventsStore, this.$guildId, false, 2, null);
        if (this.$channelId != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : guildScheduledEvents$default) {
                if (m.areEqual(((GuildScheduledEvent) obj).getChannelId(), this.$channelId)) {
                    arrayList.add(obj);
                }
            }
            guildScheduledEvents$default = arrayList;
        }
        List listSortedWith = u.sortedWith(guildScheduledEvents$default, GuildScheduledEventsComparator.INSTANCE);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = listSortedWith.iterator();
        while (it.hasNext()) {
            Long creatorId = ((GuildScheduledEvent) it.next()).getCreatorId();
            if (creatorId != null) {
                arrayList2.add(creatorId);
            }
        }
        Set set = u.toSet(arrayList2);
        Map<Long, User> users = this.$userStore.getUsers(set, true);
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = set.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            long jLongValue = ((Number) it2.next()).longValue();
            User user = users.get(Long.valueOf(jLongValue));
            Pair pair = user != null ? d0.o.to(Long.valueOf(jLongValue), new UserGuildMember(user, this.$guildStore.getMember(this.$guildId, jLongValue))) : null;
            if (pair != null) {
                arrayList3.add(pair);
            }
        }
        Map map = h0.toMap(arrayList3);
        Set<Long> meGuildScheduledEventIds = this.$guildScheduledEventsStore.getMeGuildScheduledEventIds(this.$guildId);
        boolean zCanCreateAnyEvent = GuildScheduledEventUtilities.Companion.canCreateAnyEvent(this.$guildId, this.$channelStore, this.$permissionsStore);
        Map<Long, Long> permissionsByChannel = this.$permissionsStore.getPermissionsByChannel();
        Long lValueOf = Long.valueOf(this.$voiceChannelSelectedStore.getSelectedVoiceChannelId());
        return new GuildScheduledEventListViewModel$StoreState(listSortedWith, meGuildScheduledEventIds, channelsForGuild, map, zCanCreateAnyEvent, lValueOf.longValue() != 0 ? lValueOf : null, permissionsByChannel);
    }
}

package com.discord.widgets.guildscheduledevent;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventListViewModel$Companion {
    private GuildScheduledEventListViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(GuildScheduledEventListViewModel$Companion guildScheduledEventListViewModel$Companion, long j, Long l, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUser storeUser) {
        return guildScheduledEventListViewModel$Companion.observeStores(j, l, storeGuildScheduledEvents, storeChannels, storePermissions, storeGuilds, storeVoiceChannelSelected, storeUser);
    }

    private final Observable<GuildScheduledEventListViewModel$StoreState> observeStores(long guildId, Long channelId, StoreGuildScheduledEvents guildScheduledEventsStore, StoreChannels channelStore, StorePermissions permissionsStore, StoreGuilds guildStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreUser userStore) {
        return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{guildScheduledEventsStore, channelStore, permissionsStore, guildStore, voiceChannelSelectedStore, userStore}, false, null, null, new GuildScheduledEventListViewModel$Companion$observeStores$1(channelStore, guildId, guildScheduledEventsStore, channelId, userStore, guildStore, permissionsStore, voiceChannelSelectedStore), 14, null);
    }

    public /* synthetic */ GuildScheduledEventListViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

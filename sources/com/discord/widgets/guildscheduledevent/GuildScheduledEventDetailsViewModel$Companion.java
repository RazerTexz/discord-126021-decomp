package com.discord.widgets.guildscheduledevent;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel$Companion {
    private GuildScheduledEventDetailsViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(GuildScheduledEventDetailsViewModel$Companion guildScheduledEventDetailsViewModel$Companion, GuildScheduledEventDetailsArgs guildScheduledEventDetailsArgs, ObservationDeck observationDeck, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StorePermissions storePermissions, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreDirectories storeDirectories) {
        return guildScheduledEventDetailsViewModel$Companion.observeStores(guildScheduledEventDetailsArgs, observationDeck, storeGuildScheduledEvents, storeGuilds, storeUser, storeChannels, storePermissions, storeUserSettings, storeVoiceChannelSelected, storeDirectories);
    }

    private final Observable<GuildScheduledEventDetailsViewModel$StoreState> observeStores(GuildScheduledEventDetailsArgs args, ObservationDeck observationDeck, StoreGuildScheduledEvents guildScheduledEventsStore, StoreGuilds guildsStore, StoreUser userStore, StoreChannels channelsStore, StorePermissions permissionsStore, StoreUserSettings userSettingsStore, StoreVoiceChannelSelected selectedVoiceChannelStore, StoreDirectories directoriesStore) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{guildScheduledEventsStore, guildsStore, userStore, channelsStore, permissionsStore, selectedVoiceChannelStore, directoriesStore}, false, null, null, new GuildScheduledEventDetailsViewModel$Companion$observeStores$1(args, directoriesStore, guildScheduledEventsStore, guildsStore, channelsStore, selectedVoiceChannelStore, permissionsStore, userSettingsStore), 14, null);
    }

    public /* synthetic */ GuildScheduledEventDetailsViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

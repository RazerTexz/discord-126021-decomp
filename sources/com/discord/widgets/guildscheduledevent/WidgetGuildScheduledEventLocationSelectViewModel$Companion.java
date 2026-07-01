package com.discord.widgets.guildscheduledevent;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelectViewModel$Companion {
    private WidgetGuildScheduledEventLocationSelectViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(WidgetGuildScheduledEventLocationSelectViewModel$Companion widgetGuildScheduledEventLocationSelectViewModel$Companion, long j, Long l, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return widgetGuildScheduledEventLocationSelectViewModel$Companion.observeStores(j, l, storeGuilds, storeChannels, storePermissions, storeGuildScheduledEvents);
    }

    private final Observable<WidgetGuildScheduledEventLocationSelectViewModel$StoreState> observeStores(long guildId, Long existingGuildScheduledEventId, StoreGuilds guildsStore, StoreChannels channelsStore, StorePermissions permissionsStore, StoreGuildScheduledEvents guildScheduledEventsStore) {
        return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{channelsStore, permissionsStore}, false, null, null, new WidgetGuildScheduledEventLocationSelectViewModel$Companion$observeStores$1(guildsStore, guildId, channelsStore, permissionsStore, existingGuildScheduledEventId, guildScheduledEventsStore), 14, null);
    }

    public /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

package com.discord.widgets.directories;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearchViewModel$Companion {
    private WidgetDirectoriesSearchViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(WidgetDirectoriesSearchViewModel$Companion widgetDirectoriesSearchViewModel$Companion, long j, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StoreChannels storeChannels, StorePermissions storePermissions) {
        return widgetDirectoriesSearchViewModel$Companion.observeStores(j, observationDeck, storeGuilds, storeGuildSelected, storeChannels, storePermissions);
    }

    private final Observable<WidgetDirectoriesSearchViewModel$ViewState> observeStores(long channelId, ObservationDeck observationDeck, StoreGuilds guildsStore, StoreGuildSelected guildSelectedStore, StoreChannels channelsStore, StorePermissions permissionsStore) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{guildsStore, guildSelectedStore, channelsStore, permissionsStore}, false, null, null, new WidgetDirectoriesSearchViewModel$Companion$observeStores$1(permissionsStore, guildsStore, guildSelectedStore, channelId), 14, null);
    }

    public /* synthetic */ WidgetDirectoriesSearchViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

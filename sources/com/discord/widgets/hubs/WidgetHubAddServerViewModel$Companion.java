package com.discord.widgets.hubs;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHubAddServerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServerViewModel$Companion {
    private WidgetHubAddServerViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(WidgetHubAddServerViewModel$Companion widgetHubAddServerViewModel$Companion, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StorePermissions storePermissions, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreDirectories storeDirectories) {
        return widgetHubAddServerViewModel$Companion.observeStores(observationDeck, storeGuilds, storeGuildSelected, storePermissions, storeChannels, storeChannelsSelected, storeDirectories);
    }

    private final Observable<HubAddServerState> observeStores(ObservationDeck observationDeck, StoreGuilds guildsStore, StoreGuildSelected guildsSelected, StorePermissions permissionsStore, StoreChannels channelsStore, StoreChannelsSelected channelsSelectedStore, StoreDirectories directoriesStore) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{guildsStore, guildsSelected, permissionsStore, channelsStore, channelsSelectedStore, directoriesStore}, false, null, null, new WidgetHubAddServerViewModel$Companion$observeStores$1(guildsStore, guildsSelected, permissionsStore, channelsSelectedStore, channelsStore, directoriesStore), 14, null);
    }

    public /* synthetic */ WidgetHubAddServerViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

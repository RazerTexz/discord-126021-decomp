package com.discord.widgets.directories;

import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel$Companion {
    private WidgetDirectoriesViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(WidgetDirectoriesViewModel$Companion widgetDirectoriesViewModel$Companion, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StoreChannelsSelected storeChannelsSelected, StoreDirectories storeDirectories, StorePermissions storePermissions) {
        return widgetDirectoriesViewModel$Companion.observeStores(observationDeck, storeGuilds, storeGuildSelected, storeChannelsSelected, storeDirectories, storePermissions);
    }

    private final Observable<WidgetDirectoriesViewModel$ViewState> observeStores(ObservationDeck observationDeck, StoreGuilds guildsStore, StoreGuildSelected guildSelectedStore, StoreChannelsSelected channelsSelectedStore, StoreDirectories directoriesStore, StorePermissions permissionsStore) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{guildsStore, guildSelectedStore, directoriesStore, channelsSelectedStore, permissionsStore}, false, null, null, new WidgetDirectoriesViewModel$Companion$observeStores$1(channelsSelectedStore, guildSelectedStore, guildsStore, permissionsStore, directoriesStore), 14, null);
    }

    public /* synthetic */ WidgetDirectoriesViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

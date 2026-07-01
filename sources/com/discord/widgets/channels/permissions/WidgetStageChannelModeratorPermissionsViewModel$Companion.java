package com.discord.widgets.channels.permissions;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel$Companion {
    private WidgetStageChannelModeratorPermissionsViewModel$Companion() {
    }

    private final Observable<WidgetStageChannelModeratorPermissionsViewModel$StoreState> observeStores(long channelId, StoreGuilds guildStore, StoreChannels channelStore, StoreUser userStore, StorePermissions permissionStore) {
        return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{guildStore, channelStore, userStore, permissionStore}, false, null, null, new WidgetStageChannelModeratorPermissionsViewModel$Companion$observeStores$1(channelStore, channelId, guildStore, userStore, permissionStore), 14, null);
    }

    public static /* synthetic */ Observable observeStores$default(WidgetStageChannelModeratorPermissionsViewModel$Companion widgetStageChannelModeratorPermissionsViewModel$Companion, long j, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, StorePermissions storePermissions, int i, Object obj) {
        if ((i & 2) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        StoreGuilds storeGuilds2 = storeGuilds;
        if ((i & 4) != 0) {
            storeChannels = StoreStream.Companion.getChannels();
        }
        StoreChannels storeChannels2 = storeChannels;
        if ((i & 8) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        StoreUser storeUser2 = storeUser;
        if ((i & 16) != 0) {
            storePermissions = StoreStream.Companion.getPermissions();
        }
        return widgetStageChannelModeratorPermissionsViewModel$Companion.observeStores(j, storeGuilds2, storeChannels2, storeUser2, storePermissions);
    }

    public /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
